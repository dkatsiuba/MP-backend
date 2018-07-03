package ch.zhaw.sml.iwi.pmis.meng.simplebackend;

import ch.zhaw.sml.iwi.pmis.meng.simplebackend.boundary.ConsultationsService;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Consultation;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Doctor;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.model.Patient;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.ConsultationRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.DoctorRepository;
import ch.zhaw.sml.iwi.pmis.meng.simplebackend.repository.PatientRepository;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SimpleBackend extends ResourceConfig {
  public static void main(String[] args) {
        SpringApplication.run(SimpleBackend.class, args);
    }

    public SimpleBackend() {
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
        register(ConsultationsService.class);
        register(CorsFilter.class);
        register(JacksonHibernateConfig.class);

    }
    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            Doctor d = new Doctor();
            d.setShortname("DK");
            Patient p = new Patient();
            p.setPatientenNr(929384);
            Consultation c = new Consultation();
            c.setDoctor(d);
            c.setPatient(p);
            patientRepository.save(p);
            doctorRepository.save(d);

            consultationRepository.save(c);
        };
    }

}
