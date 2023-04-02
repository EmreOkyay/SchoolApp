package practice.app.service.school.mapper;

import com.okyay.schoolapp.data.entity.StudentSave;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import practice.app.service.school.dto.StudentSaveDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-02T19:14:23+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class StudentSaveMapperImpl implements IStudentSaveMapper {

    @Override
    public StudentSave toStudentSave(StudentSaveDTO studentSaveDTO) {
        if ( studentSaveDTO == null ) {
            return null;
        }

        StudentSave studentSave = new StudentSave();

        studentSave.studentNo = studentSaveDTO.studentNo;
        studentSave.firstName = studentSaveDTO.firstName;
        studentSave.middleName = studentSaveDTO.middleName;
        studentSave.lastName = studentSaveDTO.lastName;
        studentSave.className = studentSaveDTO.className;
        studentSave.gpa = studentSaveDTO.gpa;

        return studentSave;
    }
}