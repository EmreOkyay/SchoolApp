package practice.app.service.school.teacher.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.TeacherServiceHelper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.teacher.dto.CountDTO;
import practice.app.service.school.teacher.dto.TeachersDTO;
import practice.app.service.school.teacher.mapper.ITeacherMapper;

@Service
public class TeacherService {
    private final TeacherServiceHelper m_teacherServiceHelper;
    private final ITeacherMapper m_teacherMapper;

    public TeacherService(@Qualifier(BeanName.TEACHER_SERVICE_HELPER) TeacherServiceHelper teacherServiceHelper,
                          ITeacherMapper teacherMapper)
    {
        m_teacherServiceHelper = teacherServiceHelper;
        m_teacherMapper = teacherMapper;
    }

    public CountDTO count()
    {
        return m_teacherMapper.toCountDTO(m_teacherServiceHelper.countTeachers());
    }

    public TeachersDTO findTeacherByFirstName(String firstName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherServiceHelper.findTeacherByFirstName(firstName), m_teacherMapper::toTeacherDTO));
    }

    public TeachersDTO findTeacherByLastName(String lastName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherServiceHelper.findTeacherByLastName(lastName), m_teacherMapper::toTeacherDTO));
    }
}
