package api.marvel.parser;

import api.marvel.entities.Character;
import api.marvel.entities.Image;
import api.marvel.service.CharacterService;
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


@Component
public class MarvelParserCharacter {

    CharacterService characterService;

    private List<Character> characters = new LinkedList<>();

    public List<Character> getCharacters() {
        return characters;
    }

    @Autowired
    public MarvelParserCharacter(CharacterService characterService) {
        this.characterService = characterService;
    }

    public void parse() throws ParseException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(MARVEL_HOST + MARVEL_API + "characters?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100 + "&nameStartsWith=Hulk")
                .method("GET", null)
                .build();

        try (Response response = client.newCall(request).execute()) {
            ResponseBody body = response.body();
            JSONObject Jobject = new JSONObject(body.string());
            JSONObject Jdata = Jobject.getJSONObject("data");
            JSONArray Jresults = Jdata.getJSONArray("results");

            for (int i = 0; i < Jresults.length(); i++) {
                JSONObject character = Jresults.getJSONObject(i);
                Character characterFromJson = getCharacterFromJson(character);
                characters.add(characterFromJson);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insert() {
        for (Character character : characters) {
            characterService.insert(character);
        }
    }

    private Character getCharacterFromJson(JSONObject character) throws ParseException {
        int id = character.getInt("id");
        String name = character.getString("name");
        String description = character.getString("description");
        String resourceURI = character.getString("resourceURI");
        String modifiedString = character.getString("modified");
        JSONObject Jthumbnail = character.getJSONObject("thumbnail");
        String path = Jthumbnail.getString("path");
        String extension = Jthumbnail.getString("extension");

        // todo URLs

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
        return ch;
    }
}
