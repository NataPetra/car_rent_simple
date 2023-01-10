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

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "colour")
    private String colour;

    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "auto", cascade = CascadeType.ALL)
    private AutoDetails autoDetails;

    @OneToMany(mappedBy = "auto")
    private List<AutoOrder> autoOrders;

    @OneToOne(mappedBy = "auto", cascade = CascadeType.ALL)
    private AutoPicture autoPicture;

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", model=" + model.getModelName() +
                ", brand=" + brand.getBrandName() +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;

        if (id != null ? !id.equals(auto.id) : auto.id != null) return false;
        if (model != null ? !model.equals(auto.model) : auto.model != null) return false;
        if (brand != null ? !brand.equals(auto.brand) : auto.brand != null) return false;
        if (colour != null ? !colour.equals(auto.colour) : auto.colour != null) return false;
        return price != null ? price.equals(auto.price) : auto.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
