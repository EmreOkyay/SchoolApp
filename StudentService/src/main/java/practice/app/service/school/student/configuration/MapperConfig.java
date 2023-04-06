package practice.app.service.school.student.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import practice.app.service.school.student.mapper.IStudentMapper;

// Returns a mapper instance with the given class type
@Configuration
public class MapperConfig {
    @Bean
    @Primary
    public IStudentMapper getMapper()
    {
        return Mappers.getMapper(IStudentMapper.class);
    }
}
