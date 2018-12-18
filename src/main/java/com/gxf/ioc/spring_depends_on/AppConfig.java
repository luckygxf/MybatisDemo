package com.gxf.ioc.spring_depends_on;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Configuration
@ComponentScan("com.gxf.ioc.spring_depends_on")
public class AppConfig {

  @Bean(initMethod = "initialize")
  @DependsOn("eventListener")
  public EventPublisherBean eventPublisherBean () {
    return new EventPublisherBean();
  }

  @Bean(name = "eventListener", initMethod = "initialize")
   @Lazy
  public EventListenerBean eventListenerBean () {
    return new EventListenerBean();
  }

  public static void main (String... strings) {
    new AnnotationConfigApplicationContext(AppConfig.class);
  }
}