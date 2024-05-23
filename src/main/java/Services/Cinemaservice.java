package Services;

import Entities.Cinema;
import Repo.Cinemarepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Slf4j
public class Cinemaservice {
    private final Cinemarepo ticketrepo;

    public Cinema creer_cinema(Cinema e){
        return ticketrepo.save(e);
    }
    public void supprimer_cinema(long id){
        Cinema e =trouver_cinema(id);
        ticketrepo.delete(e);
    }
    public Cinema trouver_cinema(long id){
        Optional<Cinema> et = ticketrepo.findById(id);
        return et.get();
    }
    public List<Cinema> listes_cinema(){
        return ticketrepo.findAll();
    }
    public void supprime_tout(){
        ticketrepo.findAll().forEach(e->ticketrepo.delete(e));
    }
}
