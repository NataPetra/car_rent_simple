package my.dao;

import my.entity.users.Role;
import my.entity.users.User;
import my.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role get(Integer id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return roleRepository.existsById(id);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public long count() {
        return roleRepository.count();
    }
}
