package com.okyay.schoolapp.data.entity;

import java.util.Optional;

public class Student { // POJO
    public long studentNo;
    public String firstName;
    public Optional<String> middleName;
    public String lastName;
    public String className;
    public double gpa;

    public Student(long studentNo, String firstName, Optional<String> middleName, String lastName, String className, double gpa) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.className = className;
        this.gpa = gpa;
    }
}
