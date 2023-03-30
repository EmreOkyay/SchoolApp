package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.entity.TeacherSave;

public interface ITeacherMapper {
    Teacher toTeacher(TeacherSave teacherSave);
    TeacherSave toTeacherSave(Teacher teacher);
}
