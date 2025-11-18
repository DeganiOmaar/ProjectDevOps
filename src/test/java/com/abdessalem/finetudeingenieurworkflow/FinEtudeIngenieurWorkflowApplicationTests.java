package com.abdessalem.finetudeingenieurworkflow;

import com.abdessalem.finetudeingenieurworkflow.Repository.IAdminRepository;
import com.abdessalem.finetudeingenieurworkflow.Repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootTest(properties = {
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration",
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
