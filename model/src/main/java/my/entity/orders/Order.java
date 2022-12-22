package my.entity.orders;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
