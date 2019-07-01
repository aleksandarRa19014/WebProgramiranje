package beans;

public class ChangeRoleDto {
	private String role;
	private String userName;
	
	public ChangeRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChangeRoleDto(String role, String userName) {
		super();
		this.role = role;
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
