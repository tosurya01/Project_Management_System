package com.evry.fs.payment.pms.srv.dao.mapper;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_REMAINING_HRS;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsDaoMapperTest {
	@InjectMocks
	private ProjectDetailsDaoMapper mapper;

	@Test
	public void testFromModelToEntity_positive() {
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsEntity projectDetailsEntity = mapper.fromModelToEntity(projectDetails);
		assertThatProjectDetailsEntityPositiveScenario(projectDetailsEntity);
	}

	@Test
	public void testFromModelToEntity_negitive() {
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsEntity projectDetailsEntity = mapper.fromModelToEntity(projectDetails);
		assertThatProjectDetailsEntityNegitiveScenario(projectDetailsEntity);
	}

	@Test
	public void testFromEntityToModel_positive() {
		ProjectDetailsEntity projectDetailsEntity = getProjectDetailsEntity();
		ProjectDetails projectDetails = mapper.fromEntityToModel(projectDetailsEntity);
		assertThatProjectDetailsPositiveScenario(projectDetails);
	}

	@Test
	public void testFromEntityToModel_negitive() {
		ProjectDetailsEntity projectDetailsEntity = getProjectDetailsEntity();
		ProjectDetails projectDetails = mapper.fromEntityToModel(projectDetailsEntity);
		assertThatProjectDetailsNegitiveScenario(projectDetails);
	}

	@Test
	public void testProjectDetailsEntityListToProjectDetailsList_positive() {
		ProjectDetailsEntity projectDetailsEntity = getProjectDetailsEntity();
		List<ProjectDetailsEntity> projectDetailsEntityList = new ArrayList<ProjectDetailsEntity>();
		projectDetailsEntityList.add(projectDetailsEntity);
		List<ProjectDetails> projectDetailsList = mapper
				.projectDetailsEntityListToProjectDetailsList(projectDetailsEntityList);
		ProjectDetails projectDetails = projectDetailsList.get(0);
		assertThatProjectDetailsPositiveScenario(projectDetails);
	}

	@Test
	public void testProjectDetailsEntityListToProjectDetailsList_negitive() {
		ProjectDetailsEntity projectDetailsEntity = getProjectDetailsEntity();
		List<ProjectDetailsEntity> projectDetailsEntityList = new ArrayList<ProjectDetailsEntity>();
		projectDetailsEntityList.add(projectDetailsEntity);
		List<ProjectDetails> projectDetailsList = mapper
				.projectDetailsEntityListToProjectDetailsList(projectDetailsEntityList);
		ProjectDetails projectDetails = projectDetailsList.get(0);
		assertThatProjectDetailsNegitiveScenario(projectDetails);
	}

	private ProjectDetails getProjectDetails() {
		return ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build();
	}

	private void assertThatProjectDetailsEntityPositiveScenario(ProjectDetailsEntity projectDetailsEntity) {
		assertThat(projectDetailsEntity.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetailsEntity.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetailsEntity.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetailsEntity.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetailsEntity.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetailsEntity.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	private void assertThatProjectDetailsEntityNegitiveScenario(ProjectDetailsEntity projectDetailsEntity) {
		assertThat(projectDetailsEntity.getProjectId(), is(not(WRONG_PROJECT_ID)));
		assertThat(projectDetailsEntity.getProjectName(), is(not(WRONG_PROJECT_NAME)));
		assertThat(projectDetailsEntity.getProjectStatus(), is(not(WRONG_PROJECT_STATUS)));
		assertThat(projectDetailsEntity.getEstimatedHrs(), is(not(WRONG_ESTIMATED_HRS)));
		assertThat(projectDetailsEntity.getLoggedHrs(), is(not(WRONG_LOGGED_HRS)));
		assertThat(projectDetailsEntity.getRemainingHrs(), is(not(WRONG_REMAINING_HRS)));
	}

	private ProjectDetailsEntity getProjectDetailsEntity() {
		ProjectDetailsEntity projectDetailsEntity = new ProjectDetailsEntity();
		projectDetailsEntity.setProjectId(PROJECT_ID);
		projectDetailsEntity.setProjectName(PROJECT_NAME);
		projectDetailsEntity.setProjectStatus(PROJECT_STATUS);
		projectDetailsEntity.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsEntity.setLoggedHrs(LOGGED_HRS);
		projectDetailsEntity.setRemainingHrs(REMAINING_HRS);
		return projectDetailsEntity;
	}

	private void assertThatProjectDetailsPositiveScenario(ProjectDetails projectDetails) {
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	private void assertThatProjectDetailsNegitiveScenario(ProjectDetails projectDetails) {
		assertThat(projectDetails.getProjectId(), is(not(WRONG_PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(not(WRONG_PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(not(WRONG_PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(not(WRONG_ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(not(WRONG_LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(not(WRONG_REMAINING_HRS)));
	}

}
