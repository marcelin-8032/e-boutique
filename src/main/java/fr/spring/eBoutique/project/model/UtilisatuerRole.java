package fr.spring.eBoutique.project.model;




public enum UserRole {

    Client("Client"),
    Magasinier("Magasinier"),
    Admin("Admin");

    private String Role;

    private UserRole(String role) {
        this.Role = role;
    }

    public String getRole() {
        return Role;
    }
}
