package com.evry.fs.payment.pms.srv.rs.service.mapper;

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

import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsV19_1WsMapperTest {
	@InjectMocks
	private static ProjectDetailsV19_1WsMapper mapper;

	@Test
	public void testFromWsToDomain_positive() {
		ProjectDetailsType projectDetailsType = getProjectDetailsType();
		ProjectDetails projectDetails = mapper.fromWsToDomain(projectDetailsType);
		assertThatProjectDetailsPositiveScenario(projectDetails);
	}

	@Test
	public void testFromWsToDomain_negitive() {
		ProjectDetailsType projectDetailsType = getProjectDetailsType();
		ProjectDetails projectDetails = mapper.fromWsToDomain(projectDetailsType);
		assertThatProjectDetailsNegitiveScenario(projectDetails);
	}

	@Test
	public void testFromDomainToWsProjectDetails_positive() {
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsType projectDetailsType = mapper.fromDomainToWsProjectDetails(projectDetails);
		assertThatProjectDetailsTypePositiveScenario(projectDetailsType);
	}

	@Test
	public void testFromDomainToWsProjectDetails_negitive() {
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsType projectDetailsType = mapper.fromDomainToWsProjectDetails(projectDetails);
		assertThatProjectDetailsTypeNegitiveScenario(projectDetailsType);
	}

	@Test
	public void testFromDomainToWsListOfProjectDetails_positive() {
		ProjectDetails ProjectDetails = getProjectDetails();
		List<ProjectDetails> ProjectDetailsList = new ArrayList<ProjectDetails>();
		ProjectDetailsList.add(ProjectDetails);
		List<ProjectDetailsType> projectDetailsTypeList = mapper.fromDomainToWsListOfProjectDetails(ProjectDetailsList);
		ProjectDetailsType projectDetailsType = projectDetailsTypeList.get(0);
		assertThatProjectDetailsTypePositiveScenario(projectDetailsType);
	}

	@Test
	public void testFromDomainToWsListOfProjectDetails_negitive() {
		ProjectDetails ProjectDetails = getProjectDetails();
		List<ProjectDetails> ProjectDetailsList = new ArrayList<ProjectDetails>();
		ProjectDetailsList.add(ProjectDetails);
		List<ProjectDetailsType> projectDetailsTypeList = mapper.fromDomainToWsListOfProjectDetails(ProjectDetailsList);
		ProjectDetailsType projectDetailsType = projectDetailsTypeList.get(0);
		assertThatProjectDetailsTypeNegitiveScenario(projectDetailsType);
	}

	private void assertThatProjectDetailsTypePositiveScenario(ProjectDetailsType projectDetailsType) {
		assertThat(projectDetailsType.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetailsType.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetailsType.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetailsType.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetailsType.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetailsType.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	private void assertThatProjectDetailsTypeNegitiveScenario(ProjectDetailsType projectDetailsType) {
		assertThat(projectDetailsType.getProjectId(), is(not(WRONG_PROJECT_ID)));
		assertThat(projectDetailsType.getProjectName(), is(not(WRONG_PROJECT_NAME)));
		assertThat(projectDetailsType.getProjectStatus(), is(not(WRONG_PROJECT_STATUS)));
		assertThat(projectDetailsType.getEstimatedHrs(), is(not(WRONG_ESTIMATED_HRS)));
		assertThat(projectDetailsType.getLoggedHrs(), is(not(WRONG_LOGGED_HRS)));
		assertThat(projectDetailsType.getRemainingHrs(), is(not(WRONG_REMAINING_HRS)));
	}

	private ProjectDetailsType getProjectDetailsType() {
		ProjectDetailsType projectDetailsType = new ProjectDetailsType();
		projectDetailsType.setProjectId(PROJECT_ID);
		projectDetailsType.setProjectName(PROJECT_NAME);
		projectDetailsType.setProjectStatus(PROJECT_STATUS);
		projectDetailsType.setEstimatedHrs(ESTIMATED_HRS);
		projectDetailsType.setLoggedHrs(LOGGED_HRS);
		projectDetailsType.setRemainingHrs(REMAINING_HRS);
		return projectDetailsType;
	}

	private ProjectDetails getProjectDetails() {
		return ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build();
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
