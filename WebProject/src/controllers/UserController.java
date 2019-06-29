package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

import beans.LogInDto;
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
}
