package my.entity.auto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Getter
@Setter
@Table(name = "auto_picture")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AutoPicture that = (AutoPicture) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (auto != null ? !auto.equals(that.auto) : that.auto != null) return false;
        return Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (auto != null ? auto.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
