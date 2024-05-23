package Repo;

import Entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cinemarepo extends JpaRepository<Cinema,Long> {
}
