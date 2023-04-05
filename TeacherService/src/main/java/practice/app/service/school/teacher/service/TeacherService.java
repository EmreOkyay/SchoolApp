package practice.app.service.school.teacher.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.TeacherServiceHelper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.teacher.dto.CountDTO;
import practice.app.service.school.teacher.dto.TeacherSaveDTO;
import practice.app.service.school.teacher.dto.TeachersDTO;
import practice.app.service.school.teacher.mapper.ITeacherMapper;
import practice.app.service.school.teacher.mapper.ITeacherSaveMapper;

@Service
public class TeacherService {
    private final TeacherServiceHelper m_teacherServiceHelper;
    private final ITeacherMapper m_teacherMapper;
    private final ITeacherSaveMapper m_teacherSaveMapper;

    public TeacherService(@Qualifier(BeanName.TEACHER_SERVICE_HELPER) TeacherServiceHelper teacherServiceHelper,
                          ITeacherMapper teacherMapper,
                          ITeacherSaveMapper teacherSaveMapper)
    {
        m_teacherServiceHelper = teacherServiceHelper;
        m_teacherMapper = teacherMapper;
        m_teacherSaveMapper = teacherSaveMapper;
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

    public TeacherSaveDTO save(TeacherSaveDTO teacherSaveDTO)
    {
        m_teacherServiceHelper.saveTeacher(m_teacherSaveMapper.toTeacherSave(teacherSaveDTO));

        return teacherSaveDTO;
    }
}
