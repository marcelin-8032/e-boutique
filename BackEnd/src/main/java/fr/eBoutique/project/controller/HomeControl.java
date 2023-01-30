package fr.eboutique.project.controller;

import fr.eboutique.project.exception.PersonalException;
import fr.eboutique.project.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("home")
public class HomeControl implements HandlerExceptionResolver {


    private IClientService clientService;

    @Autowired
    public HomeControl(IClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        PersonalException error = new PersonalException();

        error.setMessage("Votre demande n'est pas valide.Veuillez entrer une demande valide.");
        modelAndView.addObject("personalException", error);
        modelAndView.setViewName("error_page");
        return modelAndView;
    }
}
