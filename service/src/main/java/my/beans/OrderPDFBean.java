package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderPDFBean {

    private Integer id;
    private Double price;
    private Integer releaseYear;
    private String modelName;
    private String brandName;
    private Integer amountOfDays;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private String firstName;
    private String lastName;
    private LocalDateTime date;
    private String name;

    public OrderPDFBean(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderPDFBean{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", releaseYear=" + releaseYear +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", amountOfDays=" + amountOfDays +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
