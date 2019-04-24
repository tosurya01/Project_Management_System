package com.evry.fs.payment.pms.srv.dao.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectDetailsDaoMapper")
public class ProjectDetailsDaoMapper {
	/**
	 * 
	 * @param projectDetails
	 * @return
	 */
	public ProjectDetailsEntity fromModelToEntity(ProjectDetails projectDetails) {
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(projectDetails.getProjectId());
		projectDetailsEntity.setProjectName(projectDetails.getProjectName());
		projectDetailsEntity.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsEntity.setEstimatedHrs(projectDetails.getEstimatedHrs());
		projectDetailsEntity.setLoggedHrs(projectDetails.getLoggedHrs());
		projectDetailsEntity.setRemainingHrs(projectDetails.getRemainingHrs());
		return projectDetailsEntity;
	}

	/**
	 * 
	 * @param projectDetailsEntity
	 * @return
	 */
	public ProjectDetails fromEntityToModel(ProjectDetailsEntity projectDetailsEntity) {
		return ProjectDetails.builder().projectId(projectDetailsEntity.getProjectId())
				.projectName(projectDetailsEntity.getProjectName())
				.projectStatus(projectDetailsEntity.getProjectStatus())
				.estimatedHrs(projectDetailsEntity.getEstimatedHrs()).loggedHrs(projectDetailsEntity.getLoggedHrs())
				.remainingHrs(projectDetailsEntity.getRemainingHrs()).build();
	}

	/**
	 * 
	 * @param projectDetailsEntityList
	 * @return
	 */
	public List<ProjectDetails> projectDetailsEntityListToProjectDetailsList(
			List<ProjectDetailsEntity> projectDetailsEntityList) {
		List<ProjectDetails> projectDetailsList = new ArrayList<ProjectDetails>();
		for (ProjectDetailsEntity ProjectDetailsEntity : projectDetailsEntityList) {
			projectDetailsList.add(fromEntityToModel(ProjectDetailsEntity));
		}
		return projectDetailsList;
	}

}
