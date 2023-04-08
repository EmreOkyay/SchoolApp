package practice.app.service.school.student.mapper;

import com.okyay.schoolapp.data.entity.StudentSave;
import org.mapstruct.Mapper;
import practice.app.service.school.student.dto.StudentSaveDTO;

@Mapper(implementationName = "StudentSaveMapperImpl", componentModel = "spring")
public interface IStudentSaveMapper {
    StudentSave toStudentSave(StudentSaveDTO studentSaveDTO);
}
