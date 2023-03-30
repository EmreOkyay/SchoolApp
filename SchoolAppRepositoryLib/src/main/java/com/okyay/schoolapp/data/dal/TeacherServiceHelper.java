package com.okyay.schoolapp.data.dal;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

@Component(BeanName.TEACHER_SERVICE_HELPER)
public class TeacherServiceHelper {
    private final ITeacherRepository m_teacherRepository;

    public TeacherServiceHelper(@Qualifier(BeanName.TEACHER_REPOSITORY) ITeacherRepository teacherRepository)
    {
        m_teacherRepository = teacherRepository;
    }

    public long countTeachers()
    {
        return m_teacherRepository.count();
    }

    public Iterable<Teacher> findTeachersByFirstName(String firstName)
    {
        return m_teacherRepository.findByFirstName(firstName);
    }

    public Iterable<Teacher> findTeachersByLastName(String lastName)
    {
        return m_teacherRepository.findByLastName(lastName);
    }
}
