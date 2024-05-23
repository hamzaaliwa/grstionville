package Repo;

import Entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Villerepo extends JpaRepository<Ville,Long> {
}
