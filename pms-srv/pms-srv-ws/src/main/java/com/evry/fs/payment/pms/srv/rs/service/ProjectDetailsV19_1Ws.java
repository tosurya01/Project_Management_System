package com.evry.fs.payment.pms.srv.rs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.evry.fs.payment.pms.ProjectDetailsType;

/**
 * 
 * @author venkata.kuppili
 *
 */
@Path("/project")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public interface ProjectDetailsV19_1Ws {
	/**
	 * 
	 * @param projectType
	 */
	@POST
	@Path("addProject")
	public boolean addProject(final ProjectDetailsType projectDetailsType);

	/**
	 * 
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("projectInfo/{projectId}")
	public ProjectDetailsType getProjectInfo(@PathParam("projectId") final int projectId);

	/**
	 * 
	 * @param projectId
	 * @param projectName
	 */
	@PUT
	@Path("updateProject/{projectId}/{projectName}")
	public boolean updateProject(@PathParam("projectId") final int projectId,
			@PathParam("projectName") final String projectName);

	/**
	 * 
	 * @return
	 */
	@GET
	@Path("projects")
	public List<ProjectDetailsType> getAllProjects();

	/**
	 * 
	 * @param projectId
	 */
	@DELETE
	@Path("deleteProject/{projectId}")
	public boolean deleteProject(@PathParam("projectId") final int projectId);

}
