package my.dao;

import my.entity.users.UserDetails;
import my.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails create(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    @Override
    public UserDetails get(Integer id) {
        return userDetailsRepository.findById(id).get();
    }

    @Override
    public Boolean isExistsById(Integer id) {
        return userDetailsRepository.existsById(id);
    }

    @Override
    public void delete(UserDetails userDetails) {
        userDetailsRepository.delete(userDetails);
    }

    @Override
    public void delete(Integer id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public List<UserDetails> getAll() {
        return userDetailsRepository.findAll();
    }

    @Override
    public long count() {
        return userDetailsRepository.count();
    }
}
