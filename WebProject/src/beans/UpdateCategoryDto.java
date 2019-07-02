package beans;

public class UpdateCategoryDto {
	private String oldName;
	private String oldDescription;
	private String newName;
	private String newDescription;
	public UpdateCategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateCategoryDto(String oldName, String oldDescription, String newName, String newDescription) {
		super();
		this.oldName = oldName;
		this.oldDescription = oldDescription;
		this.newName = newName;
		this.newDescription = newDescription;
	}
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getOldDescription() {
		return oldDescription;
	}
	public void setOldDescription(String oldDescription) {
		this.oldDescription = oldDescription;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getNewDescription() {
		return newDescription;
	}
	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}
	
}
