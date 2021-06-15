package api.marvel.repository;

import api.marvel.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Serie, Integer> {
}
