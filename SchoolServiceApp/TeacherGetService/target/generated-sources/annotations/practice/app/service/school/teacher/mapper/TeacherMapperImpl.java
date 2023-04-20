package practice.app.service.school.teacher.mapper;

import com.okyay.schoolapp.data.entity.Teacher;
import javax.annotation.processing.Generated;
import practice.app.service.school.teacher.dto.TeacherDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-20T09:28:44+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class TeacherMapperImpl implements ITeacherMapper {

    @Override
    public TeacherDTO toTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.teacher_no = teacher.getTeacher_no();
        teacherDTO.firstName = teacher.getFirstName();
        teacherDTO.middleName = teacher.getMiddleName();
        teacherDTO.lastName = teacher.getLastName();
        teacherDTO.registerDate = teacher.getRegisterDate();

        return teacherDTO;
    }
}
