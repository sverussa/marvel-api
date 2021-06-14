package api.marvel.repository;

import api.marvel.entities.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comic, Integer> {
}
