package fr.eboutique.project.controller.admin;

import fr.eboutique.project.exception.PersonalException;
import fr.eboutique.project.model.Produit;
import fr.eboutique.project.service.IProduitService;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class AdminPage implements HandlerExceptionResolver {


    private final IProduitService produitService;

    public AdminPage(IProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("gereLesProduit/{pagenumero}")
    public String adminPage() {
        return "admin";
    }

    @PutMapping
    public String gereLesProduit(@PathVariable Long pagenumero, Model model) {

        Page<Produit> page = (Page<Produit>) produitService.gettoutedProduit();
        int pageCurrent = page.getNumber() + 1;
        int indexStart = Math.max(1, pageCurrent - 6);
        int indexFinal = Math.max(indexStart + 10, page.getTotalPages());

        List<Produit> produitList = new ArrayList<>();

        for (Produit produit : page) {
            produitList.add(produit);
        }

        model.addAttribute("prduits", produitList);
        model.addAttribute("pagesTout", page.getTotalPages());
        model.addAttribute("pageCurrent", pageCurrent);
        model.addAttribute("indexStart", indexStart);
        model.addAttribute("endIndex", indexFinal);

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
