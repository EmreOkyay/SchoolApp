package practice.app.service.school.student.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.student.dto.CountDTO;
import practice.app.service.school.student.dto.StudentsDTO;
import practice.app.service.school.student.service.StudentService;

@RestController
@RequestMapping("api/read/students")
public class StudentController {
    private final StudentService m_studentService;

    public StudentController(StudentService studentService)
    {
        m_studentService = studentService;
    }

    @GetMapping("count")
    public CountDTO countStudents()
    {
        return m_studentService.countStudents();
    }

    @GetMapping("student/firstname")
    public StudentsDTO findStudentsByFirstName(@RequestParam("fName") String firstName)
    {
        return m_studentService.findStudentByFirstName(firstName);
    }

    @GetMapping("student/lastname")
    public StudentsDTO findStudentsByLastName(@RequestParam("lName") String lastName)
    {
        return m_studentService.findStudentByLastName(lastName);
    }
}
