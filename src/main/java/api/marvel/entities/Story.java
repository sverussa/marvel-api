package api.marvel.entities;

import api.marvel.entities.list.*;
import api.marvel.entities.summary.ComicSummary;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "story")
public class Story {

    @Id
    private Integer id;
    private int digitalID;

    private int idCharacter;

    @Column(columnDefinition="TEXT")
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    private String resourceURI;
    private String type;
    private Date modified;
    private Image thumbnail;

    @Transient
    private ComicList comics;
    @Transient
    private SeriesList series;
    @Transient
    private EventList events;
    @Transient
    private CharacterList characters;
    @Transient
    private CreatorList creators;
    @Transient
    private ComicSummary originalissue;

}
