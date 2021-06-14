package api.marvel.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class Url implements Serializable {

    private String type;
    private String url;

}
