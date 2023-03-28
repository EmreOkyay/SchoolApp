package practice.app.service.school.data.repository;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import practice.app.service.school.data.entity.Student;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IStudentRepository {
    private static final String COUNT_SQL = "select count(*) from students";
    private static final String FINDY_BY_FIRST_NAME = "select * from students where first_name =:firstName";
    private static final String FINDY_BY_LAST_NAME = "select * from students where last_name =:lastName";
    private static final String FIND_BY_GPA = "select * from students where gpa =:gpa";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    public StudentRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate)
    {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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

        m_namedParameterJdbcTemplate.query(FINDY_BY_FIRST_NAME, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
    }

    @Override
    public Iterable<Student> findByLastName(String lastName)
    {
        var paramMap = new HashMap<String, Object>();
        var students = new ArrayList<Student>();

        paramMap.put("lastName", lastName);

        m_namedParameterJdbcTemplate.query(FINDY_BY_LAST_NAME, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
    }

    @Override
    public Iterable<Student> findByGpa(double gpa)
    {
        var paramMap = new HashMap<String, Object>();
        var students = new ArrayList<Student>();

        paramMap.put("gpa", gpa);

        m_namedParameterJdbcTemplate.query(FIND_BY_GPA, paramMap, (ResultSet rs) -> fillStudents(rs, students));

        return students;
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
    public <S extends Student> S save(S entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }
}
