package my.entity.orders;

import lombok.*;
import my.entity.auto.Auto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public String toString() {
        return "AutoOrder{" +
                "id=" + id +
                ", auto=" + auto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoOrder autoOrder = (AutoOrder) o;

        if (id != null ? !id.equals(autoOrder.id) : autoOrder.id != null) return false;
        return auto != null ? auto.equals(autoOrder.auto) : autoOrder.auto == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (auto != null ? auto.hashCode() : 0);
        return result;
    }
}
