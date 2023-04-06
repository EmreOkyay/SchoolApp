package practice.app.service.school.teacher.mapper;

import com.okyay.schoolapp.data.entity.TeacherSave;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import practice.app.service.school.teacher.dto.TeacherSaveDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T16:45:20+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TeacherSaveMapperImpl implements ITeacherSaveMapper {

    @Override
    public TeacherSave toTeacherSave(TeacherSaveDTO teacherSaveDTO) {
        if ( teacherSaveDTO == null ) {
            return null;
        }

        TeacherSave teacherSave = new TeacherSave();

        teacherSave.firstName = teacherSaveDTO.firstName;
        teacherSave.middleName = teacherSaveDTO.middleName;
        teacherSave.lastName = teacherSaveDTO.lastName;
        teacherSave.registerDate = teacherSaveDTO.registerDate;

        return teacherSave;
    }
}
