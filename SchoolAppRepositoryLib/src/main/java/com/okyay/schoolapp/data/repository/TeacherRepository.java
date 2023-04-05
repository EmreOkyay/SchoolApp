package com.okyay.schoolapp.data.repository;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Teacher;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.TEACHER_REPOSITORY)
public class TeacherRepository implements ITeacherRepository {
    private static final String COUNT_SQL = "select count(*) from teachers";
    private static final String FIND_BY_FIRST_NAME_SQL = "select * from students where first_name =:firstName";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from students where last_name =:lastName";

    private static NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    // private static ITeacherMapper m_teacherMapper;

    public TeacherRepository (NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        // m_teacherMapper = teacherMapper;
    }

    private static Teacher getTeacherDetails(ResultSet rs) throws SQLException
    {
        var teacherNo = rs.getLong(1);
        var firstName = rs.getString(2);
        var middleName = Optional.ofNullable(rs.getString(3));
        var lastName = rs.getString(4);
        var registerDate = rs.getDate(5).toLocalDate();

        return new Teacher(teacherNo, firstName, middleName, lastName, registerDate);
    }

    private static void fillTeachers(ResultSet rs, List<Teacher> teachers) throws SQLException
    {
        do
            teachers.add(getTeacherDetails(rs));
        while (rs.next());
    }

    @Override
    public long count() {
        var counts = new ArrayList<Long>();
        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Iterable<Teacher> findByFirstName(String firstName) {
        var paramMap = new HashMap<String, Object>();
        var teachers = new ArrayList<Teacher>();

        paramMap.put("firstName", firstName);

        m_namedParameterJdbcTemplate.query(FIND_BY_FIRST_NAME_SQL, paramMap, (ResultSet rs) -> fillTeachers(rs, teachers));

        return teachers;
    }

    @Override
    public Iterable<Teacher> findByLastName(String lastName) {
        var paramMap = new HashMap<String, Object>();
        var teachers = new ArrayList<Teacher>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillTeachers(rs, teachers));

        return teachers;
    }

    //--------------------------------------------------------------------------------------------------//

    @Override
    public void delete(Object entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable entities) {

    }

    @Override
    public void deleteAllById(Iterable iterable) {

    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public Iterable findAllById(Iterable id) {
        return null;
    }

    @Override
    public Optional findById(Object o) {
        return Optional.empty();
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }
}
