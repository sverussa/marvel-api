package api.marvel.repository;

import api.marvel.entities.Character;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CharacterRepository extends PagingAndSortingRepository<Character, Integer> {
}