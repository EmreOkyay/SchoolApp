package practice.app.service.school.data.repository;

import org.csystem.util.data.repository.ICrudRepository;
import practice.app.service.school.data.entity.Student;
import practice.app.service.school.data.entity.Teacher;

public interface ITeacherRepository extends ICrudRepository<Teacher, Long> {
    /*
        findByFirstName ve findByLastName hem student hem teacher'da oldugu içi, Crud'a taşınabilir?
     */
    Iterable<Teacher> findByFirstName(String firstName);
    Iterable<Teacher> findByLastName(String lastName);
}
