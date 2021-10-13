package mz.painting.com.config;

import mz.painting.com.interceptors.RegisterInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.util.PropertyResourceBundle;

@Configuration
@ComponentScan(basePackages = "mz.painting.com")
public class ApplicationConfig implements WebMvcConfigurer {


  @Bean
   public  SpringResourceTemplateResolver resourceTemplateResolver(){
     SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

     templateResolver.setPrefix("classpath:/static/webapp/WEB-INF/html/");
     templateResolver.setSuffix(".html");
     templateResolver.setTemplateMode(TemplateMode.HTML);
     return templateResolver;
  }



  @Bean
   public SpringTemplateEngine templateEngine(){
     var templateEngine = new SpringTemplateEngine();
     templateEngine.setTemplateResolver(resourceTemplateResolver());
     templateEngine.setEnableSpringELCompiler(true);
     return templateEngine;
  }

  @Override
  public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer){
    asyncSupportConfigurer.setDefaultTimeout(5000);
    asyncSupportConfigurer.setTaskExecutor(mvcTaskExecutor());
  }

  @Bean
  public AsyncTaskExecutor mvcTaskExecutor(){
    var threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setThreadNamePrefix("Thread-: ");
    return threadPoolTaskExecutor;
  }

//   Interceptor for registering

  @Override
  public void addInterceptors(InterceptorRegistry registry){
    registry.addInterceptor(new RegisterInterceptor()).addPathPatterns("/home");


  }
}
