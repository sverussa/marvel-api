package api.marvel.entities;

import api.marvel.entities.list.*;
import api.marvel.entities.summary.SeriesSummary;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Entity
@Table(name = "series")
public class Series {

    @Id
    private Integer id;
    private int digitalID;

    private String title;
    private String description;
    private int startYear;
    private int endYear;
    private String rating;
    private Date modified;
    private Image thumbnail;
    @Transient
    private ComicList comics;
    @Transient
    private StoryList stories;
    @Transient
    private EventList events;
    @Transient
    private CharacterList characters;
    @Transient
    private CreatorList creators;
    @Transient
    private SeriesSummary next;
    @Transient
    private SeriesSummary previous;

}
