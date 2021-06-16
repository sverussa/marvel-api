package api.marvel.repository;

import api.marvel.entities.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    public void testBuscarCharacterPorId() {
        Optional<Character> character = characterRepository.findById(1009664);
        character.ifPresent(ch -> {
            assertEquals("Thor", ch.getName());
        });
    }




}