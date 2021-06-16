package api.marvel.repository;

import api.marvel.entities.Series;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SeriesRepositoryTest {

    @Autowired
    SeriesRepository seriesRepository;

    @Test
    public void testBuscarComicsPorId() {
        List<Series> series = this.seriesRepository.findAllByIdCharacterEquals(1009664);
        assertFalse(series.isEmpty());
    }

}