package dev.metamorphosis.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@Configuration
@ComponentScan(basePackages = { "dev.metamorphosis" })
public class MetamorphosisConfig {

  @Conditional(value = ConversionServiceCreationCondition.class)
  @Bean(name = "conversionService")
  public ConversionService getConversionService() {
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.afterPropertiesSet();
    return bean.getObject();
  }

}
