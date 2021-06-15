package api.marvel.entities.summary;

import lombok.Data;

@Data
public class SeriesSummary extends Summary {

    public SeriesSummary(String title) {
        this.setName(title);
    }

}
