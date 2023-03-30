package com.okyay.schoolapp.data.entity;

import java.util.Optional;

public class Teacher { // POJO
    public long teacherNo;
    public String firstName;
    public Optional<String> middleName;
    public String lastName;

    public Teacher(long teacherNo, String firstName, Optional<String> middleName, String lastName) {
        this.teacherNo = teacherNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
