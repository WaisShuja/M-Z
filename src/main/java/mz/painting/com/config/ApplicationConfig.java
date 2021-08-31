package mz.painting.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan(basePackages = "mz.painting.com")
public class ApplicationConfig implements WebMvcConfigurer {


  @Bean
   public  SpringResourceTemplateResolver resourceTemplateResolver(){
     SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

     templateResolver.setPrefix("classpath:/webapp/WEB-INF/html/");
     templateResolver.setSuffix(".html");
     templateResolver.setTemplateMode(TemplateMode.HTML);
     return templateResolver;
  }

  @Bean
   public SpringTemplateEngine templateEngine(){
     SpringTemplateEngine templateEngine = new SpringTemplateEngine();
     templateEngine.setTemplateResolver(resourceTemplateResolver());
     templateEngine.setEnableSpringELCompiler(true);
     return templateEngine;
  }

}
