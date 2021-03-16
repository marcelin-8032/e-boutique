package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.service.IAdresseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/addresse")
public class AdresseControl {

    private final IAdresseService adresseService;

    @Autowired
    public AdresseControl(IAdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping(path = "idUtilisateur")
    public Adresse getAdresse(@PathVariable("idUtilisateur") Long idUtilisateur) throws NotFoundException {
        return adresseService.getAdresse(idUtilisateur);
    }


    @PostMapping(path = "{idUtilisateur}")
    public Adresse addAdresse(@RequestBody @Valid Adresse adresse){
        return adresseService.addAdresse(adresse);

    }

    @PutMapping(path = "{idUtilisateur}")
    public void updateAdresse(@RequestBody Adresse adresse) {
        adresseService.updateAdresse(adresse);

    }


    @DeleteMapping("{idUtilisateur}")
    public void removeAdresse(@PathVariable("idUtilisateur") Long idUtilisateur) {
        adresseService.removeAdresse(idUtilisateur);

    }


}
