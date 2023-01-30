package fr.eboutique.project.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone,String> {
    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String phonenumber, ConstraintValidatorContext context) {

        if(phonenumber==null){
            return false;
        }

        if(phonenumber.matches("01[5-9]\\d{8}$")){
            return true;
        }

        return false;
    }
}
