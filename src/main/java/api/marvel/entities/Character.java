package api.marvel.entities;

import api.marvel.entities.list.ComicList;
import api.marvel.entities.list.EventList;
import api.marvel.entities.list.SeriesList;
import api.marvel.entities.list.StoryList;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "character")
public class Character extends RepresentationModel<Character> {

    @Id
    private Integer id;

    @Column(columnDefinition="TEXT")
    private String name;

    @Column(columnDefinition="TEXT")
    private String description;
    private Date modified;

    @Column(columnDefinition="TEXT")
    private String resourceURI;
    private Image thumbnail;

    @Transient
    private Set<Url> url;
    @Transient
    private ComicList comics;
    @Transient
    private StoryList stories;
    @Transient
    private EventList events;
    @Transient
    private SeriesList series;

}
