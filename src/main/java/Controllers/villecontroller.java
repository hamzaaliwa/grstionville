package Controllers;

import Entities.Cinema;
import Entities.Ville;
import Repo.Cinemarepo;
import Repo.Villerepo;
import Services.Cinemaservice;
import Services.Villeservice;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/villes"})
@CrossOrigin("*")
public class villecontroller {
    @Autowired
    private Ville ticket;
    @Autowired
    private Villeservice ticketservice;
    @Autowired
    private Villerepo ticketrepo;

    @GetMapping
    public List<Ville> getville(){
        return ticketservice.listes_villes();
    }
    @GetMapping({"/{id}"})
    public Ville chercherville(@PathVariable long id ){
        return ticketservice.trouver_ville(id);
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_ville(@PathVariable long id){
        ticketservice.supprimer_ville(id);
        return "etudiant de numero "+ id +"est supprimé";
    }
    @PostMapping
    public Ville ajouter_etudiant(@RequestBody Ville e){
        return ticketservice.creer_ville(e);
    }
    @PutMapping
    public Ville misajour_etudiant(@RequestBody Ville e){
        return ticketservice.creer_ville(e);
    }

    @DeleteMapping
    public String suprime(){
        ticketservice.supprime_tout();
        return "tout est supprimés";
    }
}
