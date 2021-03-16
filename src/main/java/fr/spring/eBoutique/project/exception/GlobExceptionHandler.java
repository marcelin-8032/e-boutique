package fr.spring.eBoutique.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobExceptionHandler implements HandlerExceptionResolver {

    @ExceptionHandler(NoHandlerFoundException.class)
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();

        PersonalException exception = new PersonalException();
        exception.setMessage("Vous essayez d'accéder à une page non autorisée. Veuillez saisir une URL valide.");

        modelAndView.addObject("personalErro", exception);
        modelAndView.setViewName("error_page");

        return modelAndView;
    }
}
