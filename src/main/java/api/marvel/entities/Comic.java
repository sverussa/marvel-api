package api.marvel.entities;

import api.marvel.entities.list.CharacterList;
import api.marvel.entities.list.CreatorList;
import api.marvel.entities.list.EventList;
import api.marvel.entities.list.StoryList;
import api.marvel.entities.summary.ComicSummary;
import api.marvel.entities.summary.SeriesSummary;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "comic")
public class Comic {

    @Id
    private Integer id;
    private int digitalID;

    private int idCharacter;

    @Column(columnDefinition="TEXT")
    private String title;
    private long issueNumber;
    private String variantDescription;

    @Column(columnDefinition="TEXT")
    private String description;
    private Date modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private String pageCount;


//    private String properties;
//    private String textObjects;
//    private String resourceURI;

    @Transient
    private Set<Url> urls;
    @Transient
    private List<SeriesSummary> series;
    @Transient
    private List<ComicSummary> variants;
    @Transient
    private List<ComicSummary> collections;
    @Transient
    private List<ComicSummary> collectedIssues;
    @Transient
    private List<ComicDate> dates;
    @Transient
    private List<ComicPrice> prices;
    private Image thumbnail;
    @Transient
    private List<Image> images;
    @Transient
    private CreatorList creators;
    @Transient
    private CharacterList characters;
    @Transient
    private StoryList stories;
    @Transient
    private EventList eventList;

    public ComicSummary getSummary() {
        return new ComicSummary(getTitle());
    }
}
