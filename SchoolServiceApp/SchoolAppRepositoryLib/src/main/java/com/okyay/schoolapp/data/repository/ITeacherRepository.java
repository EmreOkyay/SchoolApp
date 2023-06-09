package com.okyay.schoolapp.data.repository;

import com.okyay.schoolapp.data.entity.Teacher;
import org.csystem.util.data.repository.ICrudRepository;

public interface ITeacherRepository extends ICrudRepository {
    Iterable<Teacher> findByFirstName(String firstName);
    Iterable<Teacher> findByLastName(String lastName);
}
