package practice.app.service.school.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"practice.app", "com.okyay"})
public class StudentGetServiceApp {
    public static void main(String[] args)
    {
        SpringApplication.run(StudentGetServiceApp.class, args);
    }
}