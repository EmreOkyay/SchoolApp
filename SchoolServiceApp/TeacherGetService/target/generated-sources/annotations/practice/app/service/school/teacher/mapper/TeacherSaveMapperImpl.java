package practice.app.service.school.teacher.mapper;

import com.okyay.schoolapp.data.entity.TeacherSave;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-10T22:55:15+0300",
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

        teacherSave.teacher_no = teacherSaveDTO.teacher_no;
        teacherSave.firstName = teacherSaveDTO.firstName;
        teacherSave.middleName = teacherSaveDTO.middleName;
        teacherSave.lastName = teacherSaveDTO.lastName;
        teacherSave.registerDate = teacherSaveDTO.registerDate;

        return teacherSave;
    }
}
