package practice.app.service.school.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.TeacherServiceHelper;
import com.okyay.schoolapp.data.repository.ITeacherRepository;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.TeachersDTO;
import practice.app.service.school.mapper.ITeacherMapper;

@Service
public class TeacherService {
    private final TeacherServiceHelper m_teacherServiceHelper;
    private final ITeacherMapper m_teacherMapper;

    public TeacherService(@Qualifier(BeanName.TEACHER_SERVICE_HELPER) TeacherServiceHelper teacherServiceHelper, ITeacherMapper teacherMapper)
    {
        m_teacherServiceHelper = teacherServiceHelper;
        m_teacherMapper = teacherMapper;
    }

    public CountDTO countTeachers()
    {
        return m_teacherMapper.toCountDTO(m_teacherServiceHelper.countTeachers());
    }

    public TeachersDTO findTeachersByFirstName(String firstName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherServiceHelper.findTeachersByFirstName(firstName), m_teacherMapper::toTeacherDTO));
    }

    public TeachersDTO findTeachersByLastName(String lastName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherServiceHelper.findTeachersByLastName(lastName), m_teacherMapper::toTeacherDTO));
    }
}
