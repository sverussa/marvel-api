package api.marvel.entities.list;

import api.marvel.entities.summary.Summary;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ResourceList<T extends Summary> {

    private int available;
    private int returned;
    private String collectionURI;
    private List<T> items = new LinkedList<>();

}
