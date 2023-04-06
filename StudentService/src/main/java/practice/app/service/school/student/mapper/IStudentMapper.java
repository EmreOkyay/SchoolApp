package practice.app.service.school.student.mapper;


import com.okyay.schoolapp.data.entity.Student;
import org.mapstruct.Mapper;
import practice.app.service.school.student.dto.CountDTO;
import practice.app.service.school.student.dto.StudentDTO;
import practice.app.service.school.student.dto.StudentsDTO;

import java.util.List;

@Mapper(implementationName = "StudentMapperImpl")
public interface IStudentMapper {
    StudentDTO toStudentDTO(Student student);

    default StudentsDTO toStudentsDTO(List<StudentDTO> students)
    {
        var dto = new StudentsDTO();

        dto.students = students;

        return dto;
    }
    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
