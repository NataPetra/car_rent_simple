package my.entity.auto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auto_details")
public class AutoDetails implements Serializable {

    @Id
    @Column(name = "auto_details_id")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "auto")
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyType bodyType;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "automatic_transmission")
    private Boolean automaticTransmission;

    @Column(name = "with_driver")
    private Boolean withDriver;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Auto auto;

    @Override
    public String toString() {
        return "AutoDetails{" +
                "id=" + id +
                ", bodyType=" + bodyType.getType() +
                ", releaseYear=" + releaseYear +
                ", automaticTransmission=" + automaticTransmission +
                ", withDriver=" + withDriver +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoDetails that = (AutoDetails) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (bodyType != null ? !bodyType.equals(that.bodyType) : that.bodyType != null) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (automaticTransmission != null ? !automaticTransmission.equals(that.automaticTransmission) : that.automaticTransmission != null)
            return false;
        return withDriver != null ? withDriver.equals(that.withDriver) : that.withDriver == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bodyType != null ? bodyType.hashCode() : 0);
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (automaticTransmission != null ? automaticTransmission.hashCode() : 0);
        result = 31 * result + (withDriver != null ? withDriver.hashCode() : 0);
        return result;
    }
}
