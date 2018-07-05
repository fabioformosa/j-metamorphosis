package dev.metamorphosis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@Configuration
public class ConversionServiceConfig {

  @Bean(name = "conversionService")
  public ConversionService getConversionService() {
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.afterPropertiesSet();
    return bean.getObject();
  }

}
