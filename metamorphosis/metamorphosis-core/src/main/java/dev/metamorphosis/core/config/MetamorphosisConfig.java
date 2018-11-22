package dev.metamorphosis.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

@ComponentScan(basePackages = { "dev.metamorphosis" })
public class MetamorphosisConfig {

  private boolean createConversionService;
  private String[] basePackages;

  @Conditional(value = ConversionServiceCreationCondition.class)
  @Bean(name = "conversionService")
  public ConversionService getConversionService() {
    if (!createConversionService)
      return null;
    ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
    bean.afterPropertiesSet();
    return bean.getObject();
  }

  public void setCreateConversionService(boolean createConversionService) {
    this.createConversionService = createConversionService;
  }

  public void setBasePackages(String[] basePackages) {
    this.basePackages = basePackages;
  }

  public boolean isCreateConversionService() {
    return createConversionService;
  }

  public String[] getBasePackage() {
    return basePackages;
  }

}
