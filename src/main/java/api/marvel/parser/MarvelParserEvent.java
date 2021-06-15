package api.marvel.parser;

import api.marvel.entities.Character;
import api.marvel.entities.Event;
import api.marvel.service.EventsService;
import api.marvel.util.DateFromDateIso;
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
import java.util.Map;
import java.util.stream.Collectors;

import static api.marvel.parser.MarvelParserConstants.*;

@Log4j2
@Component
public class MarvelParserEvent {

    @Autowired
    EventsService eventsService;

    private List<Character> characters;

    private List<Event> events = new LinkedList<>();

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void parse() throws ParseException {

        List<Integer> idCharacters = characters.stream().map(Character::getId).collect(Collectors.toList());
        for (Character character : characters) {
            int idCharacter = character.getId();
            log.info("----");
            log.info("Characters:" + character.getName());
            log.info("Id Characters:" + idCharacter);

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder()
                    .url(MARVEL_HOST + MARVEL_API + "characters/"+idCharacter+"/events?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100)
                    .method("GET", null)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                ResponseBody body = response.body();
                JSONObject objectJson = new JSONObject(body.string());
                JSONObject dataJson = objectJson.getJSONObject("data");
                JSONArray resultsJson  = dataJson.getJSONArray("results");
                log.info("Events Found:" + resultsJson.length());

                for (int i = 0; i < resultsJson.length(); i++) {
                    JSONObject json = resultsJson.getJSONObject(i);

                    Event event = getEventFromJson(json);
                    event.setIdCharacter(idCharacter);
                    events.add(event);

                    log.info("Insert Comic:" + event.getId() + " - Id Character:" + event.getIdCharacter());
                    log.info("Title:" + event.getTitle());
                    eventsService.save(event);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Event getEventFromJson(JSONObject json) throws ParseException {

        Map<String, Object> eventsData = json.toMap();
        int id = (int) eventsData.get("id");
        String title = (String) eventsData.get("title");
        String modified = (String) eventsData.get("modified");
        String start = (String) eventsData.get("start");
        String end = (String) eventsData.get("end");
        String description = (String) eventsData.get("description");
        String resourceURI = (String) eventsData.get("resourceURI");


        Event event = new Event();
        event.setId(id);
        event.setTitle(title);
        event.setDescription(description);
        event.setResourceURI(resourceURI);
        event.setModified(DateFromDateIso.getDateFromString(modified));
        event.setStart(DateFromDateIso.getDatePatternFromString(start));
        event.setEnding(DateFromDateIso.getDatePatternFromString(end));
        return event;
    }
}
