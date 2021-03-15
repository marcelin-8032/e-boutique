package fr.spring.eBoutique.project.validator;

import fr.spring.eBoutique.project.model.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Client c = (Client) target;

        if (c.getModepass().length() < 6 || c.getModepass().length() > 30) {
            errors.rejectValue("modepass", null, "Le mot de passe doit comporter entre 6 et 30 caractères");
        }

    }
}
