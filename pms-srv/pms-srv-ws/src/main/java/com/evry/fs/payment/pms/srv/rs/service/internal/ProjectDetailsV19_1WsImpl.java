package com.evry.fs.payment.pms.srv.rs.service.internal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evry.fs.payment.pms.ProjectDetailsType;
import com.evry.fs.payment.pms.srv.rs.service.ProjectDetailsV19_1Ws;
import com.evry.fs.payment.pms.srv.rs.service.mapper.ProjectDetailsV19_1WsMapper;
import com.evry.fs.payment.pms.srv.service.ProjectDetailsService;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Service("projectDetails")
public class ProjectDetailsV19_1WsImpl implements ProjectDetailsV19_1Ws {
	private final ProjectDetailsV19_1WsMapper projectDetailsV19_1WsMapper;
	private final ProjectDetailsService projectDetailsService;

	/**
	 * 
	 * @param projectDetailsV19_1WsMapper
	 * @param projectDetailsService
	 */
	@Autowired
	public ProjectDetailsV19_1WsImpl(final ProjectDetailsV19_1WsMapper projectDetailsV19_1WsMapper,
			final ProjectDetailsService projectDetailsService) {
		this.projectDetailsV19_1WsMapper = projectDetailsV19_1WsMapper;
		this.projectDetailsService = projectDetailsService;
	}

	@Override
	public boolean addProject(ProjectDetailsType projectDetailsType) {
		return projectDetailsService.addProject(projectDetailsV19_1WsMapper.fromWsToDomain(projectDetailsType));

	}

	@Override
	public ProjectDetailsType getProjectInfo(int projectId) {
		return projectDetailsV19_1WsMapper.fromDomainToWsProjectDetails(projectDetailsService.getProjectInfo(projectId));
	}

	@Override
	public boolean updateProject(int projectId, String projectName) {
		return projectDetailsService.updateProject(projectId, projectName);
	}

	@Override
	public List<ProjectDetailsType> getAllProjects() {
		return projectDetailsV19_1WsMapper.fromDomainToWsListOfProjectDetails(projectDetailsService.getAllProjects());
	}

	@Override
	public boolean deleteProject(int projectId) {
		return projectDetailsService.deleteProject(projectId);
	}
}
