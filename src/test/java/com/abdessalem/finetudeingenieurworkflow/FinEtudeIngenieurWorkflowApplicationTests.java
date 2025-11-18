package com.abdessalem.finetudeingenieurworkflow;

import com.abdessalem.finetudeingenieurworkflow.Repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest(properties = {
    "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration,org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration,org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration",
    "spring.data.jpa.repositories.enabled=false",
    "spring.main.allow-bean-definition-overriding=true",
    "spring.mail.username=test@example.com",
    "spring.mail.host=smtp.example.com",
    "spring.mail.port=587"
})
class FinEtudeIngenieurWorkflowApplicationTests {

    @MockBean
    private IUserRepository userRepository;

    @MockBean
    private IAdminRepository adminRepository;

    @MockBean
    private ITuteurRepository tuteurRepository;

    @MockBean
    private ISujetRepository sujetRepository;

    @MockBean
    private ISocieteRepository societeRepository;

    @MockBean
    private IEtudiantRepository etudiantRepository;

    @MockBean
    private IEquipeRepository equipeRepository;

    @MockBean
    private IProjetRepository projetRepository;

    @MockBean
    private IFormRepository formRepository;

    @MockBean
    private IFormResponseRepository formResponseRepository;

    @MockBean
    private IFormFieldRepository formFieldRepository;

    @MockBean
    private ITacheRepository tacheRepository;

    @MockBean
    private IHistoriqueRepository historiqueRepository;

    @MockBean
    private IBacklogRepository backlogRepository;

    @MockBean
    private IEpicRepository epicRepository;

    @MockBean
    private ISprintRepository sprintRepository;

    @MockBean
    private ICandidatureRepository candidatureRepository;

    @MockBean
    private IEvaluationGridRepository evaluationGridRepository;

    @MockBean
    private IEvaluationCriterionRepository evaluationCriterionRepository;

    @MockBean
    private ICriterionLevelRepository criterionLevelRepository;

    @MockBean
    private IAppreciationRepository appreciationRepository;

    @MockBean
    private IJustificationRepository justificationRepository;

    @MockBean
    private IStudentEvaluationRepository studentEvaluationRepository;

    @MockBean
    private IStudentAnalysisReportRepository studentAnalysisReportRepository;

    @MockBean
    private ISuggestionRepository suggestionRepository;

    @MockBean
    private MotivationScoreRepository motivationScoreRepository;

    @MockBean
    private EtatHistoriqueTacheRepository etatHistoriqueTacheRepository;

    @MockBean
    private CodeAnalysisResultRepository codeAnalysisResultRepository;

    @MockBean
    private JavaMailSender javaMailSender;

    @Test
    void contextLoads() {
        // Test passes if context loads successfully
    }

}
