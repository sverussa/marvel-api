package api.marvel.service;

import api.marvel.entities.Character;

import java.util.List;

public interface CharacterService {

    List<Character> find();

    Character insert(Character character);

}