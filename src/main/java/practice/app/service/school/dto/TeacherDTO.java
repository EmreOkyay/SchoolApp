package practice.app.service.school.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

public class TeacherDTO {
    public long teacherNo;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
}
