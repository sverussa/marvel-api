package api.marvel.entities.list;

import api.marvel.entities.summary.Summary;

import java.util.List;

public class ResourceList<T extends Summary> {

    private int available;
    private int returned;
    private String collectionURI;
    private List<T> items;

}
