package my.service.user_services;

import my.dao.RoleDao;
import my.entity.users.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    public Role addRole(Role role) {
        return roleDao.create(role);
    }

    @Transactional
    public Role findById(Integer id) {
        return roleDao.get(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        roleDao.delete(id);
    }

    @Transactional
    public Boolean existsById(Integer id) {
        return roleDao.isExistsById(id);
    }
}
