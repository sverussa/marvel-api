package api.marvel.service;

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
class EventsServiceTest {

    @Autowired
    EventsService eventsService;

    private Parameters parameters = new Parameters();

    @BeforeEach
    public void setUp() throws Exception {
    }

    @Test
    void find() {
    }

    @Test
    void findByIdCharacter() {
    }

    @Test
    void findSummaryByIdCharacter() {
    }
}