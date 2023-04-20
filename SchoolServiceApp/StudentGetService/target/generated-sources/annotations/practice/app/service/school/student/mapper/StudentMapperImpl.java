package practice.app.service.school.student.mapper;

import com.okyay.schoolapp.data.entity.Student;
import javax.annotation.processing.Generated;
import practice.app.service.school.student.dto.StudentDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T09:12:43+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class StudentMapperImpl implements IStudentMapper {

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.studentNo = student.getStudentNo();
        studentDTO.firstName = student.getFirstName();
        studentDTO.middleName = student.getMiddleName();
        studentDTO.lastName = student.getLastName();
        studentDTO.className = student.getClassName();
        studentDTO.gpa = student.getGpa();

        return studentDTO;
    }
}
