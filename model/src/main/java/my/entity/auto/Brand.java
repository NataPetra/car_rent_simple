package my.entity.auto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "brand")
public class Brand implements Serializable {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "brand_name")
    private String brandName;

    public Brand(Integer id, Model model, String brandName) {
        this.id = id;
        this.model = model;
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", model=" + model.getId() +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
