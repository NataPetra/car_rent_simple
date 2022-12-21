package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoDetailsBean {

    private Integer id;
    private String colour;
    private String price;
    private Integer releaseYear;
    private String automaticTransmission;
    private String driver;
    private String modelName;
    private String brandName;
    private String bodyType;
    private byte[] picture;

    @Override
    public String toString() {
        return "AutoDetailsBean{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                ", price='" + price + '\'' +
                ", releaseYear=" + releaseYear +
                ", automaticTransmission='" + automaticTransmission + '\'' +
                ", driver='" + driver + '\'' +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
