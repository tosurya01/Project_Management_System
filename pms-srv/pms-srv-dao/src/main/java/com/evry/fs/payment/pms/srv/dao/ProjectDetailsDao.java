package com.evry.fs.payment.pms.srv.dao;

import java.util.List;

import com.evry.fs.payment.pms.srv.model.ProjectDetails;

public interface ProjectDetailsDao {
	/**
	 * 
	 * @param projectDetails
	 * @return
	 */
	public boolean addProject(ProjectDetails projectDetails);

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public ProjectDetails getProjectInfo(int projectId);

	/**
	 * 
	 * @param projectId
	 * @param projectName
	 * @return
	 */
	public boolean updateProject(int projectId, String projectName);

	/**
	 * 
	 * @return
	 */
	public List<ProjectDetails> getAllProjects();

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	public boolean deleteProject(int projectId);
}
