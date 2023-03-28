package practice.app.service.school.data.repository;

import org.csystem.util.data.repository.ICrudRepository;
import practice.app.service.school.data.entity.Student;

import java.util.Optional;

public interface IStudentRepository extends ICrudRepository<Student, Long> {
    /*
    findByFirstName ve findByLastName hem student hem teacher'da oldugu içi, Crud'a taşınabilir?
    */
    Iterable<Student> findByFirstName(String firstName);
    Iterable<Student> findByLastName(String lastName);
    Iterable<Student> findByGpa(double gpa);
}
