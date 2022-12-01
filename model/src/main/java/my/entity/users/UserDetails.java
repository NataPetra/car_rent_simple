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
@Table(name = "user")
public class UserDetails implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user")
    )
    private Integer userId;

    private String firstName;

    private String lastName;

    private String birthDay;

    private String phoneNumber;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;
}
