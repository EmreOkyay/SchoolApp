package com.okyay.schoolapp.data.mapper;

import com.karandev.util.mapstruct.IOptionalMapper;
import com.okyay.schoolapp.data.entity.Teacher;
import com.okyay.schoolapp.data.entity.TeacherSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "TeacherMapperImpl")
public interface ITeacherMapper extends IOptionalMapper {
    @Mapping(source = "middleName", target = "middleNameOpt", qualifiedByName = "toOptional")
    @Mapping(source = "middleName", target = "middleName", ignore = true)
    Teacher toTeacher(TeacherSave teacherSave);
}