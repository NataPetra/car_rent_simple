package my.dao;

import lombok.SneakyThrows;
import my.config.TestConfig;
import my.entity.auto.*;
import my.service.auto_services.AutoService;
import my.service.auto_services.BrandService;
import my.service.auto_services.ModelService;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class AutoServiceDaoImplTest extends TestConfig{

    @Autowired
    AutoService targetObject;
    @Autowired
    BrandService brandService;
    @Autowired
    ModelService modelService;

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
        List allAuto = targetObject.allAuto();

        //Then
        assertEquals(3, allAuto.size());
        assertEquals("black", auto.getColour());
        assertEquals("17000.00", auto.getPrice().toString());
        assertEquals("volvo", auto.getModel().getModelName());

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);

        conn.close();
    }

    @Test
    @SneakyThrows
    public void delete(){
        //Given
        Connection conn = testMysqlJdbcDataSource.getConnection();
        IDataSet dataSet = new FlatXmlDataSetBuilder()
                .build(AutoServiceDaoImplTest.class.getResourceAsStream("AutoServiceDaoImplTest.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(iDatabaseConnection, dataSet);

        //When
        Auto auto = targetObject.findById(3);
        String brandName = auto.getBrand().getBrandName();
        Integer idBrand = auto.getBrand().getId();
        String modelName = auto.getModel().getModelName();
        Integer idModel = auto.getModel().getId();
        targetObject.deleteById(3);
        Auto byBrand = targetObject.findByBrand(brandName);
        Auto byModel = targetObject.findByModel(modelName);
        if(byBrand==null){
            brandService.deleteById(idBrand);
            Integer counBrands = brandService.findByModelId(idModel);
            if(counBrands==0){
                modelService.deleteById(idModel);
                //modelService.deleteById(1);
            }
        }
        List allAuto = targetObject.allAuto();
        Brand nullBrand = brandService.findByName(brandName);

        //Then
        assertEquals(2, allAuto.size());
        assertEquals(1, modelService.countOfModels().intValue());
        assertNull(nullBrand);

        DatabaseOperation.DELETE.execute(iDatabaseConnection, dataSet);
        conn.close();
    }

}
