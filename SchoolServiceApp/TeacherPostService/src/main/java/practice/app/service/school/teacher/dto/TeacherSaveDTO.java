package practice.app.service.school.teacher.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class TeacherSaveDTO {
    public long studentNo;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    public String className;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate registerDate;
}
