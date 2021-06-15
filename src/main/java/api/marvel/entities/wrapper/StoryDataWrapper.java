package api.marvel.entities.wrapper;

import api.marvel.entities.container.StoryDataContainer;
import lombok.Data;

@Data
public class StoryDataWrapper extends DataWrapper {

    private StoryDataContainer data;

}
