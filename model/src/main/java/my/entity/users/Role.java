package my.entity.users;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    private String description;

    @OneToMany(mappedBy = "role")
    private List<Permission> permissions;

    @OneToMany(mappedBy = "role")
    private List<User> users;

}
