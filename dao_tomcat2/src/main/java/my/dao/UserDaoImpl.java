package my.dao;

import my.entity.users.User;
import my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List getAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<User> findByName(String email) {
        return userRepository.findAllByEmail(email);
    }
}
