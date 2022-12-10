package my.entity.orders;

import lombok.*;
import my.entity.auto.Auto;
import my.entity.auto.Model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "auto_order")
public class AutoOrder implements Serializable {

    @Id
    @Column(name = "auto_order_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "auto_id")
    private Auto auto;

    @OneToMany(mappedBy = "autoOrder")
    private List<Order> orders;

}
