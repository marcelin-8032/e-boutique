package fr.spring.eBoutique.project.enums;

public enum UserRole {

	Client ("Client"),
	Magasinier ("Magasinier"),
	Admin ("Admin");
	
	private String Role;

	private UserRole(String role) {
		this.Role = role;
	}

	public String getValue() {
		return Role;
	}
	
	
}
