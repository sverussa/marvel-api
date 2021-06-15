package api.marvel.entities.summary;

import lombok.Data;

@Data
public class EventSummary extends Summary {

    public EventSummary(String title) {
        this.setName(title);
    }

}
