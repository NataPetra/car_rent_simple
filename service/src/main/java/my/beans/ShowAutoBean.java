package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowAutoBean {

    private Integer number;
    private String model;
    private String brand;
    private String colour;
    private String price;

    @Override
    public String toString() {
        return "ShowAutoBean{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
