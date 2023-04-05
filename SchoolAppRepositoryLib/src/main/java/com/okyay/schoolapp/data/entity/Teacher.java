package com.okyay.schoolapp.data.entity;

import java.time.LocalDate;
import java.util.Optional;

public class Teacher {
    public long teacher_no;
    public String firstName;
    public Optional<String> middleName;
    public String lastName;
    public LocalDate registerDate;

    public Teacher()
    {}

    public Teacher(long teacher_no, String firstName, Optional<String> middleName, String lastName, LocalDate registerDate)
    {
        this.teacher_no = teacher_no;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.registerDate = registerDate;
    }

    public long getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(long teacher_no) {
        this.teacher_no = teacher_no;
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

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }
}
