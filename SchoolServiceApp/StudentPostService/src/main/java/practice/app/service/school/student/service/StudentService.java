package practice.app.service.school.student.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.StudentServiceHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.student.dto.StudentSaveDTO;
import practice.app.service.school.student.mapper.IStudentSaveMapper;

@Service
public class StudentService {
    private final StudentServiceHelper m_studentServiceHelper;
    private final IStudentSaveMapper m_studentSaveMapper;

    public StudentService(@Qualifier(BeanName.STUDENT_SERVICE_HELPER) StudentServiceHelper studentServiceHelper,
                          IStudentSaveMapper studentSaveMapper)
    {
        m_studentServiceHelper = studentServiceHelper;
        m_studentSaveMapper = studentSaveMapper;
    }

    public StudentSaveDTO saveStudent(StudentSaveDTO studentSaveDTO)
    {
        m_studentServiceHelper.saveStudent(m_studentSaveMapper.toStudentSave(studentSaveDTO));

        return studentSaveDTO;
    }
}
