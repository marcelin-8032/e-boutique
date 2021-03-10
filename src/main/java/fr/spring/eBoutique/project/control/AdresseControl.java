package fr.spring.eBoutique.project.control;


import fr.spring.eBoutique.project.model.Adresse;
import fr.spring.eBoutique.project.service.IAdresseService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/addresse")
public class AdresseControl implements IAdresseControl {

    private final IAdresseService adresseService;

    @Autowired
    public AdresseControl(IAdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @Override
    @GetMapping(path = "idUtilisateur")
    public Adresse getAdresse(@PathVariable("idUtilisateur") Long idUtilisateur) throws NotFoundException {
        return adresseService.getAdresse(idUtilisateur);
    }

    @Override
    @PostMapping(path = "{idUtilisateur}")
    public Adresse addAdresse(@RequestBody @Valid Adresse adresse,
                              @PathVariable("idUtilisateur") Long idUtilisateur) {
        return adresseService.addAdresse(adresse, idUtilisateur);

    }

    @Override
    @PutMapping(path = "{idUtilisateur}")
    public void updateAdresse(@RequestBody Adresse adresse,
                              @PathVariable("idUtilisateur") Long idUtilisateur) {
        adresseService.updateAdresse(adresse, idUtilisateur);

    }

    @Override
    @DeleteMapping("{idUtilisateur}")
    public void removeAdresse(@PathVariable("idUtilisateur") Long idUtilisateur) {
        adresseService.removeAdresse(idUtilisateur);

    }


}
