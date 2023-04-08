package com.okyay.schoolapp.data.mapper;

import com.karandev.util.mapstruct.IOptionalMapper;
import com.okyay.schoolapp.data.entity.Student;
import com.okyay.schoolapp.data.entity.StudentSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "StudentMapperImpl")
public interface IStudentMapper extends IOptionalMapper {
    @Mapping(source = "middleName", target = "middleNameOpt", qualifiedByName = "toOptional")
    @Mapping(source = "middleName", target = "middleName", ignore = true)
    Student toStudent(StudentSave studentSave);
}
