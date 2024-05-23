package Services;

import Entities.Cinema;
import Entities.Ville;
import Repo.Cinemarepo;
import Repo.Villerepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class Villeservice {
    private final Villerepo ticketrepo;

    public Ville creer_ville(Ville e){
        return ticketrepo.save(e);
    }
    public void supprimer_ville(long id){
        Ville e =trouver_ville(id);
        ticketrepo.delete(e);
    }
    public Ville trouver_ville(long id){
        Optional<Ville> et = ticketrepo.findById(id);
        return et.get();
    }
    public List<Ville> listes_villes(){
        return ticketrepo.findAll();
    }
    public void supprime_tout(){
        ticketrepo.findAll().forEach(e->ticketrepo.delete(e));
    }
}
