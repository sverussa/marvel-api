package api.marvel.repository;

import api.marvel.entities.Event;
import api.marvel.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

    List<Series> findAllByIdCharacterEquals(Integer idCharacter);

}
