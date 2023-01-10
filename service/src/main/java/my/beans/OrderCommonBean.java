package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCommonBean {

    private Integer id;
    private String price;
    private String colour;
    private Integer releaseYear;
    private String modelName;
    private String brandName;
    private Integer amountOfDays;
    private String comments;

}
