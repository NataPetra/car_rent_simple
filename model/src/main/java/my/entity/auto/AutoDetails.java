package my.entity.auto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "auto_id")
public class AutoDetails extends Auto implements Serializable {

    private static final Long serialVersionUID = 3L;

    @Column(name = "body_type_id")
    private Integer bodyTypeId;

    @Column(name = "automatic_transmission")
    private Boolean automaticTransmission;

    @Column(name = "with_driver")
    private Boolean withDriver;

}
