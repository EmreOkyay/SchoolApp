package practice.app.service.school.mapper;

import com.okyay.schoolapp.data.entity.Teacher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import practice.app.service.school.dto.TeacherDTO;

@Component
@Primary
public class TeacherMapper implements ITeacherMapper {
    @Override
    public TeacherDTO toTeacherDTO(Teacher teacher)
    {
        var dto = new TeacherDTO();

        dto.teacherNo = teacher.teacherNo;
        dto.firstName = teacher.firstName;
        dto.middleName = teacher.middleName.orElse(null);
        dto.lastName = teacher.lastName;

        return dto;
    }
}
