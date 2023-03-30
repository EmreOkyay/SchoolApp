package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;

public interface IStudentMapper {
    StudentSave toStudentSave(Student student);
    Student toStudent(StudentSave studentSave);
}
