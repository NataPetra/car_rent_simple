package my.entity.auto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "model")
public class Model {

    @Id
    @Column(name = "model_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "model_name")
    private String modelName;

    @OneToMany(mappedBy = "brand")
    private List<Brand> brands;

    @OneToMany(mappedBy = "auto")
    private List<Auto> autos;

}
