package api.marvel.service;

import api.marvel.entities.Character;
import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.validation.Parameters;

public interface CharacterService {

    CharacterDataContainer find(Parameters parameters);

    CharacterDataContainer findById(Integer id, Parameters parameters);

    Character save(Character character);

}