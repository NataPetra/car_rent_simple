package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoCommonBean {

    private String colour;

    private String price;

    private Integer releaseYear;

    private String automaticTransmission;

    private String withDriver;

    private String modelName;

    private String brandName;

    private String bodyType;

}
