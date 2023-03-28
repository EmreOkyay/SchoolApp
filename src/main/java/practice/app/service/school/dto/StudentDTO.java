package practice.app.service.school.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Optional;

public class StudentDTO {
    public long studentNo;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    public String className;
    public double gpa;
}
