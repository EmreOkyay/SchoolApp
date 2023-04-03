package com.okyay.schoolapp.data.entity;

import java.util.Optional;

public class Student { // POJO
    public long studentNo;
    public String firstName;
    public Optional<String> middleName;
    public String lastName;
    public String className;
    public double gpa;

    public Student()
    {}

    public Student(long studentNo, String firstName, Optional<String> middleName, String lastName, String className, double gpa) {
        this.studentNo = studentNo;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.className = className;
        this.gpa = gpa;
    }

    public long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(long studentNo) {
        this.studentNo = studentNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName.orElse(null);
    }

    public void setMiddleName(String middleName) {
        this.middleName = Optional.ofNullable(middleName);
    }

    public Optional<String> getMiddleNameOpt() {
        return middleName;
    }

    public void setMiddleNameOpt(Optional<String> middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
