package com.okyay.schoolapp.data.repository;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.mapper.IStudentMapper;
import com.okyay.schoolapp.data.mapper.ITeacherMapper;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private static final String FIND_BY_FIRST_NAME_SQL = "select * from teachers where first_name =:firstName";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from teachers where last_name =:lastName";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private final ITeacherMapper m_teacherMapper;

    public TeacherRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                             @Qualifier(BeanName.TEACHER_MAPPER) ITeacherMapper teacherMapper) {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_teacherMapper = teacherMapper;
    }

    private static Teacher getTeachers(ResultSet rs) throws SQLException
    {
        var teacherNo = rs.getLong(1);
        var firstName = rs.getString(2);
        var middleName = Optional.ofNullable(rs.getString(3));
        var lastName = rs.getString(4);

        return new Teacher(teacherNo, firstName, middleName, lastName);
    }

    private static void fillTeachers(ResultSet rs, List<Teacher> teachers) throws SQLException
    {
        do
            teachers.add(getTeachers(rs));
        while (rs.next());
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, (ResultSet rs) -> counts.add(rs.getLong(1)));

        return counts.get(0);
    }

    @Override
    public Iterable<Teacher> findByFirstName(String firstName)
    {
        var paramMap = new HashMap<String, Object>();
        var teachers = new ArrayList<Teacher>();

        paramMap.put("firstName", firstName);

        m_namedParameterJdbcTemplate.query(FIND_BY_FIRST_NAME_SQL, paramMap, (ResultSet rs) -> fillTeachers(rs, teachers));

        return teachers;
    }

    @Override
    public Iterable<Teacher> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var teachers = new ArrayList<Teacher>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillTeachers(rs, teachers));

        return teachers;
    }

    //---------------------------------------------------------------------------------------------------//

    @Override
    public void delete(Teacher entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Teacher> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Teacher> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Teacher> findAllById(Iterable<Long> id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Teacher> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Teacher> S save(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Teacher> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }
}
