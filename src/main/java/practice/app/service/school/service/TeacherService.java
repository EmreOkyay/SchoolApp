package practice.app.service.school.service;

import org.csystem.util.collection.CollectionUtil;
import org.springframework.stereotype.Service;
import practice.app.service.school.data.repository.ITeacherRepository;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.TeachersDTO;
import practice.app.service.school.mapper.ITeacherMapper;

@Service
public class TeacherService {
    private final ITeacherRepository m_teacherRepository;
    private final ITeacherMapper m_teacherMapper;

    public TeacherService(ITeacherRepository m_teacherRepository, ITeacherMapper m_teacherMapper) {
        this.m_teacherRepository = m_teacherRepository;
        this.m_teacherMapper = m_teacherMapper;
    }

    public CountDTO countTeachers()
    {
        return m_teacherMapper.toCountDTO(m_teacherRepository.count());
    }

    public TeachersDTO findTeachersByFirstName(String firstName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherRepository.findByFirstName(firstName), m_teacherMapper::toTeacherDTO));
    }

    public TeachersDTO findTeachersByLastName(String lastName)
    {
        return m_teacherMapper.toTeachersDTO(CollectionUtil.toList(m_teacherRepository.findByLastName(lastName), m_teacherMapper::toTeacherDTO));
    }
}
