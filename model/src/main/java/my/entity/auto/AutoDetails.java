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
//@PrimaryKeyJoinColumn(name = "auto_id")
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

    @Column(name = "releaseYear")
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
                ", bodyType=" + bodyType.getId() +
                ", releaseYear=" + releaseYear +
                ", automaticTransmission=" + automaticTransmission +
                ", withDriver=" + withDriver +
                ", auto=" + auto.getId() +
                '}';
    }
}
