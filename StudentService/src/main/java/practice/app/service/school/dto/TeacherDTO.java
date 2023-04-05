package practice.app.service.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.Optional;

public class TeacherDTO {
    public long teacher_no;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate registerDate;
}
