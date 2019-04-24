package com.evry.fs.payment.pms.srv.rs.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Component("projectDetailsV19_1WsMapper")
public class ProjectDetailsV19_1WsMapper {
	/**
	 * 
	 * @param projectDetailsType
	 * @return
	 */
	public ProjectDetails fromWsToDomain(ProjectDetailsType projectDetailsType) {
		return ProjectDetails.builder().projectId(projectDetailsType.getProjectId())
				.projectName(projectDetailsType.getProjectName()).projectStatus(projectDetailsType.getProjectStatus())
				.estimatedHrs(projectDetailsType.getEstimatedHrs()).loggedHrs(projectDetailsType.getLoggedHrs())
				.remainingHrs(projectDetailsType.getRemainingHrs()).build();
	}

	/**
	 * 
	 * @param projectDetails
	 * @return
	 */
	public ProjectDetailsType fromDomainToWsProjectDetails(ProjectDetails projectDetails) {
		ProjectDetailsType projectDetailsType = new ProjectDetailsType();
		projectDetailsType.setProjectId(projectDetails.getProjectId());
		projectDetailsType.setProjectName(projectDetails.getProjectName());
		projectDetailsType.setProjectStatus(projectDetails.getProjectStatus());
		projectDetailsType.setEstimatedHrs(projectDetails.getEstimatedHrs());
		projectDetailsType.setLoggedHrs(projectDetails.getLoggedHrs());
		projectDetailsType.setRemainingHrs(projectDetails.getRemainingHrs());
		return projectDetailsType;
	}

	/**
	 * 
	 * @param ProjectDetailsList
	 * @return
	 */
	public List<ProjectDetailsType> fromDomainToWsListOfProjectDetails(List<ProjectDetails> ProjectDetailsList) {
		List<ProjectDetailsType> projectDetailsTypeList = new ArrayList<ProjectDetailsType>();
		for (ProjectDetails projectDetails : ProjectDetailsList) {
			projectDetailsTypeList.add(fromDomainToWsProjectDetails(projectDetails));
		}
		return projectDetailsTypeList;
	}

}
