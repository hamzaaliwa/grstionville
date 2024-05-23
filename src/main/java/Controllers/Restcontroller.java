package Controllers;

import Entities.Cinema;
import Entities.Ville;
import Repo.Cinemarepo;
import Repo.Villerepo;
import Services.Cinemaservice;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping({"/cinemas"})
@CrossOrigin("*")
public class Restcontroller {
    @Autowired
    private Cinema ticket;
    @Autowired
    private Cinemaservice ticketservice;
    @Autowired
    private Cinemarepo ticketrepo;

    @GetMapping
    public List<Cinema> getcinema(){
        return ticketservice.listes_cinema();
    }
    @GetMapping({"/{id}"})
    public Cinema cherchercenima(@PathVariable long id ){
        return ticketservice.trouver_cinema(id);
    }
    @DeleteMapping({"/{id}"})
    public String supprimer_cinema(@PathVariable long id){
        ticketservice.supprimer_cinema(id);
        return "etudiant de numero "+ id +"est supprimé";
    }
    @PostMapping
    public Cinema ajouter_etudiant(@RequestBody Cinema e){
        return ticketservice.creer_cinema(e);
    }
    @PutMapping
    public Cinema misajour_etudiant(@RequestBody Cinema e){
        return ticketservice.creer_cinema(e);
    }

    @DeleteMapping
    public String suprime(){
        ticketservice.supprime_tout();
        return "tout est supprimés";
    }
}

