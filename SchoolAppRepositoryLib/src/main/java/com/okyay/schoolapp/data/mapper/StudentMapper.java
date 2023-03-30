package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;
import org.springframework.stereotype.Component;

@Component(BeanName.STUDENT_MAPPER)
public class StudentMapper implements IStudentMapper {
    @Override
    public StudentSave toStudentSave(Student student)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Student toStudent(StudentSave studentSave)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
