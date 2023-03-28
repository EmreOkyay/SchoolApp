package practice.app.service.school.service;

import org.csystem.util.collection.CollectionUtil;
import org.springframework.stereotype.Service;
import practice.app.service.school.data.repository.IStudentRepository;
import practice.app.service.school.data.repository.ITeacherRepository;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.StudentsDTO;
import practice.app.service.school.mapper.IStudentMapper;

import java.util.Collection;

@Service
public class StudentService {
    private final IStudentRepository m_studentRepository;
    private final IStudentMapper m_studentMapper;

    public StudentService(IStudentRepository studentRepository, IStudentMapper studentMapper)
    {
        m_studentRepository = studentRepository;
        m_studentMapper = studentMapper;
    }

    public CountDTO countStudents()
    {
        return m_studentMapper.toCountDTO(m_studentRepository.count());
    }

    public StudentsDTO findStudentByFirstName(String firstName)
    {
        return m_studentMapper.toStudentsDTO(CollectionUtil.toList(m_studentRepository.findByFirstName(firstName), m_studentMapper::toStudentDTO));

        // m_studentMapper.toStudentsDTO(StreamSupport.stream(m_studentRepository.findByFirstName(firstName).spliterator(), false)
        //          .map(m_studentMapper::toStudentDTO).collect(Collectors.toList()));
    }

    public StudentsDTO findStudentByLastName(String lastName)
    {
        return m_studentMapper.toStudentsDTO(CollectionUtil.toList(m_studentRepository.findByLastName(lastName), m_studentMapper::toStudentDTO));
    }
}
