package api.marvel.entities.container;

import api.marvel.entities.Event;
import lombok.Data;

import java.util.List;

@Data
public class EventDataContainer extends DataContainer {

    private List<Event> results;

}
