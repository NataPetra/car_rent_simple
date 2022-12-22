package my.dao;

import lombok.SneakyThrows;
import my.config.TestConfig;
import my.entity.users.User;
import my.service.user_services.UserService;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserServiceDaoImplTest extends TestConfig{

    @Autowired
    UserService targetObject;

    @Before
    public void setUp() {
        targetObject.existsById(1);
    }

    @After
    public void tearDown() {
        targetObject = null;
    }

    @Test
    @SneakyThrows
    public void findById() {
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();

        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(UserServiceDaoImplTest.class.getResourceAsStream("UserServiceDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        User user = targetObject.findById(1);

        //Then
        assertEquals("1@mail.ru", user.getEmail());
        assertEquals("black", user.getPassword());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);

        conn.close();
    }

}
