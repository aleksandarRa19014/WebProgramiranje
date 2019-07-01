package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
 
            
            if(this.existUser(u, file.getAbsolutePath())){
            	System.out.println("Postoji korisnik sa tim usernejmom!");
            	return false;
            }
            else{
            	System.out.println("Uspesno ste dodali korisnika!");
            	bw.write(u.toString());
                bw.write("\n");
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
	    Scanner sc;
	    
	    String nextToken = "";
	    
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
				
				nextToken = st.nextToken();

			    if(u.getUserName().equals(nextToken) )
			    	return true;
			    
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	
	public boolean userCheck(LogInDto log)
	{
		
		HashMap<String, String> user = new HashMap<String, String>();
		
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Users.txt");
	    
	    Scanner sc;
	    
	    String userNameToken = "";
	    String passwordToken = "";
	      
	    if(file.length() == 0){
	    	return false;
	    }
	    else{ 
	    	
	    	try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					
					
					StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
					
					userNameToken = st.nextToken();
					passwordToken = st.nextToken();
					
					user.put(userNameToken, passwordToken);
					
					System.out.println(userNameToken + "    "+ passwordToken);				    
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
	    //ako sadrzi kljuc pogladaj da li je vrednost ista
	    if(user.containsKey(log.getUserName()) ){
		    if(user.get(log.getUserName()).equals(log.getPassword()) ){
		    	System.out.println("3333333333");
	    		return true;
		    }else{
		    	System.out.println("4444444444444");
	    		return false;
		    }
	    	
	    }else{
	    	System.out.println("5555555555");
	    	return false;
	    }  
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
		   
		   
		    //file.delete();
		   for(User user :users){
		    	saveUser(user);
		    }
		    
	    }
	}
	
}
