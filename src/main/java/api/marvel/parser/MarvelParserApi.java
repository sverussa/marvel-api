package api.marvel.parser;

import api.marvel.entities.Character;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
public class MarvelParserApi {

    @Autowired
    MarvelParserCharacter marvelParserCharacter;
    @Autowired
    MarvelParserComic marvelParserComic;
    @Autowired
    MarvelParserEvent marvelParserEvent;
    @Autowired
    MarvelParserSeries marvelParserSeries;
    @Autowired
    MarvelParserStories marvelParserStories;

    public void parserApi() throws ParseException {

        marvelParserCharacter.parseCharacter();
        marvelParserComic.setCharacters(marvelParserCharacter.getCharacters());
        marvelParserEvent.setCharacters(marvelParserCharacter.getCharacters());
        marvelParserSeries.setCharacters(marvelParserCharacter.getCharacters());
        marvelParserStories.setCharacters(marvelParserCharacter.getCharacters());

        marvelParserComic.parse();
        marvelParserEvent.parse();
        marvelParserSeries.parse();
        marvelParserStories.parse();

        log.info(new Gson().toJson("Sucesso Parser Marvel Character"));
    }
}