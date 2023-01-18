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
public class OrderAutoUserBean {

    private Integer id;
    private String model;
    private String brand;
    private String colour;
    private Integer yearRealize;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private Integer amountOfDays;
    private Double price;

    @Override
    public String toString() {
        return "OrderAutoUserBean{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", yearRealize=" + yearRealize +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", amountOfDays=" + amountOfDays +
                '}';
    }
}
