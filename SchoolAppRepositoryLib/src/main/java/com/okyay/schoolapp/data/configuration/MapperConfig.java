package com.okyay.schoolapp.data.configuration;

import com.okyay.schoolapp.data.BeanName;
import com.okyay.schoolapp.data.mapper.IStudentMapper;
import com.okyay.schoolapp.data.mapper.ITeacherMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Returns a mapper instance with the given class type
@Configuration(BeanName.MAPPER_CONFIG)
public class MapperConfig {
    @Bean(BeanName.STUDENT_MAPPER)
    public IStudentMapper getStudentMapper()
    {
        return Mappers.getMapper(IStudentMapper.class);
    }

    @Bean(BeanName.TEACHER_MAPPER)
    public ITeacherMapper getTeacherMapper()
    {
        return Mappers.getMapper(ITeacherMapper.class);
    }
}
