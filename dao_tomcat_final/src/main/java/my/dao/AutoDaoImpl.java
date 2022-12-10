package my.dao;

import my.entity.auto.Auto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AutoDaoImpl implements AutoDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createAuto(Auto auto) {
        sessionFactory.getCurrentSession()
                .save(auto);
    }

    @Override
    public Auto getAuto(Integer id) {
        return sessionFactory.getCurrentSession()
                .get(Auto.class, id);
    }
}
