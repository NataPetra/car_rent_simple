package my.service.user_services;

import my.dao.UserDao;
import my.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class UserService  { //implements UserDetailsService

    @Autowired
    private UserDao userDao;

    @Transactional
    public User addUser (User user){
        return userDao.create(user);
    }

    @Transactional
    public User findById (Integer id){
        return userDao.get(id);
    }

    @Transactional
    public void deleteById (Integer id){
        userDao.delete(id);
    }

    @Transactional
    public Boolean existsById (Integer id){
        return userDao.isExistsById(id);
    }

    @Transactional
    public List<User> findAllByEmail (String email){
        return userDao.findByName(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        List<User> usersByEmail = userDao.findByName(username);
//        if(usersByEmail.size() != 1){
//            throw new UsernameNotFoundException("Such user with: " + username + " not found");
//        }
//        return new UserPrincipal(usersByEmail.get(0));
//    }

//    private class UserPrincipal implements UserDetails {
//
//        private User user;
//
//        public UserPrincipal(User user) {
//            this.user = user;
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            return List.of(() -> user.getRole().getRoleName());
//        }
//
//        @Override
//        public String getPassword() {
//            return user.getPassword();
//        }
//
//        @Override
//        public String getUsername() {
//            return user.getEmail();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
}
