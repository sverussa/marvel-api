package api.marvel.repository;

import api.marvel.entities.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoriesRepository extends JpaRepository<Story, Integer> {
}
