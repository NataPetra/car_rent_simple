package my.entity.auto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="auto_picture")
public class AutoPicture {

    @Id
    @Column(name = "auto_picture_id")
    @GeneratedValue(generator = "foreign_key_gen")
    @GenericGenerator(name = "foreign_key_gen",
            strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "auto")
    )
    private Integer id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Auto auto;

    @Column(name = "auto_picture", columnDefinition = "BLOB NOT NULL")
    @Lob
    private byte[] picture;

}
