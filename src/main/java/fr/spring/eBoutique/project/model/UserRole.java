package fr.spring.eBoutique.project.model;

import lombok.Getter;

@Getter
public enum UserRole {

    Client("Client"),
    Magasinier("Magasinier"),
    Admin("Admin");

    private String Role;

    private UserRole(String role) {
        this.Role = role;
    }


}
