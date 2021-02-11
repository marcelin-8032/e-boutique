package fr.spring.eBoutique.project.enums;

public enum Categorie {

    Electronique("Electronique"),
    Telephonique("Telephonique"),
    Decoration("Decoration");

    private String Categorie;

    private Categorie(String categorie) {
        this.Categorie = categorie;
    }


    public String getCategorie() {
        return Categorie;
    }

}
