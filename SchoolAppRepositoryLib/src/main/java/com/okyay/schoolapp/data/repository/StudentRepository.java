package com.okyay.schoolapp.data.repository;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.mapper.IStudentMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.STUDENT_REPOSITORY)
public class StudentRepository implements IStudentRepository {
    private static final String COUNT_SQL = "select count(*) from students";
    private static final String FIND_BY_FIRST_NAME_SQL = "select * from students where first_name =:firstName";
    private static final String FIND_BY_LAST_NAME_SQL = "select * from students where last_name =:lastName";
    private static final String FIND_BY_GPA_SQL = "select * from students where gpa =:gpa";
    private static final String SAVE_SQL = """
            insert into students (student_no, first_name, middle_name, last_name, class_name, gpa)
            values (:studentNo, :firstName, :middleName, :lastName, :className, :gpa) \s""";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;
    private final IStudentMapper m_studentMapper;

    public StudentRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate,
                             @Qualifier(BeanName.STUDENT_MAPPER) IStudentMapper studentMapper)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_studentMapper = studentMapper;
    }

    private static Student getStudent(ResultSet rs) throws SQLException
    {
        var studentNo = rs.getLong(1);
        var firstName = rs.getString(2);
        var middleName = Optional.ofNullable(rs.getString(3));
        var lastName = rs.getString(4);
        var className = rs.getString(5);
        var gpa = rs.getDouble(6);

        return new Student(studentNo, firstName, middleName, lastName, className, gpa);
    }

    private static void fillStudents(ResultSet rs, List<Student> students) throws SQLException
    {
        do
            students.add(getStudent(rs));
        while (rs.next());
    }

    @Override
    public long count() {
        var counts = new ArrayList<Long>();

        //                         ?? Doesn't work with (ResultSet rs) -> counts.add(rs.getLong(1)));
        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Iterable<Student> findByFirstName(String firstName)
    {
        var paramMap = new HashMap<String, Object>();
        var students = new ArrayList<Student>();

        paramMap.put("firstName", firstName);

        m_namedParameterJdbcTemplate.query(FIND_BY_FIRST_NAME_SQL, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
    }

    @Override
    public Iterable<Student> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var students = new ArrayList<Student>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FIND_BY_LAST_NAME_SQL, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
    }

    @Override
    public Iterable<Student> findByGpa(double gpa)
    {
        var paramMap = new HashMap<String, Object>();
        var students = new ArrayList<Student>();

        paramMap.put("gpa", gpa);

        m_namedParameterJdbcTemplate.query(FIND_BY_GPA_SQL, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
    }

    @Override
    public <S extends Student> S save(S student)
    {
        var paramSource = new BeanPropertySqlParameterSource(m_studentMapper.toStudentSave(student));

        m_namedParameterJdbcTemplate.update(SAVE_SQL, paramSource);

        return student;
    }

    //--------------------------------------------------------------------------------------------------//

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Student> entities) {
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
    public Iterable<Student> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Student> findAllById(Iterable<Long> id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }
}
