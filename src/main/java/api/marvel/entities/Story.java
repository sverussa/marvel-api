package api.marvel.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "story")
public class Story {

    @Id
    private Integer id;
    private int digitalID;

    private int idCharacter;

}
