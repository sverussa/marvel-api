package api.marvel.entities.container;

import api.marvel.entities.Story;
import lombok.Data;

import java.util.List;

@Data
public class StoryDataContainer {

    private List<Story> results;

}
