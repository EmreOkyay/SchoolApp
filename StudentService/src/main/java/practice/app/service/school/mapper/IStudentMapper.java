package practice.app.service.school.mapper;


import com.okyay.schoolapp.data.entity.Student;
import org.mapstruct.Mapper;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.StudentDTO;
import practice.app.service.school.dto.StudentsDTO;

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
