package my.dao;

import lombok.SneakyThrows;
import my.config.TestConfig;
import my.entity.auto.Auto;
import my.service.AutoService;
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
public class AutoServiceDaoImplTest extends TestConfig{

    @Autowired
    AutoService targetObject;

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
                .build(AutoServiceDaoImplTest.class.getResourceAsStream("AutoServiceDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Auto auto = targetObject.findById(1);

        //Then
        assertEquals("black", auto.getColour());
        assertEquals("17000.00", auto.getPrice().toString());
        assertEquals("volvo", auto.getModel().getModelName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);

        conn.close();
    }

}
