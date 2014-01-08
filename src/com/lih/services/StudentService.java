package com.lih.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;


import com.lih.dao.StudentDAO;
import com.lih.entity.Marks;

@Path("/student")
public class StudentService {
	@Autowired
	StudentDAO studentDAO;
	
	@POST
	@Produces("text/plain")
	@Path("/persist")
	public Response persist(@Context final HttpServletRequest request,
			@FormParam("name") final String name,
			@FormParam("avg") final String avg) {
		
		if(studentDAO.addStudentEntry(new Marks(name,avg))){
			return Response.status(Response.Status.OK).type("text/plain")
					.entity("success").build();
		}
		return Response.status(Response.Status.BAD_REQUEST).type("text/plain")
				.entity("Bad Request").build();
		
	}
	
	@POST
	@Produces("text/plain")
	@Path("/persistDouble")
	public Response persistDouble(@Context final HttpServletRequest request,
			@FormParam("name") final String name,
			@FormParam("avg") final String avg, 
			@FormParam("name1") final String name1,
			@FormParam("avg1") final String avg1 ) {
		
		if(studentDAO.addRollbackEntry(new Marks(name,avg),new Marks(name1,avg1))){
			return Response.status(Response.Status.OK).type("text/plain")
					.entity("success").build();
		}
		return Response.status(Response.Status.BAD_REQUEST).type("text/plain")
				.entity("Bad Request").build();
		
	}
}
