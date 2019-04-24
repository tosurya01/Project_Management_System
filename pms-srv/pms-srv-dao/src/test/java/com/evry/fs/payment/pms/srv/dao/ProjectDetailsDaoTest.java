package com.evry.fs.payment.pms.srv.dao;

import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.ESTIMATED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.FALSE;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.LOGGED_HRS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_ID;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_NAME;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.PROJECT_STATUS;
import static com.evry.fs.payment.pms.srv.testdata.ProjectDetailsTestDataConstants.REMAINING_HRS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.evry.fs.payment.pms.srv.dao.entity.ProjectDetailsEntity;
import com.evry.fs.payment.pms.srv.dao.internal.ProjectDetailsDaoImpl;
import com.evry.fs.payment.pms.srv.dao.mapper.ProjectDetailsDaoMapper;
import com.evry.fs.payment.pms.srv.model.ProjectDetails;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext.xml" })
public class ProjectDetailsDaoTest {
	@Inject
	ProjectDetailsDaoImpl projectDetailsDao;
//	@PersistenceContext
//	EntityManager entityManager;
	@Mock
	ProjectDetailsDaoMapper projectDetailsDaoMapper;

//	@Test
//	public void testAddProject_negitive() {
//		ProjectDetails projectDetails = getProjectDetails();
//		ProjectDetailsEntity projectDetailsEntity = getProjectDetailsEntity();
//		when(projectDetailsDaoMapper.fromModelToEntity(projectDetails)).thenReturn(projectDetailsEntity);
//		//when(entityManager.contains(projectDetailsEntity)).thenReturn(FALSE);
//		boolean flag = projectDetailsDao.addProject(projectDetails);
//		assertThat(flag, is(false));
//	}
//
//	@Test
//	public void testGetProjectInfo_negitive() {
//		projectDetailsDao.getProjectInfo(PROJECT_ID);
//		// when()
//	}

	@Test
	public void testUpdateProject() {
	}

	@Test
	public void testGetAllProjects() {
	}

	@Test
	public void testDeleteProject() {
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
