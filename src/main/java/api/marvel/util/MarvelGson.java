package api.marvel.util;

import api.marvel.adapter.HibernateProxyTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MarvelGson {

    public static Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
                .create();
    }

}
