package my.service.user_services;

import my.dao.UserDao;
import my.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

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

}
