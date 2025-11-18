package com.abdessalem.finetudeingenieurworkflow;

import com.abdessalem.finetudeingenieurworkflow.Repository.IAdminRepository;
import com.abdessalem.finetudeingenieurworkflow.Repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(excludeAutoConfiguration = {
    DataSourceAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class,
    SqlInitializationAutoConfiguration.class
}, properties = {
    "spring.data.jpa.repositories.enabled=false",
    "spring.main.allow-bean-definition-overriding=true"
})
class FinEtudeIngenieurWorkflowApplicationTests {

    @MockBean
    private IUserRepository userRepository;

    @MockBean
    private IAdminRepository adminRepository;

    @Test
    void contextLoads() {
        // Test passes if context loads successfully
    }

}
