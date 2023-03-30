package com.okyay.schoolapp.data.mapper;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.entity.TeacherSave;
import org.springframework.stereotype.Component;

@Component(BeanName.TEACHER_MAPPER)
public class TeacherMapper implements ITeacherMapper{
    @Override
    public Teacher toTeacher(TeacherSave teacherSave) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public TeacherSave toTeacherSave(Teacher teacher) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
