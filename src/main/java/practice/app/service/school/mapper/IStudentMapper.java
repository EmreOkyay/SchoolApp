package practice.app.service.school.mapper;

import practice.app.service.school.data.entity.Student;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.StudentDTO;
import practice.app.service.school.dto.StudentsDTO;

import java.util.List;

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
