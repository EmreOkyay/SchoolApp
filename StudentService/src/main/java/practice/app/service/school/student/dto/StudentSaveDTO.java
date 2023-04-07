package practice.app.service.school.student.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class StudentSaveDTO {
    public long studentNo;
    public String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;
    public String lastName;
    public String className;
    public double gpa;
}
