package beans;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class Ad {
	private String name;
	private String price;
	private String description;
	private int like;
	private int dislike;
	private BufferedImage image;
	private String updateDate;
	private String dateExpiration;
	private ArrayList<Review> listRev;
	private String city;
	
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad(String name, String price, String description, int like, int dislike, BufferedImage image,
			String updateDate, String dateExpiration, ArrayList<Review> listRev, String city) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.like = like;
		this.dislike = dislike;
		this.image = image;
		this.updateDate = updateDate;
		this.dateExpiration = dateExpiration;
		this.listRev = listRev;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public ArrayList<Review> getListRev() {
		return listRev;
	}

	public void setListRev(ArrayList<Review> listRev) {
		this.listRev = listRev;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
}
