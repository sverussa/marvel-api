package api.marvel.entities;

import lombok.Data;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AttributeOverrides({
    @AttributeOverride( name = "path", column = @Column(name = "path")),
    @AttributeOverride( name = "extension", column = @Column(name = "extension")),
})
public class Image {

    @Column(length = 1000)
    private String path;

    private String extension;

}
