package my.dao;

import my.entity.users.Role;
import my.entity.users.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    Role create(Role role);
    Role get(Integer id);
    Boolean isExistsById (Integer id);
    void delete(Role role);
    void delete(Integer id);
    List getAll();
    long count();
}
