package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoWithOrders {

    public Integer id;
    public String model;
    public String brand;
    public String colour;
    public String yearRealize;
    public Integer countOfOrders;

    @Override
    public String toString() {
        return "AutoWithOrders{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", yearRealize='" + yearRealize + '\'' +
                ", countOfOrders=" + countOfOrders +
                '}';
    }
}
