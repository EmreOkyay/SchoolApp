package com.okyay.schoolapp.data.dal;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(BeanName.STUDENT_SERVICE_HELPER)
public class StudentServiceHelper {
    private final IStudentRepository m_studentRepository;

    public StudentServiceHelper(@Qualifier(BeanName.STUDENT_REPOSITORY) IStudentRepository studentRepository)
    {
        m_studentRepository = studentRepository;
    }

    public long countStudents()
    {
        return m_studentRepository.count();
    }


    public Iterable<Student> findStudentByFirstName(String firstName)
    {
        return m_studentRepository.findByFirstName(firstName);
    }


    public Iterable<Student> findStudentByLastName(String lastName)
    {
        return m_studentRepository.findByLastName(lastName);
    }


    public Iterable<Student> findByGpa(double gpa)
    {
        return m_studentRepository.findByGpa(gpa);
    }

    public <S extends Student> S saveStudent(S student)
    {
        return m_studentRepository.save(student);
    }

}
