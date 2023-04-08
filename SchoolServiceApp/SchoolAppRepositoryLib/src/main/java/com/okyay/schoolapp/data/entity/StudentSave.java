package com.okyay.schoolapp.data.entity;

public class StudentSave { // POJO
    public long studentNo;
    public String firstName;
    public String middleName;
    public String lastName;
    public String className;
    public double gpa;

    @Override
    public int hashCode()
    {
        return Long.valueOf(studentNo).hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Student s && s.studentNo == studentNo;
    }

    //...
}
