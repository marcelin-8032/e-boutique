package fr.spring.eBoutique.project.validator;

import fr.spring.eBoutique.project.model.Produit;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.Valid;

public class ProduitFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Produit.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Produit produit = (Produit) target;

        if (produit.getCategorie().equals("NONE")) {
            errors.rejectValue("produitCategorie", "vide", "Veuillez sélectionner une catégorie de produit");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "produitPrix", "vide", "le prix ne peut pas être vide");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remise", "vide", "la remise ne peut pas être vide");


    }
}
