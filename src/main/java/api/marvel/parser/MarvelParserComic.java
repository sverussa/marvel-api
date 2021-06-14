package api.marvel.parser;

import api.marvel.entities.Comic;
import api.marvel.entities.Image;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import static api.marvel.parser.MarvelParserConstants.*;
import static api.marvel.util.DateFromDateIso.getDateFromString;

@Component
public class MarvelParserComic {

    private List<Integer> idCharacters;
    private List<Comic> comics = new LinkedList<>();

    public void setIdCharacters(List<Integer> idCharacters) {
        this.idCharacters = idCharacters;
    }

    public void parse() throws ParseException {

        for (Integer idCharacter : idCharacters) {

            OkHttpClient client = new OkHttpClient().newBuilder().build();
            Request request = new Request.Builder()
                    .url(MARVEL_HOST + MARVEL_API + "characters/"+idCharacter+"/comics?" + MARVEL_APIKEY + MARVEL_PARAM_LIMIT_100)
                    .method("GET", null)
                    .build();


            // http://gateway.marvel.com/v1/public/characters/1009351/comics?ts=1&apikey=5b6e75e0a769a777d819f84cfd98ef5e&hash=a2ca6fe3c673fc3f6eeabdc2a31229cf&limit=2
            try (Response response = client.newCall(request).execute()) {
                ResponseBody body = response.body();
                JSONObject objectJson = new JSONObject(body.string());
                JSONObject dataJson = objectJson.getJSONObject("data");
                JSONArray resultsJson  = dataJson.getJSONArray("results");

                for (int i = 0; i < resultsJson.length(); i++) {
                    JSONObject comicJson = resultsJson.getJSONObject(i);
                    Comic characterFromJson = getComicFromJson(comicJson);
                    comics.add(characterFromJson);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private Comic getComicFromJson(JSONObject comicJson) throws ParseException {

        int id = comicJson.getInt("id");
        String title = comicJson.getString("title");
        int issueNumber = comicJson.getInt("issueNumber");
        String description = comicJson.getString("description");
        String variantDescription = comicJson.getString("variantDescription");
        String isbn = comicJson.getString("isbn");
        String upc = comicJson.getString("upc");
        String diamondCode = comicJson.getString("diamondCode");
        String ean = comicJson.getString("ean");
        String issn = comicJson.getString("issn");
        String format = comicJson.getString("format");
        int pageCount = comicJson.getInt("pageCount");

        String resourceURI = comicJson.getString("resourceURI");
        String modifiedString = comicJson.getString("modified");
        JSONObject Jthumbnail = comicJson.getJSONObject("thumbnail");
        String path = Jthumbnail.getString("path");
        String extension = Jthumbnail.getString("extension");

        // todo URLs

        Image thumbnail = new Image();
        thumbnail.setPath(path);
        thumbnail.setExtension(extension);

        Comic cc = new Comic();
        cc.setId(id);
        cc.setDescription(description);
        cc.setModified(getDateFromString(modifiedString));
//        cc.setResourceURI(resourceURI);
        cc.setThumbnail(thumbnail);
        return cc;
    }

    public void insert() {
        for (Comic comic : comics) {
            System.out.println(comic.getId());
        }
    }

}
