package my.security;

import my.entity.users.User;
import my.service.user_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service("authService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            System.out.println("Start loadUserByUsername");
            List<User> appUsers = userService.findAllByEmail(username);
            System.out.println("Count of user " + appUsers.size());
            if (appUsers.size() != 1) {
                throw new UsernameNotFoundException("User not found: " + username);
            }

            User appUser = appUsers.get(0);
            System.out.println("Find user " + appUser);

            return new UserPrincipal(appUser);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found: " + username, e);
        }

    }

    private class UserPrincipal implements UserDetails {

        private User user;

        public UserPrincipal(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return List.of(() -> "ROLE_" + user.getRole().getRoleName());
        }

        @Override
        public String getPassword() {
            return user.getPassword();
        }

        @Override
        public String getUsername() {
            return user.getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}

