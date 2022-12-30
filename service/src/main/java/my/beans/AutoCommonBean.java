package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutoCommonBean {

    private Integer id;

    @NotNull(message = "Incorrect colour. You need to specify the color of the car.")
    private String colour;

    @NotNull(message = "You need to indicate the cost of car rental.")
    @Digits(message = "Numbers should be here.", integer = 5, fraction = 2)
    private String price;

    @NotNull(message = "You need to enter the year of manufacture of the car.")
    @Max(value = 2022, message = "Incorrect year")
    private Integer releaseYear;

    private String automaticTransmission;

    private String withDriver;

    @NotNull(message = "You need to provide the car model name.")
    @Size(min=2, max=30, message = "Incorrect model name.")
    private String modelName;

    @NotNull(message = "You need to provide the car brand name.")
    @Size(min=2, max=30, message = "Incorrect brand name.")
    private String brandName;

    @NotNull(message = "You need to provide the car body type.")
    private String bodyType;

    private MultipartFile pictureImg;

    @Override
    public String toString() {
        return "AutoCommonBean{" +
                "colour='" + colour + '\'' +
                ", price='" + price + '\'' +
                ", releaseYear=" + releaseYear +
                ", automaticTransmission='" + automaticTransmission + '\'' +
                ", withDriver='" + withDriver + '\'' +
                ", modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", bodyType='" + bodyType + '\'' +
                '}';
    }
}
