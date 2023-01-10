package my.service.user_services;

import my.dao.UserDetailsDao;
import my.entity.users.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    public UserDetails addUserDetails(UserDetails userDetails) {
        return userDetailsDao.create(userDetails);
    }

    public UserDetails findById(Integer id) {
        return userDetailsDao.get(id);
    }

    public void deleteById(Integer id) {
        userDetailsDao.delete(id);
    }

    public Boolean existsById(Integer id) {
        return userDetailsDao.isExistsById(id);
    }
}
