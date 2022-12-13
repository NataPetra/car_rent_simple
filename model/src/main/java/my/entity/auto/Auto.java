package my.entity.auto;

import lombok.*;
import my.entity.orders.AutoOrder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auto")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Auto implements Serializable {

    @Id
    @Column(name = "auto_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "colour")
    private String colour;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "auto", cascade = CascadeType.ALL)
    private AutoDetails autoDetails;

    @OneToMany(mappedBy = "auto")
    private List<AutoOrder> autoOrders;

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model=" + model.getId() +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }
}
