package api.marvel.parser;

import api.marvel.entities.Character;
import api.marvel.entities.Comic;
import api.marvel.entities.Image;
import api.marvel.service.ComicsService;
import api.marvel.util.DateFromDateIso;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class MarvelParserComic {

    @Autowired
    ComicsService comicsService;

    private List<Character> characters;
    private List<Comic> comics = new LinkedList<>();

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
                    .url(MARVEL_HOST + MARVEL_API + "characters/"+idCharacter+"/comics?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100)
                    .method("GET", null)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                ResponseBody body = response.body();
                JSONObject objectJson = new JSONObject(body.string());
                JSONObject dataJson = objectJson.getJSONObject("data");
                JSONArray resultsJson  = dataJson.getJSONArray("results");
                log.info("Comics OffSet:" + resultsJson.length());
                log.info("Comics Found:" + resultsJson.length());

                for (int i = 0; i < resultsJson.length(); i++) {
                    JSONObject comicJson = resultsJson.getJSONObject(i);
                    Comic comic = getComicFromJson(comicJson);
                    comic.setIdCharacter(idCharacter);
                    comics.add(comic);

                    log.info("Insert Comic:" + comic.getId() + " - Id Character:" + comic.getIdCharacter());
                    log.info("Title:" + comic.getTitle());
                    comicsService.save(comic);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private Comic getComicFromJson(JSONObject comicJson) throws ParseException, JsonProcessingException {

        int id = comicJson.getInt("id");
        String title = getStringJson(comicJson, "title");
        int issueNumber = comicJson.getInt("issueNumber");
        String description = getStringJson(comicJson, "description");
        String variantDescription = comicJson.getString("variantDescription");
        String isbn = comicJson.getString("isbn");
        String upc = comicJson.getString("upc");

//        Map<String, Object> stringObjectMap = comicJson.toMap();

        String diamondCode = getStringJson(comicJson,"diamondCode");
        String ean = comicJson.getString("ean");
        String issn = comicJson.getString("issn");
        String format = comicJson.getString("format");
        int pageCount = comicJson.getInt("pageCount");
        String modifiedString = comicJson.getString("modified");

        JSONObject Jthumbnail = comicJson.getJSONObject("thumbnail");
        String path = Jthumbnail.getString("path");
        String extension = Jthumbnail.getString("extension");

        Image thumbnail = new Image();
        thumbnail.setPath(path);
        thumbnail.setExtension(extension);

        Comic cc = new Comic();
        cc.setId(id);
        cc.setIssueNumber(issueNumber);
        cc.setIsbn(isbn);
        cc.setIssn(issn);
        cc.setUpc(upc);
        cc.setEan(ean);
        cc.setDescription(description);
        cc.setVariantDescription(variantDescription);
        cc.setTitle(title);
        cc.setDiamondCode(diamondCode);
        cc.setModified(DateFromDateIso.getDateFromString(modifiedString));
        cc.setThumbnail(thumbnail);
        return cc;
    }

    public String getStringJson(JSONObject json, String key) {
        try {
            if (json.isNull(key)){
                return "";
            }
            return json.getString(key);
        } catch (Exception ex) {
            log.warn("Problema:" + key);
            log.warn("Json:" + json);
        }
        return "";
    }
}
