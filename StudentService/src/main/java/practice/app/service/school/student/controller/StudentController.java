package practice.app.service.school.student.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.student.dto.CountDTO;
import practice.app.service.school.student.dto.StudentSaveDTO;
import practice.app.service.school.student.dto.StudentsDTO;
import practice.app.service.school.student.dto.TeachersDTO;
import practice.app.service.school.student.service.StudentService;

@RestController
@RequestMapping("api/students")
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

    @PostMapping("student/save")
    public StudentSaveDTO save(@RequestBody StudentSaveDTO studentSaveDTO)
    {
        return m_studentService.saveStudent(studentSaveDTO);
    }

    // -------------------------------------------------------------------------------------- //

    @GetMapping("teacher/firstname")
    public TeachersDTO findTeachersByFirstName(@RequestParam("fName") String firstName)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("teacher/lastname")
    public TeachersDTO findTeachersByLastName(@RequestParam("lName") String lastName)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @GetMapping("teacher/count")
    public CountDTO countTeachers()
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
