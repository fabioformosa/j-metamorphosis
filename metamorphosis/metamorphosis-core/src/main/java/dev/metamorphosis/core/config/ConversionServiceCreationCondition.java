package dev.metamorphosis.core.config;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import dev.metamorphosis.core.EnableMetamorphosisConversions;

public class ConversionServiceCreationCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    try {

      if (context.getRegistry().containsBeanDefinition("conversionService"))
        return false;

      ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
      scanner.addIncludeFilter(new AnnotationTypeFilter(EnableMetamorphosisConversions.class));

      Set<BeanDefinition> findCandidateComponents = scanner.findCandidateComponents("*");
      for (BeanDefinition beanDefinition : findCandidateComponents) {
        EnableMetamorphosisConversions[] annotations;
        annotations = Class.forName(beanDefinition.getBeanClassName())
            .getAnnotationsByType(EnableMetamorphosisConversions.class);
        if (annotations != null && annotations.length > 0) {
          EnableMetamorphosisConversions enableMetamorphosisConversions = annotations[0];
          return enableMetamorphosisConversions.createConversionService();
        }
      }
      return false;
    } catch (ClassNotFoundException e) {
      return false;
    }
  }

}
