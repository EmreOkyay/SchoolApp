package com.okyay.schoolapp.data.dal;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.mapper.IStudentMapper;
import com.okyay.schoolapp.data.repository.IStudentRepository;
import com.okyay.schoolapp.data.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// a facade layer between service and repository
@Component(BeanName.STUDENT_SERVICE_HELPER)
public class StudentServiceHelper {
    private final IStudentRepository m_studentRepository;
    private final IStudentMapper m_studentMapper;
    private final ITeacherRepository m_teacherRepository;

    public StudentServiceHelper(@Qualifier(BeanName.STUDENT_REPOSITORY) IStudentRepository studentRepository,
                                @Qualifier(BeanName.STUDENT_MAPPER) IStudentMapper studentMapper,
                                @Qualifier(BeanName.TEACHER_REPOSITORY) ITeacherRepository teacherRepository)
    {
        m_studentRepository = studentRepository;
        m_studentMapper = studentMapper;
        m_teacherRepository = teacherRepository;
    }

    public long countStudents()
    {
        return m_studentRepository.count();
    }

    public long countTeachers()
    {
        return m_teacherRepository.count();
    }

    public Iterable<Student> findStudentByFirstName(String firstName)
    {
        return m_studentRepository.findByFirstName(firstName);
    }

    public Iterable<Teacher> findTeacherByFirstName(String firstName)
    {
        return m_teacherRepository.findByFirstName(firstName);
    }

    public Iterable<Student> findStudentByLastName(String lastName)
    {
        return m_studentRepository.findByLastName(lastName);
    }

    public Iterable<Teacher> findTeacherByLastName(String lastName)
    {
        return m_teacherRepository.findByLastName(lastName);
    }


    public Iterable<Student> findByGpa(double gpa)
    {
        return m_studentRepository.findByGpa(gpa);
    }

    public StudentSave saveStudent(StudentSave studentDTO)
    {
        m_studentRepository.save(m_studentMapper.toStudent(studentDTO));

        return studentDTO;
    }

}
