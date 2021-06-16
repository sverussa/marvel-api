package api.marvel.service;

import api.marvel.entities.container.SeriesDataContainer;
import api.marvel.entities.list.SeriesList;
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
class SeriesServiceTest {

    @Autowired
    SeriesService seriesService;

    private Parameters parameters = new Parameters();

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    void find() {
    }

    @Test
    void findByIdCharacter() {
        SeriesDataContainer series = seriesService.findByIdCharacter(1009664, parameters);
        assertNotNull(series);
    }

    @Test
    void findSummaryByIdCharacter() {
        SeriesList seriesList = seriesService.findSummaryByIdCharacter(1009664);
        assertNotNull(seriesList);
    }
}