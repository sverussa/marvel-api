package api.marvel.repository;

import api.marvel.entities.Series;
import api.marvel.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoriesRepository extends JpaRepository<Story, Integer> {

    List<Story> findAllByIdCharacterEquals(Integer idCharacter);

}
