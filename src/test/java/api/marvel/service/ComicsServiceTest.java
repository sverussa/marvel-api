package api.marvel.service;

import api.marvel.entities.Comic;
import api.marvel.entities.container.ComicDataContainer;
import api.marvel.entities.list.ComicList;
import api.marvel.validation.Parameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ComicsServiceTest {

    @Autowired
    ComicsService comicsService;

    private Parameters parameters = new Parameters();

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    void find() {

    }

    @Test
    void findByIdCharacter() {
        ComicDataContainer comics = comicsService.findByIdCharacter(1009664, parameters);
        assertNotNull(comics);
    }

    @Test
    void findSummaryByIdCharacter() {
        ComicList comicList = comicsService.findSummaryByIdCharacter(1009664);
        assertNotNull(comicList);
    }
}