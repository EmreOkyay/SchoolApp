package practice.app.service.school.teacher.controller;

import org.springframework.web.bind.annotation.*;
import practice.app.service.school.teacher.dto.TeacherSaveDTO;
import practice.app.service.school.teacher.service.TeacherService;

@RestController
@RequestMapping("api/update/teachers")
public class TeacherController {
    private final TeacherService m_teacherService;

    public TeacherController(TeacherService teacherService)
    {
        m_teacherService = teacherService;
    }
    @PostMapping("teacher/save")
    public TeacherSaveDTO save(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        return m_teacherService.save(teacherSaveDTO);
    }
}
