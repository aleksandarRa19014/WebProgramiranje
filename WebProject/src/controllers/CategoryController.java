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
import java.util.Scanner;
import java.util.StringTokenizer;

import beans.Category;
import beans.Role;
import beans.UpdateCategoryDto;
import beans.User;

public class CategoryController {
	
	
	public boolean saveCategory(Category category){
		BufferedWriter bw = null;
	    FileWriter fw = null;
	    try {

	        File file = new File("Category.txt");
	        fw = new FileWriter(file,true);
	        bw = new BufferedWriter(fw);
	        System.out.println("ssss");
	        if(!this.existCategory(category, file.getAbsolutePath())){
		        bw.write(category.getName());
		        bw.write(",");
		        bw.write(category.getDescription());
		        bw.write(",");
		        bw.write("false");
		        bw.newLine();
	        }else{
	        	return false;
	        }
	    }
	    catch (IOException e) {
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
	
	public boolean existCategory(Category categ, String path){
		File file = new File(path); 
	    Scanner sc = null;
	    
	    String nextToken = "";
	    
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				
				
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
				
				nextToken = st.nextToken();
				System.out.println(st.nextToken());
			    if(categ.getName().equals(nextToken) ){
			    	sc.close();
			    	return true;
			    }
			    
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		sc.close();
		System.out.println("22222222222222");
		return false;
	}
	public boolean upCategory(UpdateCategoryDto upcateg){
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Category.txt");
	    String nameToken = "";
	    String descriptionToken = "";
	    Scanner sc = null;
	    
	    ArrayList<Category> upList = new ArrayList<Category>();
	    
	    try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				Category c = new Category();
				
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
				
				nameToken = st.nextToken();
				descriptionToken = st.nextToken();
				
				if(upcateg.getOldName().equals(nameToken)){
					c.setName(upcateg.getNewName());
					c.setDescription(upcateg.getNewDescription());
				}else{
					c.setName(nameToken);
					c.setDescription(descriptionToken);
				}
				
				upList.add(c);
			   
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
	   
	   
	   for(Category categ :upList){
		   saveCategory(categ);
	    }
		
		return true;	
	}
	
	public ArrayList<Category> readCategory(){
		
		ArrayList<Category> categList = new ArrayList<Category>();
		
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Category.txt");
	    Scanner sc;
	      
	    if(file.length() == 0){
	    	return null;
	    }
	    else{ 
	    	
	    	try {
				sc = new Scanner(file);
				while (sc.hasNextLine()) {
					Category c = new Category();
					StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
					c.setName(st.nextToken());
					c.setDescription(st.nextToken());
					String isDelete = st.nextToken();
					
					if(isDelete.equals("false") ){
						System.out.println(isDelete);
						categList.add(c);
					}
					
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
		
		return categList;
	}
	
	
	public boolean deleteCateg(Category delCat){
		Path currentRelativePath = Paths.get("");
	    String s = currentRelativePath.toAbsolutePath().toString();
	    File file = new File(s+ "/" + "Category.txt");
	    String nameToken = "";
	    String descriptionToken = "";
	    String deleteToken = ""; 
	    
	    String line = "";
	    
	    ArrayList<String> lines = new ArrayList<String>();
	    
	    Scanner sc = null;
	    
	    try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
				
				nameToken = st.nextToken();
				descriptionToken = st.nextToken();
				
				if(delCat.getName().equals(nameToken)){
	
					deleteToken = "true";
				}else
				{
					deleteToken = st.nextToken();
					
				}
				
				line = nameToken + "," + descriptionToken +"," + deleteToken;
				lines.add(line);
				
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
	    
	    
	    saveDelCateg(lines);
	    for(String l:lines)
	       {
	    	System.out.println(l);
	       }
	    
		return false;
	}
	
	
	public void saveDelCateg(ArrayList<String> lines){
		BufferedWriter bw = null;
	    FileWriter fw = null;
	    try {

	        File file = new File("Category.txt");
	        fw = new FileWriter(file,true);
	        bw = new BufferedWriter(fw);
	        System.out.println("ssss");
	        
		       for(String line:lines)
		       {
		    	   bw.write(line);
		    	   bw.newLine();
		       }
		        
	        
	    }
	    catch (IOException e) {
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
	}
}
