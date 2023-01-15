package my.service.user_services;

import my.beans.UserCommonBean;
import my.dao.UserDao;
import my.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User addUser(User user) {
        return userDao.create(user);
    }

    @Transactional
    public User findById(Integer id) {
        return userDao.get(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        userDao.delete(id);
    }

    @Transactional
    public Boolean existsById(Integer id) {
        return userDao.isExistsById(id);
    }

    @Transactional
    public List<User> findAllByEmail(String email) {
        return userDao.findByName(email);
    }

    @Transactional
    public List<User> findAllUsers() {
        return userDao.getAll();
    }

    @Transactional
    public UserCommonBean addUserForPersonalPage(String email) {
        User appUser = findAllByEmail(email).get(0);
        return null;
    }
}
