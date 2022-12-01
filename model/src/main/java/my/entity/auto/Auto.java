package my.entity.auto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auto")
@Inheritance(strategy = InheritanceType.JOINED)
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
    @JoinColumn(name = "car_brand_id")
    private Brand brand;

    @Column(name = "colour")
    private String colour;

    @Column(name = "price")
    private BigDecimal price;

}
