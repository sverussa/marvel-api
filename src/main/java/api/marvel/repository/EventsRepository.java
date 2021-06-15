package api.marvel.repository;

import api.marvel.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<Event, Integer> {

    List<Event> findAllByIdCharacterEquals(Integer idCharacter);

}
