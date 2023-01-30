package fr.eboutique.project.enums;


public enum UtilisatuerRole {

    Client("Client"),
    Magasinier("Magasinier"),
    Admin("Admin");

    private String Role;

    UtilisatuerRole(String role) {
        this.Role = role;
    }

    public String getRole() {
        return Role;
    }
}
