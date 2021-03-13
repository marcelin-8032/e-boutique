package fr.spring.eBoutique.project.model;

import lombok.Getter;

@Getter
public enum Categorie {

    Electronique("Electronique"),
    Telephonique("Telephonique"),
    Decoration("Decoration");

    private String Categorie;

   Categorie(String categorie) {
        this.Categorie = categorie;
    }


}
