package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Category;
import beans.UpdateCategoryDto;
import beans.User;
import controllers.CategoryController;
import controllers.UserController;



@Path("/crudCategory")
public class CrudCategoryService {
	private CategoryController ctgCtrl= new CategoryController();
	
	@POST
	@Path("/createCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Category createCategory(Category category) {
		
		if(ctgCtrl.saveCategory(category)){
			return category;	
		}else{
			return null;
		}
	}
	
	
	@POST
	@Path("/updateCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Category updateCategory(UpdateCategoryDto upcateg) {
		Category updatedCateg = new Category();
		
		if(ctgCtrl.upCategory(upcateg)){
			updatedCateg.setName(upcateg.getNewName());
			updatedCateg.setDescription(upcateg.getNewDescription());
			return updatedCateg;	
		}else{
			return null;
		}
	}
	
	
	@GET
	@Path("/getCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Category> getCategories(){
		
		ArrayList<Category> categories = new ArrayList<Category>();
		categories = ctgCtrl.readCategory();
		
		return categories;
		
	}
	
	
	@POST
	@Path("/deleteCategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Category deleteCategory(Category delCateg) {
		ctgCtrl.deleteCateg(delCateg);
		return delCateg;
		
	}
	
}
