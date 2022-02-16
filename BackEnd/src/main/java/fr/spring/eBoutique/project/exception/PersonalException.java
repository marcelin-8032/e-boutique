package fr.spring.eBoutique.project.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

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
