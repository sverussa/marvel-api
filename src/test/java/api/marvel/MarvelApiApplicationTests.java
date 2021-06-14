package api.marvel;

import api.marvel.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class MarvelApiApplicationTests {

    @Autowired
    CharacterService characterService;

    @Test
    void contextLoads() {
        Assert.isTrue(true, "Ocorreu True");
    }

}
