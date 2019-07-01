package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.ChangeRoleDto;
import beans.LogInDto;
import beans.User;
import controllers.UserController;

@Path("/users")
public class UserService {
	
	private UserController userCtrl= new UserController();
	
	
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> getUsers(){
		userCtrl = new UserController();
		ArrayList<User> users = new ArrayList<User>();
		users = userCtrl.readUsers();
		
		return users;
		
	}
	
	@POST
	@Path("/changeRole")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ChangeRoleDto changeRole(ChangeRoleDto changeRoleDto) {
		
		
		userCtrl.changeUserRole(changeRoleDto);
		return changeRoleDto;
	}

}
