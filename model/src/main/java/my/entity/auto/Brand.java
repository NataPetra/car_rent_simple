package my.entity.auto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @Column(name = "car_brand_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Model model;

    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private List<Auto> autos;

}
