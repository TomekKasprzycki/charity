package pl.coderslab.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.converters.CategoryDtoFromStringConverter;
import pl.coderslab.charity.converters.InstitutionDtoFromStringConverter;

@Configuration
@ComponentScan(basePackages = "pl.coderslab.charity")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab.charity")
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getInstitutionConverter());
        registry.addConverter(getCategoryConverter());
    }

    @Bean
    public InstitutionDtoFromStringConverter getInstitutionConverter(){return new InstitutionDtoFromStringConverter();}

    @Bean
    public CategoryDtoFromStringConverter getCategoryConverter(){return new CategoryDtoFromStringConverter();}

}
