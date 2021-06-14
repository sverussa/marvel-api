package api.marvel.validation;

import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;

@Data
@Validated
public class Parameters {

    @ApiParam(name = "name",
            value = "Return only characters matching the specified full character name (e.g. Spider-Man).",
            type = "string",
            allowMultiple = false,
            required = false
    )
    @Max(1)
    @Null
    private String name;
    private String nameStartsWith;

    private Date modifiedSince;
    private String comics;
    private String series;
    private String events;
    private String stories;
    private String orderBy;

    @Range(min = 0, max = 100)
    private Integer limit;
    private Integer offset;

}
