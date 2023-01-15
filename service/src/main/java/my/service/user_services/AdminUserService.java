package my.service.user_services;

import my.beans.RoleBean;
import my.beans.UserCommonBean;
import my.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    public List<UserCommonBean> showUsers(){
        List<User> allUsers = userService.findAllUsers();
        List<UserCommonBean> users = new ArrayList<>();
        for (User user: allUsers) {
            UserCommonBean userCommonBean = new UserCommonBean();
            userCommonBean.setUserId(user.getUserId());
            userCommonBean.setFirstName(user.getUserDetails().getFirstName().toUpperCase());
            userCommonBean.setLastName(user.getUserDetails().getLastName().toUpperCase());
            userCommonBean.setPhoneNumber(user.getUserDetails().getPhoneNumber());
            userCommonBean.setBirthDay(user.getUserDetails().getBirthDay());
            userCommonBean.setEmail(user.getEmail());
            userCommonBean.setRoleName(user.getRole().getRoleName());
            users.add(userCommonBean);
        }
        return users;
    }

    public UserCommonBean showUserById(Integer id){
        User user = userService.findById(id);
        UserCommonBean userCommonBean = new UserCommonBean();
        userCommonBean.setUserId(user.getUserId());
        userCommonBean.setRoleName(user.getRole().getRoleName());
        return userCommonBean;
    }

    public void changeRole(Integer id, RoleBean roleBean){
        User user = userService.findById(id);
        if (!user.getRole().getRoleName().equals(roleBean.getRoleName())){
            user.setRole(roleService.findByName(roleBean.getRoleName()));
            userService.addUser(user);
        }
    }
}
