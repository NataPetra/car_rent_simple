package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoDetailsBean {

    private Integer id;
    private String colour;
    private String price;
    private Integer releaseYear;
    private Boolean automaticTransmission;
    private String modelName;
    private String brandName;
    private String bodyType;
    private byte[] picture;
}
