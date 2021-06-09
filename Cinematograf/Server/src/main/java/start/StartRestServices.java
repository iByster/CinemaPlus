package start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@ComponentScan({"cinematograf", "persistence.database", "persistence.interfaces", "persistence.validators", "persistence.dialect", "persistence.exceptions", "conf"})
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class StartRestServices {

    public static void main(String[] args) {

        SpringApplication.run(StartRestServices.class, args);
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(){return null;};
}
