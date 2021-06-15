package api.marvel.repository;

import api.marvel.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
}
