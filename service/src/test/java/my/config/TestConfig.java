package my.config;

import lombok.SneakyThrows;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.mysql.MySqlConnection;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(value = "classpath:/car_test.jdbc.properties")
@ContextConfiguration(classes = RootConfig.class)
public class TestConfig {

    // JDBC data source
    protected static MysqlJdbcDataSource testMysqlJdbcDataSource;
    // DBUnit connection
    protected static IDatabaseConnection iDatabaseConnection;

    @BeforeClass
    @SneakyThrows
    public static void init() {
        testMysqlJdbcDataSource = new MysqlJdbcDataSource("car_test.jdbc.properties");
        iDatabaseConnection = new MySqlConnection(testMysqlJdbcDataSource.getConnection(), "car_test");

    }
}
