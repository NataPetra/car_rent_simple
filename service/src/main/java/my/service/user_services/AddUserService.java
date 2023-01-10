package my.service.user_services;

import my.beans.UserCommonBean;
import my.entity.users.Role;
import my.entity.users.User;
import my.entity.users.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddUserService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailService userDetailsService;
    @Autowired
    private RoleService roleService;

    public void addUserForm(UserCommonBean userCommonBean) {
        Role roleSimpleUser = roleService.findById(2);
        List<User> allUsers = userService.findAllUsers();
        User lastUser = allUsers.get(allUsers.size() - 1);
        User user = new User();
        user.setUserId(lastUser.getUserId() + 1);
        user.setEmail(userCommonBean.getEmail());
        user.setPassword("{noop}" + userCommonBean.getPassword());
        user.setRole(roleSimpleUser);
        User userDB = userService.addUser(user);
        UserDetails userDetails = new UserDetails();
        userDetails.setUser(userDB);
        userDetails.setBirthDay(userCommonBean.getBirthDay());
        userDetails.setFirstName(userCommonBean.getFirstName().trim().toLowerCase());
        userDetails.setLastName(userCommonBean.getLastName().trim().toLowerCase());
        userDetails.setPhoneNumber(userCommonBean.getPhoneNumber());
        userDetailsService.addUserDetails(userDetails);
    }

}
