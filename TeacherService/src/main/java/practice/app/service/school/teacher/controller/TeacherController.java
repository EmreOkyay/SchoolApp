package practice.app.service.school.teacher.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.teacher.dto.CountDTO;
import practice.app.service.school.teacher.dto.TeacherSaveDTO;
import practice.app.service.school.teacher.dto.TeachersDTO;
import practice.app.service.school.teacher.service.TeacherService;

@RestController
@RequestMapping("api/teachers")
public class TeacherController {
    private final TeacherService m_teacherService;

    public TeacherController(TeacherService teacherService)
    {
        m_teacherService = teacherService;
    }

    @GetMapping("count")
    public CountDTO countTeachers()
    {
        return m_teacherService.count();
    }

    @GetMapping("teacher/firstname")
    public TeachersDTO findTeachersByFirstName(@RequestParam("fName") String firstName)
    {
        return m_teacherService.findTeacherByFirstName(firstName);
    }

    @GetMapping("teacher/lastname")
    public TeachersDTO findTeachersByLastName(@RequestParam("lName") String lastName)
    {
        return m_teacherService.findTeacherByLastName(lastName);
    }

    @PostMapping("teacher/save")
    public TeacherSaveDTO save(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        return m_teacherService.save(teacherSaveDTO);
    }
}
