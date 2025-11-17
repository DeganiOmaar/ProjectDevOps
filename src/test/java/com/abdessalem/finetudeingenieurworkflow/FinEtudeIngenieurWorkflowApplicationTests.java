package com.abdessalem.finetudeingenieurworkflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(exclude = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    SqlInitializationAutoConfiguration.class
}, properties = {
    "spring.data.jpa.repositories.enabled=false"
})
class FinEtudeIngenieurWorkflowApplicationTests {

    @Test
    void contextLoads() {
    }

}
