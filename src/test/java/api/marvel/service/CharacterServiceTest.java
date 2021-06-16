package api.marvel.service;

import api.marvel.entities.container.CharacterDataContainer;
import api.marvel.validation.Parameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CharacterServiceTest {

    @Autowired
    private CharacterService characterService;

    private Parameters parameters = new Parameters();

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    void testSave() {
//        Character character = characterService.save(new Character());
//        assertNotNull(character);
    }

    @Test
    void findById() {
        CharacterDataContainer character = characterService.findById(1009664, parameters);
        assertNotNull(character);
    }
}