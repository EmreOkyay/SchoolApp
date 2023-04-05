package practice.app.service.school.mapper;

import com.okyay.schoolapp.data.entity.StudentSave;
import org.mapstruct.Mapper;
import practice.app.service.school.dto.StudentSaveDTO;

@Mapper(implementationName = "StudentSaveMapperImpl", componentModel = "spring")
public interface IStudentSaveMapper {
    StudentSave toStudentSave(StudentSaveDTO studentSaveDTO);
}
