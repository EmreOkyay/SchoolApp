package practice.app.service.school.teacher.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.TeacherServiceHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.teacher.dto.TeacherSaveDTO;
import practice.app.service.school.teacher.mapper.ITeacherSaveMapper;

@Service
public class TeacherService {
    private final TeacherServiceHelper m_teacherServiceHelper;
    private final ITeacherSaveMapper m_teacherSaveMapper;

    public TeacherService(@Qualifier(BeanName.TEACHER_SERVICE_HELPER) TeacherServiceHelper teacherServiceHelper,
                          ITeacherSaveMapper teacherSaveMapper)
    {
        m_teacherServiceHelper = teacherServiceHelper;
        m_teacherSaveMapper = teacherSaveMapper;
    }

    public TeacherSaveDTO save(TeacherSaveDTO teacherSaveDTO)
    {
        m_teacherServiceHelper.saveTeacher(m_teacherSaveMapper.toTeacherSave(teacherSaveDTO));

        return teacherSaveDTO;
    }
}
