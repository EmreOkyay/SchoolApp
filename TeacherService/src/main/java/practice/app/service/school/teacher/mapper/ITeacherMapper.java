package practice.app.service.school.teacher.mapper;

import com.okyay.schoolapp.data.entity.Teacher;
import org.mapstruct.Mapper;
import practice.app.service.school.teacher.dto.CountDTO;
import practice.app.service.school.teacher.dto.TeacherDTO;
import practice.app.service.school.teacher.dto.TeachersDTO;

import java.util.List;

@Mapper(implementationName = "TeacherMapperImpl")
public interface ITeacherMapper {
    TeacherDTO toTeacherDTO(Teacher teacher);

    default TeachersDTO toTeachersDTO(List<TeacherDTO> teachers) {
        var dto = new TeachersDTO();

        dto.teachers = teachers;

        return dto;
    }

    default CountDTO toCountDTO(long count) {
        return new CountDTO(count);
    }
}
