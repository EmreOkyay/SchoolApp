package practice.app.service.school.mapper;

import com.okyay.schoolapp.data.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import practice.app.service.school.dto.StudentDTO;

@Component
@Primary
public class StudentMapper implements IStudentMapper {
    @Override
    public StudentDTO toStudentDTO(Student student)
    {
        var dto = new StudentDTO();

        dto.studentNo = student.studentNo;
        dto.firstName = student.firstName;
        dto.middleName = student.middleName.orElse(null);
        dto.lastName = student.lastName;
        dto.className = student.className;
        dto.gpa = student.gpa;

        return dto;
    }
}
