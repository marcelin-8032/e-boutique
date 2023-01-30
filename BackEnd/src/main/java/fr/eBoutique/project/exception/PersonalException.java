package fr.eboutique.project.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalException {
    private Long code;
    private String message;

    public PersonalException() {
    }
    public PersonalException(Long code, String message) {
        this.code = code;
        this.message = message;
    }
}
