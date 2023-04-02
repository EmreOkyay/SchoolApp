package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;

public interface IStudentMapper {
    Student toStudent(StudentSave studentSave);
}
