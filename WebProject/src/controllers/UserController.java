package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import beans.ChangeRoleDto;
import beans.LogInDto;
import beans.Role;
import beans.User;

public class UserController {

	public boolean saveUser(User u){

		BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            File file = new File("Users.txt");
            fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);
            
            String username = "aleksandar995";
            if(file.length() == 0){
            	Date date = new Date(System.currentTimeMillis());  
        		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
            	
        		User admin = new User("aleksandar995","12345","Aleksandar","Radovanovic",Role.admin,"aleksandarradovanovic95@gmail.com",formatter.format(date));
            	
            	bw.write(admin.toString());
                bw.write("\n");
    	    }
            
            if(this.existUser(u, file.getAbsolutePath())){
            	System.out.println("Postoji korisnik sa tim usernejmom!");
            	return false;
            }
            else{
            	System.out.println("Uspesno ste dodali korisnika!");
            	if(!u.getUserName().equals(username)){
            		bw.write(u.toString());
            		bw.write("\n");
            	}
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
		return true;
		
	}
	
	public boolean existUser(User u,String path){
		
		File file = new File(path); 
	    Scanner sc = null;
	    
	    String nextToken = "";
	    
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
				
				nextToken = st.nextToken();

			    if(u.getUserName().equals(nextToken) )
			    	sc.close();
			    	return true;
			    
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		sc.close();
		return false;
	}
	
	
	public User userCheck(LogInDto log)
	{
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Users.txt");
	    
	    Scanner sc = null;
	    
	    String userNameToken = "";
	    String passwordToken = "";
	      
	    if(file.length() == 0){
	    	return null;
	    }
	    else{ 
	    	
	    	try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					
					User user = new User();
					StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
					userNameToken = st.nextToken();
					passwordToken = st.nextToken();
					if(log.getUserName().equals(userNameToken) && log.getPassword().equals(passwordToken)){
						user.setUserName(userNameToken);
						user.setPassword(passwordToken);
						user.setName(st.nextToken());
						user.setLastName(st.nextToken());
						switch(st.nextToken()) {
						  case "buyer":
							  user.setRole(Role.buyer);
						    break;
						  case "admin":
							  user.setRole(Role.admin);
						    break;
						  case "seller":
							  user.setRole(Role.seller);
							    break;
						}
						user.setContactPh(st.nextToken());
						user.setTown(st.nextToken());
						user.setEmail(st.nextToken());
						user.setRegDate(st.nextToken());
						sc.close();
						return user;
					}
					
									    
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
	    sc.close();
	    return null;
	}
	
	
	public  ArrayList<User> readUsers(){
		
		ArrayList<User> users = new ArrayList<User>();
		
		
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Users.txt");
	    
	    Scanner sc;
	      
	    if(file.length() == 0){
	    	return null;
	    }
	    else{ 
	    	
	    	try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					User user = new User();
					
					StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
					
					user.setUserName(st.nextToken());
					user.setPassword(st.nextToken());
					user.setName(st.nextToken());
					user.setLastName(st.nextToken());
					switch(st.nextToken()) {
					  case "buyer":
						  user.setRole(Role.buyer);
					    break;
					  case "admin":
						  user.setRole(Role.admin);
					    break;
					  case "seller":
						  user.setRole(Role.seller);
						    break;
					}
					user.setContactPh(st.nextToken());
					user.setTown(st.nextToken());
					user.setEmail(st.nextToken());
					user.setRegDate(st.nextToken());
					
					users.add(user);
					
					
					    
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
		return users;
	}
	
	
	public void changeUserRole(ChangeRoleDto chr){
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Users.txt");
	    Scanner sc;
	    String usernameToken = "";
	    String chUserName = "";
	    String roleToken = "";
	    
	    ArrayList<User> users = new ArrayList<User>();
	    
	    if(file.length() != 0){
		    try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					User user = new User();
					
					StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
					
					usernameToken = st.nextToken();
					chUserName = chr.getUserName();
					
					user.setUserName(usernameToken);
					user.setPassword(st.nextToken());
					user.setName(st.nextToken());
					user.setLastName(st.nextToken());
					roleToken = st.nextToken();
					
					if(chUserName.equals(usernameToken)){
						
						switch(chr.getRole()) {
						  case "buyer":
							  user.setRole(Role.buyer);
						    break;
						  case "admin":
							  user.setRole(Role.admin);
						    break;
						  case "seller":
							  user.setRole(Role.seller);
							    break;
						}
						
					}else{
						
						switch(roleToken) {
						  case "buyer":
							  user.setRole(Role.buyer);
						    break;
						  case "admin":
							  user.setRole(Role.admin);
						    break;
						  case "seller":
							  user.setRole(Role.seller);
							    break;
						}
						
						
					}
					
					
					user.setContactPh(st.nextToken());
					user.setTown(st.nextToken());
					user.setEmail(st.nextToken());
					user.setRegDate(st.nextToken());
				
					users.add(user);    
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   
		    BufferedWriter writer;
			try {
				writer = Files.newBufferedWriter(Paths.get(file.getPath()));
				 writer.write("");
				    writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		   
		   for(User user :users){
		    	saveUser(user);
		    }
		    
	    }
	}
	
}
