package api.marvel.repository;

import api.marvel.entities.Series;
import api.marvel.entities.Story;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class StoriesRepositoryTest {

    @Autowired
    StoriesRepository storiesRepository;

    @Test
    public void testBuscarComicsPorId() {
        List<Story> stories = storiesRepository.findAllByIdCharacterEquals(1009664);
        assertFalse(stories.isEmpty());
    }

}