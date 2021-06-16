package api.marvel.repository;

import api.marvel.entities.Event;
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
class EventsRepositoryTest {

    @Autowired
    EventsRepository eventsRepository;

    @Test
    public void testBuscarComicsPorId() {
        List<Event> events = eventsRepository.findAllByIdCharacterEquals(1009664);
        assertFalse(events.isEmpty());
    }
}