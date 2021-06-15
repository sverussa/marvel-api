package api.marvel.parser;

import api.marvel.entities.Character;
import api.marvel.entities.Image;
import api.marvel.service.CharacterService;
import lombok.extern.log4j.Log4j2;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static api.marvel.parser.MarvelParserConstants.*;
import static api.marvel.util.DateFromDateIso.getDateFromString;

@Log4j2
@Component
public class MarvelParserCharacter {

    CharacterService characterService;

    private List<Character> characters = new LinkedList<>();

    public List<Character> getCharacters() {
        return characters;
    }

    private int offsetCharacter = 0;
    private boolean endCharacter = false;

    @Autowired
    public MarvelParserCharacter(CharacterService characterService) {
        this.characterService = characterService;
    }

    public void parseCharacter() throws ParseException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
//                .url(MARVEL_HOST + MARVEL_API + "characters?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100 + MARVEL_PARAM_OFFSET + offsetCharacter) // + "&nameStartsWith=Invencible"
                .url(MARVEL_HOST + MARVEL_API + "characters/1009718?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100 + MARVEL_PARAM_OFFSET + offsetCharacter) // + "&nameStartsWith=Invencible"
                .method("GET", null)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            JSONObject Jobject = new JSONObject(body.string());
            JSONObject Jdata = Jobject.getJSONObject("data");
            JSONArray Jresults = Jdata.getJSONArray("results");
            int totalCharacters = Jresults.length();
            log.info("Characters OffSet:" + offsetCharacter);
            log.info("Characters Found:" + totalCharacters);

            if (totalCharacters < 100) {
                offsetCharacter = 0;
                endCharacter = true;
            } else {
                offsetCharacter = offsetCharacter + 100;
            }

            getCharacters(Jresults, totalCharacters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!endCharacter) {
            parseCharacter();
        }
    }

    private void getCharacters(JSONArray Jresults, int totalCharacters) throws ParseException {
        for (int i = 0; i < totalCharacters; i++) {
            JSONObject characterJson = Jresults.getJSONObject(i);
            Character character = getCharacter(characterJson);
            characters.add(character);

            log.info("Insert Character:" + character.getId());
            log.info("Name:" + character.getName());
            characterService.save(character);
        }
    }

    private Character getCharacter(JSONObject character) throws ParseException {
        int id = character.getInt("id");
        String name = character.getString("name");
        String description = character.getString("description");
        String resourceURI = character.getString("resourceURI");
        String modifiedString = character.getString("modified");
        JSONObject Jthumbnail = character.getJSONObject("thumbnail");
        String path = Jthumbnail.getString("path");
        String extension = Jthumbnail.getString("extension");

        Image thumbnail = new Image();
        thumbnail.setPath(path);
        thumbnail.setExtension(extension);

        Character ch = new Character();
        ch.setId(id);
        ch.setName(name);
        ch.setDescription(description);
        ch.setModified(getDateFromString(modifiedString));
        ch.setResourceURI(resourceURI);
        ch.setThumbnail(thumbnail);
        log.info("Character:" + ch.getName());
        return ch;
    }
}
