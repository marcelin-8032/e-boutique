package fr.spring.eBoutique.project.control.admin;

import fr.spring.eBoutique.project.exception.PersonalException;
import fr.spring.eBoutique.project.model.Produit;
import fr.spring.eBoutique.project.service.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AdminPage implements HandlerExceptionResolver {

    @Autowired
    private IProduitService produitService;


    @RequestMapping("gereLesProduit/{pagenumero}")
    public String adminPage() {
        return "admin";
    }

    public String gereLesProduit(@PathVariable Long pagenumero, Model model) {

        Page<Produit> page = (Page<Produit>) produitService.gettoutedProduit();
        int pageCurrent = page.getNumber() + 1;
        int indexStart = Math.max(1, pageCurrent - 6);
        int indexFinal = Math.max(indexStart + 10, page.getTotalPages());

        List<Produit> produitList = new ArrayList<>();

        for (Produit produit : page) {
            produitList.add(produit);
        }

        model.addAttribute("prduits",produitList);
        model.addAttribute("pagesTout",page.getTotalPages());
        model.addAttribute("pageCurrent",pageCurrent);
        model.addAttribute("indexStart",indexStart);
        model.addAttribute("endIndex",indexFinal);

        return "produitInventorie";
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
