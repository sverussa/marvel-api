package api.marvel.entities.wrapper;

import api.marvel.entities.container.CreatorDataContainer;
import lombok.Data;

@Data
public class CreatorDataWrapper extends DataWrapper{

    private CreatorDataContainer data;

}
