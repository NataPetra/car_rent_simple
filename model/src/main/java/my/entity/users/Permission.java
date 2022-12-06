package my.entity.users;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission")
public class Permission implements Serializable {

    @Id
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer permissionId;

    private String permissionName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
