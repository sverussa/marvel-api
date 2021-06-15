package api.marvel.entities.wrapper;

import api.marvel.entities.container.EventDataContainer;
import lombok.Data;

@Data
public class EventDataWrapper extends DataWrapper {

    private EventDataContainer data;

}
