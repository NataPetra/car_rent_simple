package my.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCommonBean {

    private Integer userId;
    private String email;
    private String password;
    private String roleName;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String phoneNumber;

    @Override
    public String toString() {
        return "UserCommonBean{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleName='" + roleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
