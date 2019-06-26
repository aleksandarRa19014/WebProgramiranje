package services;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;

import beans.Category;
import beans.User;

import javax.ws.rs.Path;

@Path("/user")
public class SingUpService {
	@GET
	@Path("/test")
	public String test() {
		return "REST is working";
	}
	
	
	
	@POST
	@Path("/singUp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User singUp(User u) {
		
		User newUser = new User();
		newUser.setContactPh(u.getContactPh());
		newUser.setEmail(u.getEmail());
		newUser.setLastName(u.getLastName());
		newUser.setName(u.getName());
		newUser.setPassword(u.getPassword());
		newUser.setRegDate(u.getRegDate());
		newUser.setRole(u.getRole());
		newUser.setTown(u.getTown());
		newUser.setUserName(u.getUserName());
		
		System.out.println(newUser.getName());
		
		
		
		return u;
	}
	
	
	
	
	
	
	
}
