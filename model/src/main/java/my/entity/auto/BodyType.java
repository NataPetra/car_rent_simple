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
@Table(name = "body_type")
public class BodyType implements Serializable {

    @Id
    @Column(name = "body_type_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(
            name = "increment",
            strategy = "org.hibernate.id.IncrementGenerator"
    )
    private Integer id;

    @Column(name = "b_type")
    private String type;

    @OneToMany(mappedBy = "bodyType")
    private List<AutoDetails> autoDetails;

    @Override
    public String toString() {
        return "BodyType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BodyType bodyType = (BodyType) o;

        if (id != null ? !id.equals(bodyType.id) : bodyType.id != null) return false;
        return type != null ? type.equals(bodyType.type) : bodyType.type == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
