package beans;

import java.util.Date;

public class User {
	
	private String userName;
	private String password;
	private String name;
	private String lastName;
	private Role role;
	private String contactPh;
	private String town;
	private String email;
	private java.util.Date regDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String password, String name, String lastName, Role role, String email, Date regDate) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.role = role;
		this.email = email;
		this.regDate = regDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getContactPh() {
		return contactPh;
	}

	public void setContactPh(String contactPh) {
		this.contactPh = contactPh;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getRegDate() {
		return regDate;
	}

	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
}
