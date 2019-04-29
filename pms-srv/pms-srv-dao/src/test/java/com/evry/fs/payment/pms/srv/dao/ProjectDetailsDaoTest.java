package com.evry.fs.payment.pms.srv.dao;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.FALSE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.TRUE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.WRONG_PROJECT_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDetailsDaoMapper;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/testApplicationContext.xml" })
public class ProjectDetailsDaoTest {
	@Inject
	ProjectDetailsDao projectDetailsDao;
	@PersistenceContext
	EntityManager entityManager;
	@Inject
	ProjectDetailsDaoMapper projectDetailsDaoMapper;

	@Test
	public void testGetProjectInfo() {
		ProjectDetails projectDetails = projectDetailsDao.getProjectInfo(PROJECT_ID);
		assertThat(projectDetails.getProjectId(), is(equalTo(PROJECT_ID)));
		assertThat(projectDetails.getProjectName(), is(equalTo(PROJECT_NAME)));
		assertThat(projectDetails.getProjectStatus(), is(equalTo(PROJECT_STATUS)));
		assertThat(projectDetails.getEstimatedHrs(), is(equalTo(ESTIMATED_HRS)));
		assertThat(projectDetails.getLoggedHrs(), is(equalTo(LOGGED_HRS)));
		assertThat(projectDetails.getRemainingHrs(), is(equalTo(REMAINING_HRS)));
	}

	@Test
	public void testUpdateProject_positive() {
		assertThat(projectDetailsDao.updateProject(PROJECT_ID, PROJECT_NAME), is(equalTo(TRUE)));
	}
	@Test
	public void testUpdateProject_negitive() {
		assertThat(projectDetailsDao.updateProject(WRONG_PROJECT_ID, PROJECT_NAME), is(equalTo(FALSE)));
	}

	@Test
	public void testGetAllProjects() {
		List<ProjectDetails> projectDetailsList = projectDetailsDao.getAllProjects();
		assertThat(projectDetailsList.isEmpty(), is(equalTo(FALSE)));
	}
	
	@Test
	public void testDeleteProject_negitive() {
		assertThat(projectDetailsDao.deleteProject(WRONG_PROJECT_ID), is(equalTo(FALSE)));
	}

	private ProjectDetails getProjectDetails() {
		return ProjectDetails.builder().projectId(PROJECT_ID).projectName(PROJECT_NAME).projectStatus(PROJECT_STATUS)
				.estimatedHrs(ESTIMATED_HRS).loggedHrs(LOGGED_HRS).remainingHrs(REMAINING_HRS).build();
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
}
