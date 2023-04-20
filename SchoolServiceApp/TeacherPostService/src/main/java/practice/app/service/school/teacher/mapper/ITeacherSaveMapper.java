package practice.app.service.school.teacher.mapper;

import com.okyay.schoolapp.data.entity.TeacherSave;
import org.mapstruct.Mapper;
import practice.app.service.school.teacher.dto.TeacherSaveDTO;

@Mapper(implementationName = "TeacherSaveMapperImpl", componentModel = "spring")
public interface ITeacherSaveMapper {
    TeacherSave toTeacherSave(TeacherSaveDTO teacherSaveDTO);
}
