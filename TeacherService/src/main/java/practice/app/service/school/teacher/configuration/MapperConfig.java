package practice.app.service.school.teacher.configuration;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import practice.app.service.school.teacher.mapper.ITeacherMapper;

@Configuration
public class MapperConfig {
    @Bean
    @Primary
    public ITeacherMapper getMapper()
    {
        return Mappers.getMapper(ITeacherMapper.class);
    }
}
