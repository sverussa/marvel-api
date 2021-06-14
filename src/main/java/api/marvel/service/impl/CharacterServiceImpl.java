package api.marvel.service.impl;

import api.marvel.entities.Character;
import api.marvel.repository.CharacterRepository;
import api.marvel.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> find() {
        return characterRepository.findAll();
    }

    @Override
    public Character insert(Character character) {
        return characterRepository.save(character);
    }
}
