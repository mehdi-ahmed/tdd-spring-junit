package com.hanselnpetal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DatastoreSystemsHealthTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void dbPrimaryIsOk() {
        try {
            DatabaseMetaData metadata = dataSource.getConnection().getMetaData();
            String catalogName = dataSource.getConnection().getCatalog();

            assertThat(metadata, is(notNullValue()));
            assertThat(catalogName, is(equalTo("spring-tdd")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
