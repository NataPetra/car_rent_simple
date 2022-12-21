package my.dao;

import lombok.SneakyThrows;
import my.config.TestConfig;
import my.entity.auto.AutoDetails;
import my.service.AutoDetailsService;
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
public class AutoDetailsServiceDaoImplTest extends TestConfig{

    @Autowired
    AutoDetailsService targetObject;

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
                .build(AutoDetailsServiceDaoImplTest.class.getResourceAsStream("AutoDetailsServiceDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        AutoDetails autoDetails = targetObject.findById(1);

        //Then
        assertEquals("2015", autoDetails.getReleaseYear().toString());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);

        conn.close();
    }


}
