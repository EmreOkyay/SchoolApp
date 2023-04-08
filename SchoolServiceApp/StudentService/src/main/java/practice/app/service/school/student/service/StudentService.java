package practice.app.service.school.student.service;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.dal.StudentServiceHelper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import practice.app.service.school.student.dto.CountDTO;
import practice.app.service.school.student.dto.StudentSaveDTO;
import practice.app.service.school.student.dto.StudentsDTO;
import practice.app.service.school.student.mapper.IStudentMapper;
import practice.app.service.school.student.mapper.IStudentSaveMapper;

@Service
public class StudentService {
    private final StudentServiceHelper m_studentServiceHelper;
    private final IStudentMapper m_studentMapper;
    private final IStudentSaveMapper m_studentSaveMapper;

    public StudentService(@Qualifier(BeanName.STUDENT_SERVICE_HELPER) StudentServiceHelper studentServiceHelper,
                          IStudentMapper studentMapper,
                          IStudentSaveMapper studentSaveMapper)
    {
        m_studentServiceHelper = studentServiceHelper;
        m_studentMapper = studentMapper;
        m_studentSaveMapper = studentSaveMapper;
    }

    public CountDTO countStudents()
    {
        return m_studentMapper.toCountDTO(m_studentServiceHelper.countStudents());
    }

    public StudentsDTO findStudentByFirstName(String firstName)
    {
        return m_studentMapper.toStudentsDTO(CollectionUtil.toList(m_studentServiceHelper.findStudentByFirstName(firstName), m_studentMapper::toStudentDTO));

        // return m_studentMapper.toStudentsDTO(StreamSupport.stream(m_studentRepository.findByFirstName(firstName).spliterator(), false)
        //          .map(m_studentMapper::toStudentDTO).collect(Collectors.toList()));
    }

    public StudentsDTO findStudentByLastName(String lastName)
    {
        return m_studentMapper.toStudentsDTO(CollectionUtil.toList(m_studentServiceHelper.findStudentByLastName(lastName), m_studentMapper::toStudentDTO));
    }

    public StudentSaveDTO saveStudent(StudentSaveDTO studentSaveDTO)
    {
        m_studentServiceHelper.saveStudent(m_studentSaveMapper.toStudentSave(studentSaveDTO));

        return studentSaveDTO;
    }
}
