package com.evry.fs.payment.pms.srv.dao.internal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDetailsDaoMapper;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Repository("projectDetailsDao")
public class ProjectDetailsDaoImpl implements ProjectDetailsDao {
	@PersistenceContext
    EntityManager entityManager;
	private final ProjectDetailsDaoMapper projectDetailsDaoMapper;

	/**
	 * 
	 * @param projectDetailsDaoMapper
	 */
	@Autowired
	public ProjectDetailsDaoImpl(final ProjectDetailsDaoMapper projectDetailsDaoMapper) {
		this.projectDetailsDaoMapper = projectDetailsDaoMapper;
	}

	@Transactional
	public boolean addProject(ProjectDetails projectDetails) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = projectDetailsDaoMapper.fromModelToEntity(projectDetails);
		if (entityManager.contains(projectDetailsEntity)) {
			entityManager.persist(projectDetailsEntity);
			flag = true;
		}
		return flag;
	}

	public ProjectDetails getProjectInfo(int projectId) {
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class, projectId);
		return projectDetailsDaoMapper.fromEntityToModel(projectDetailsEntity);
	}

	@Transactional
	public boolean updateProject(int projectId, String projectName) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class, projectId);
		if (null != projectDetailsEntity) {
			projectDetailsEntity.setProjectName(projectName);
			entityManager.merge(projectDetailsEntity);
			flag = true;
		}
		return flag;
	}

	public List<ProjectDetails> getAllProjects() {
		Query query = entityManager.createQuery("FROM ProjectDetailsEntity");
		return projectDetailsDaoMapper.projectDetailsEntityListToProjectDetailsList(query.getResultList());
	}

	@Transactional
	public boolean deleteProject(int projectId) {
		boolean flag = false;
		ProjectDetailsEntity projectDetailsEntity = entityManager.find(ProjectDetailsEntity.class, projectId);
		if (null != projectDetailsEntity) {
			entityManager.remove(projectDetailsEntity);
			flag = true;
		}
		return flag;
	}

}
