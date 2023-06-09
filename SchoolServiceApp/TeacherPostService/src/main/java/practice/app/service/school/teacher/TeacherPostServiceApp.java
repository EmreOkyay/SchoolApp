package practice.app.service.school.teacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"practice.app", "com.okyay"})
public class TeacherPostServiceApp {
    public static void main(String[] args)
    {
        SpringApplication.run(TeacherPostServiceApp.class, args);
    }
}