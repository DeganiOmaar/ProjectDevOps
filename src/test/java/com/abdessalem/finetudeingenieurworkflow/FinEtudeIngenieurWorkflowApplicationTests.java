package com.abdessalem.finetudeingenieurworkflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.NONE,
    properties = {
        "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration,org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration,org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration",
        "spring.data.jpa.repositories.enabled=false",
        "spring.main.allow-bean-definition-overriding=true",
        "spring.mail.username=test@example.com",
        "spring.mail.host=smtp.example.com",
        "spring.mail.port=587",
        "spring.main.web-application-type=none"
    }
)
@ActiveProfiles("test")
class FinEtudeIngenieurWorkflowApplicationTests {

    @Test
    void contextLoads() {
        // Test passes if context loads successfully
    }

}
