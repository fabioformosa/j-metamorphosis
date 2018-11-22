package dev.metamorphosis.core.config;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

public class ConversionServiceCreationCondition implements Condition {

  private static final String CREATE_CONVERSION_SERVICE_ATTR = "createConversionService";

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    if (context.getRegistry().containsBeanDefinition("conversionService"))
      return false;

    String beanName = StringUtils.uncapitalize(MetamorphosisConfig.class.getSimpleName());
    if (!context.getRegistry().containsBeanDefinition(beanName))
      return false;

    if (!context.getRegistry().getBeanDefinition(beanName).getPropertyValues().contains(CREATE_CONVERSION_SERVICE_ATTR))
      return false;

    return (boolean) context.getRegistry().getBeanDefinition(beanName).getPropertyValues()
        .get(CREATE_CONVERSION_SERVICE_ATTR);
  }

}
