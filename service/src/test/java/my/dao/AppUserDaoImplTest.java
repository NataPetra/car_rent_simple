package my.dao;

import my.config.RootConfig;
import my.entity.users.User;
import my.service.user_services.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class AppUserDaoImplTest {

    @Autowired
    UserService targetObject;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    public void findByUserName() {
        //When
        List<User> userList = targetObject.findAllByEmail("nika@mail.ru");
        System.out.println(userList.get(0));
        //Then
        assertNotNull(userList);
        assertEquals(1, userList.size());

    }
}
