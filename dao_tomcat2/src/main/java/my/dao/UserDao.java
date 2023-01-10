package my.dao;

import my.entity.users.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User create(User user);

    User get(Integer id);

    Boolean isExistsById(Integer id);

    void delete(User user);

    void delete(Integer id);

    List<User> getAll();

    long count();

    List<User> findByName(String email);

}
