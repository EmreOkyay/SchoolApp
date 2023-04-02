package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;
import org.springframework.stereotype.Component;

@Component(BeanName.STUDENT_MAPPER)
public class StudentMapper implements IStudentMapper {
    @Override
    public Student toStudent(StudentSave studentSave)
    {
        var studSave = new Student();

        studSave.studentNo = studentSave.studentNo;
        studSave.firstName = studentSave.firstName;
        studSave.middleName = studentSave.middleName;
        studSave.lastName = studentSave.lastName;
        studSave.className = studentSave.className;
        studSave.gpa = studentSave.gpa;

        return studSave;
    }
}
