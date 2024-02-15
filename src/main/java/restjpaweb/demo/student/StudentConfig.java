package restjpaweb.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
           Student Brian = new Student(
                    "Brian",
                    "brian@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,
                            6)
           );
            Student Alex = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,
                            6)
            );
            Student Caroline = new Student(
                    "Caroline",
                    "caroline@gmail.com",
                    LocalDate.of(1998, Month.OCTOBER,
                            4)
            );
            repository.saveAll(
                    List.of(Brian, Alex, Caroline)
            );
        };
    }
}
