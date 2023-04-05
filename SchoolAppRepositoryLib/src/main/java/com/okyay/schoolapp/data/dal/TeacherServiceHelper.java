package com.okyay.schoolapp.data.dal;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.entity.TeacherSave;
import com.okyay.schoolapp.data.mapper.ITeacherMapper;
import com.okyay.schoolapp.data.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// a facade layer between service and repository
@Component(BeanName.TEACHER_SERVICE_HELPER)
public class TeacherServiceHelper {
    private final ITeacherRepository m_teacherRepository;
    private final ITeacherMapper m_teacherMapper;

    public TeacherServiceHelper(@Qualifier(BeanName.TEACHER_REPOSITORY) ITeacherRepository teacherRepository,
                                @Qualifier(BeanName.TEACHER_MAPPER) ITeacherMapper teacherMapper)
    {
        m_teacherRepository = teacherRepository;
        m_teacherMapper = teacherMapper;
    }

    public long countTeachers()
    {
        return m_teacherRepository.count();
    }

    public Iterable<Teacher> findTeacherByFirstName(String firstName)
    {
        return m_teacherRepository.findByFirstName(firstName);
    }

    public Iterable<Teacher> findTeacherByLastName(String lastName)
    {
        return m_teacherRepository.findByLastName(lastName);
    }

    public TeacherSave saveTeacher(TeacherSave teacherDTO)
    {
        m_teacherRepository.save(m_teacherMapper.toTeacher(teacherDTO));

        return teacherDTO;
    }

}
