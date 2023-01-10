package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderListBean {

    private Integer id;
    private Integer releaseYear;
    private String modelName;
    private String brandName;
    private LocalDate dateStart;
    private LocalDate dateFinish;

    @Override
    public String toString() {
        return "OrderListBean{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                '}';
    }
}
