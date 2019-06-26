package beans;

import java.util.ArrayList;

public class Category {
	
	
	private String name;
	private String description;
	private ArrayList<Ad> ads;

	public Category(String name, String description, ArrayList<Ad> ads) {
		super();
		this.name = name;
		this.description = description;
		this.ads = ads;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Ad> getAds() {
		return ads;
	}
	public void setAds(ArrayList<Ad> ads) {
		this.ads = ads;
	}
	
	@Override
	public String toString() {
		return  name + "," + description + "," + ads;
	}
}
