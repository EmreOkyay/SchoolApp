package com.okyay.schoolapp.data.repository;

import com.okyay.schoolapp.data.entity.Student;
import org.csystem.util.data.repository.ICrudRepository;

public interface IStudentRepository extends ICrudRepository<Student, Long> {
    Iterable<Student> findByFirstName(String firstName);
    Iterable<Student> findByLastName(String lastName);
    Iterable<Student> findByGpa(double gpa);
}
