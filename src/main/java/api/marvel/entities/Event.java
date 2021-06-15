package api.marvel.entities;

import api.marvel.entities.list.*;
import api.marvel.entities.summary.EventSummary;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "event")
public class Event {

    @Id
    private Integer id;
    private int digitalID;

    private int idCharacter;

    @Column(columnDefinition="TEXT")
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    @Column(columnDefinition="TEXT")
    private String resourceURI;
    private Date modified;
    private Date start;
    private Date ending;
    private Image thumbnail;

    @Transient
    private ComicList comics;
    @Transient
    private StoryList stories;
    @Transient
    private SeriesList series;
    @Transient
    private CharacterList characters;
    @Transient
    private CreatorList creators;
    @Transient
    private EventSummary next;
    @Transient
    private EventSummary previous;

}
