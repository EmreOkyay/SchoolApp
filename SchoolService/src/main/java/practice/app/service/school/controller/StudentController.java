package practice.app.service.school.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.StudentSaveDTO;
import practice.app.service.school.dto.StudentsDTO;
import practice.app.service.school.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService m_studentService;

    public StudentController(StudentService studentService)
    {
        m_studentService = studentService;
    }

    @GetMapping("count")
    public CountDTO count()
    {
        return m_studentService.countStudents();
    }

    @GetMapping("student/firstname")
    public StudentsDTO findByFirstName(@RequestParam("fName") String firstName)
    {
        return m_studentService.findStudentByFirstName(firstName);
    }

    @GetMapping("student/lastname")
    public StudentsDTO findByLastName(@RequestParam("lName") String lastName)
    {
        return m_studentService.findStudentByLastName(lastName);
    }

    @PostMapping("student/save")
    public StudentSaveDTO save(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        return m_studentService.saveStudent(studentSaveDTO);
    }
}
