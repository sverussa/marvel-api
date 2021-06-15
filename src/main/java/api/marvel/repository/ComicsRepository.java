package api.marvel.repository;

import api.marvel.entities.Character;
import api.marvel.entities.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComicsRepository extends JpaRepository<Comic, Integer> {

    List<Comic> findAllByIdCharacterEquals(Integer idCharacter);

    @Query("select c from Comic c where c.idCharacter = :#{#character.id}")
    List<Comic> findComicByIdCharacter(@Param("character") Character character);

}
