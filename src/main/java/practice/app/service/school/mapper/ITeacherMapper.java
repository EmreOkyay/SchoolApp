package practice.app.service.school.mapper;

import practice.app.service.school.data.entity.Teacher;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.TeacherDTO;
import practice.app.service.school.dto.TeachersDTO;

import java.util.List;

public interface ITeacherMapper {
    TeacherDTO toTeacherDTO(Teacher teacher);

    default TeachersDTO toTeachersDTO(List<TeacherDTO> teachers)
    {
        var dto = new TeachersDTO();

        dto.teachers = teachers;

        return dto;
    }

    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
