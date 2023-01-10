package my.entity.orders;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_car")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "user_order_id")
    private UserOrder userOrder;

    @ManyToOne
    @JoinColumn(name = "auto_order_id")
    private AutoOrder autoOrder;

    @Column
    private String comments;

    @Column
    private LocalDate dateStart;

    @Column
    private LocalDate dateFinish;

    @Column
    private Integer amountOfDays;

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", userOrder=" + userOrder +
                ", autoOrder=" + autoOrder +
                ", comments='" + comments + '\'' +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", amountOfDays=" + amountOfDays +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (order_id != null ? !order_id.equals(order.order_id) : order.order_id != null) return false;
        if (userOrder != null ? !userOrder.equals(order.userOrder) : order.userOrder != null) return false;
        if (autoOrder != null ? !autoOrder.equals(order.autoOrder) : order.autoOrder != null) return false;
        if (comments != null ? !comments.equals(order.comments) : order.comments != null) return false;
        if (dateStart != null ? !dateStart.equals(order.dateStart) : order.dateStart != null) return false;
        if (dateFinish != null ? !dateFinish.equals(order.dateFinish) : order.dateFinish != null) return false;
        return amountOfDays != null ? amountOfDays.equals(order.amountOfDays) : order.amountOfDays == null;
    }

    @Override
    public int hashCode() {
        int result = order_id != null ? order_id.hashCode() : 0;
        result = 31 * result + (userOrder != null ? userOrder.hashCode() : 0);
        result = 31 * result + (autoOrder != null ? autoOrder.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateFinish != null ? dateFinish.hashCode() : 0);
        result = 31 * result + (amountOfDays != null ? amountOfDays.hashCode() : 0);
        return result;
    }
}
