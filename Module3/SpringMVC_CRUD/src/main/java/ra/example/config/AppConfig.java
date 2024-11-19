package ra.example.config;
// cau hinh spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ra.crud.controller", "ra.crud.service", "ra.crud.repository"})
public class AppConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views1/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}

//ích hoạt Spring MVC và quét các package để tìm thành phần Spring.
//Cấu hình ViewResolver để liên kết controller với file giao diện .jsp.