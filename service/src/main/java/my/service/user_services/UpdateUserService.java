package my.service.user_services;

import my.beans.UserCommonBean;
import my.entity.users.User;
import my.entity.users.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateUserService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailService userDetailService;

    @Transactional
    public UserCommonBean createUserCommonBean(Integer id){
        User user = userService.findById(id);
        UserCommonBean userCommonBean = new UserCommonBean();
        userCommonBean.setUserId(user.getUserId());
        userCommonBean.setEmail(user.getEmail());
        userCommonBean.setPassword(user.getPassword());
        userCommonBean.setFirstName(user.getUserDetails().getFirstName());
        userCommonBean.setLastName(user.getUserDetails().getLastName());
        userCommonBean.setBirthDay(user.getUserDetails().getBirthDay());
        userCommonBean.setPhoneNumber(user.getUserDetails().getPhoneNumber());
        System.out.println(userCommonBean);
        return userCommonBean;
    }

    @Transactional
    public void updatePersonalInfo(UserCommonBean userCommonBean, Integer id){
        User user = userService.findById(id);
        UserDetails userDetails = userDetailService.findById(id);
        if(user != null){
            if(!user.getEmail().equals(userCommonBean.getEmail())){
                user.setEmail(userCommonBean.getEmail());
            }
            if(!user.getPassword().equals(userCommonBean.getPassword())){
                user.setPassword(userCommonBean.getPassword());
            }
            if (!user.getUserDetails().getFirstName().equalsIgnoreCase(userCommonBean.getFirstName())) {
                userDetails.setFirstName(userCommonBean.getFirstName());
            }
            if (!userDetails.getLastName().equalsIgnoreCase(userCommonBean.getLastName())){
                userDetails.setLastName(userCommonBean.getLastName());
            }
            if (!userDetails.getBirthDay().equalsIgnoreCase(userCommonBean.getBirthDay())){
                userDetails.setBirthDay(userCommonBean.getBirthDay());
            }
            if (!userDetails.getPhoneNumber().equalsIgnoreCase(userCommonBean.getPhoneNumber())){
                userDetails.setPhoneNumber(userCommonBean.getPhoneNumber());
            }
            userService.addUser(user);
            userDetailService.addUserDetails(userDetails);
        }
    }
}
