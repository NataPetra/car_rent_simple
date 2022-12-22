package my.dao;

import my.entity.users.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDetailsDao {

    UserDetails create(UserDetails userDetails);
    UserDetails get(Integer id);
    Boolean isExistsById (Integer id);
    void delete(UserDetails userDetails);
    void delete(Integer id);
    List getAll();
    long count();
}
