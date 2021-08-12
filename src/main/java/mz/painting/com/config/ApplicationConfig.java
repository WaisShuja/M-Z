package mz.painting.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "mz.painting.com")
public class ApplicationConfig implements WebMvcConfigurer {


    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("css/**","images/**")
                .addResourceLocations("classpath:static/webapp/css/","classpath:static/webapp/images/");
    }*/

   /* @Bean
    public ViewResolver htmlViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/webapp/html/");
        resolver.setSuffix(".html");
        return resolver;
    }*/

//    Disabling the CSRF



}
