package practice.app.service.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.app.service.school.dto.CountDTO;
import practice.app.service.school.dto.TeachersDTO;
import practice.app.service.school.service.TeacherService;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private final TeacherService m_teacherService;

    public TeacherController(TeacherService teacherService)
    {
        m_teacherService = teacherService;
    }

    @GetMapping("count")
    public CountDTO count()
    {
        return m_teacherService.countTeachers();
    }

    @GetMapping("teacher/firstname")
    public TeachersDTO findByFirstName(@RequestParam("fName") String firstName)
    {
        return m_teacherService.findTeachersByFirstName(firstName);
    }

    @GetMapping("teacher/lastname")
    public TeachersDTO findByLastName(@RequestParam("lName") String lastName)
    {
        return m_teacherService.findTeachersByLastName(lastName);
    }

}
