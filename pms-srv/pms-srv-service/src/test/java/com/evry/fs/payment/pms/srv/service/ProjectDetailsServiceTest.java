package com.evry.fs.payment.pms.srv.service;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.TRUE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.FALSE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_PROJECT_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.evry.fs.payment.pms.srv.dao.ProjectDetailsDao;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;
import com.evry.fs.payment.pms.srv.service.internal.ProjectDetailsServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProjectDetailsServiceTest {
	@InjectMocks
	private ProjectDetailsService projectDetailsService = new ProjectDetailsServiceImpl();
	@Mock
	private ProjectDetailsDao projectDetailsDaoMock;
	private ProjectDetails projectDetails;

	@Before
	public void setUp() {
		projectDetails = getProjectDetails();
	}

	@Test
	public void testAddProject_positive() {
		when(projectDetailsDaoMock.addProject(projectDetails)).thenReturn(TRUE);
		assertThat(projectDetailsService.addProject(projectDetails), is(equalTo(TRUE)));
	}

	@Test
	public void testAddProject_negitive() {
		when(projectDetailsDaoMock.addProject(projectDetails)).thenReturn(FALSE);
		assertThat(projectDetailsService.addProject(projectDetails), is(equalTo(FALSE)));
	}

	@Test
	public void testGetProjectInfo() {
		when(projectDetailsDaoMock.getProjectInfo(PROJECT_ID)).thenReturn(projectDetails);
		assertThat(projectDetailsService.getProjectInfo(PROJECT_ID), is(equalTo(projectDetails)));
	}

	@Test
	public void testUpdateProject_positive() {
		when(projectDetailsDaoMock.updateProject(PROJECT_ID, PROJECT_NAME)).thenReturn(TRUE);
		assertThat(projectDetailsService.updateProject(PROJECT_ID, PROJECT_NAME), is(equalTo(TRUE)));
	}

	@Test
	public void testUpdateProject_negitive() {
		when(projectDetailsDaoMock.updateProject(PROJECT_ID, PROJECT_NAME)).thenReturn(FALSE);
		assertThat(projectDetailsService.updateProject(PROJECT_ID, PROJECT_NAME), is(equalTo(FALSE)));
	}

	@Test
	public void testGetAllProjects_positive() {
		List<ProjectDetails> ProjectDetailsList = new ArrayList<ProjectDetails>();
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsList.add(projectDetails);
		when(projectDetailsDaoMock.getAllProjects()).thenReturn(ProjectDetailsList);
		assertThat(projectDetailsService.getAllProjects().get(0).getProjectId(), is(PROJECT_ID));
	}

	@Test
	public void testGetAllProjects_negitive() {
		List<ProjectDetails> ProjectDetailsList = new ArrayList<ProjectDetails>();
		ProjectDetails projectDetails = getProjectDetails();
		ProjectDetailsList.add(projectDetails);
		when(projectDetailsDaoMock.getAllProjects()).thenReturn(ProjectDetailsList);
		assertThat(projectDetailsService.getAllProjects().get(0).getProjectId(), is(not(WRONG_PROJECT_ID)));
	}

	@Test
	public void testDeleteProject_positive() {
		when(projectDetailsDaoMock.deleteProject(PROJECT_ID)).thenReturn(TRUE);
		assertThat(projectDetailsService.deleteProject(PROJECT_ID), is(equalTo(TRUE)));
	}

	@Test
	public void testDeleteProject_negitive() {
		when(projectDetailsDaoMock.deleteProject(PROJECT_ID)).thenReturn(FALSE);
		assertThat(projectDetailsService.deleteProject(PROJECT_ID), is(equalTo(FALSE)));
	}

	private ProjectDetails getProjectDetails() {
		return ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build();
	}

}
