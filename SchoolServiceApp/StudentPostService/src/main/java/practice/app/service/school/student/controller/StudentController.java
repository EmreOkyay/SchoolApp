package practice.app.service.school.student.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.student.dto.StudentSaveDTO;
import practice.app.service.school.student.service.StudentService;

@RestController
@RequestMapping("api/update/students")
public class StudentController {
    private final StudentService m_studentService;

    public StudentController(StudentService studentService)
    {
        m_studentService = studentService;
    }

    @PostMapping("student/save")
    public StudentSaveDTO save(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        return m_studentService.saveStudent(studentSaveDTO);
    }
}
