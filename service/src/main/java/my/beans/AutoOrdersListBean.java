package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoOrdersListBean {

    private Integer id;
    private String modelName;
    private String brandName;
    private Integer releaseYear;
    private String colour;
    private Integer amountOfOrders;

    @Override
    public String toString() {
        return "AutoOrdersListBean{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", releaseYear=" + releaseYear +
                ", colour='" + colour + '\'' +
                ", amountOfOrders=" + amountOfOrders +
                '}';
    }
}
