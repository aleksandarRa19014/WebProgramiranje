package services;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import beans.Role;
import beans.User;
import controllers.UserController;

import javax.ws.rs.Path;

@Path("/user")
public class SingUpService {
	
	private UserController listUserCtrl;

	
	@POST
	@Path("/singUp")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User singUp(User u) {
		listUserCtrl = new UserController();
		User newUser = new User();
		newUser.setContactPh(u.getContactPh());
		newUser.setEmail(u.getEmail());
		newUser.setLastName(u.getLastName());
		newUser.setName(u.getName());
		newUser.setPassword(u.getPassword());
		
		Date date = new Date(System.currentTimeMillis());  
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		
		newUser.setRegDate(formatter.format(date));
		
		newUser.setRole(Role.buyer);
		newUser.setTown(u.getTown());
		newUser.setUserName(u.getUserName());
		
		if(listUserCtrl.saveUser(newUser)){
			return newUser;
		}else{
			return null;
		}

		
	}
	
	
	
	
	
	
	
}
