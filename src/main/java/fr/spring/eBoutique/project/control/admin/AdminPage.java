package fr.spring.eBoutique.project.control.admin;

import fr.spring.eBoutique.project.exception.PersonalException;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminPage implements HandlerExceptionResolver {

    @Autowired
    private IProduitService produitService;


    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    public String gereLesProduit(@RequestParam("search") String search, @PathVariable Long pageNumero, Model model) {


        return "prodiuct";
    }


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        PersonalException apiException = new PersonalException();
        apiException.setMessage("some error");
        modelAndView.addObject("apiException", apiException);
        modelAndView.setViewName("errors");
        return modelAndView;
    }
}
