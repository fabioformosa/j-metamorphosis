package dev.metamorphosis.core.config;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import dev.metamorphosis.core.EnableMetamorphosisConversions;
import dev.metamorphosis.core.mappers.FieldMappingHelper;

public class MetamorphosisConfigRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
    AnnotationAttributes metamorphosisAttributes = new AnnotationAttributes(
        annotationMetadata.getAnnotationAttributes(EnableMetamorphosisConversions.class.getName()));

    boolean createConversionService = metamorphosisAttributes.getBoolean("createConversionService");
    String basePackage = metamorphosisAttributes.getString("basePackage");

    AbstractBeanDefinition metamorphosisBeanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(MetamorphosisConfig.class)
        .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR)
        .addPropertyValue("createConversionService", createConversionService)
        .addPropertyValue("basePackage", basePackage).getBeanDefinition();
    registry.registerBeanDefinition(
        StringUtils.uncapitalize(metamorphosisBeanDefinition.getBeanClass().getSimpleName()),
        metamorphosisBeanDefinition);

    AbstractBeanDefinition fieldMappingHelperBeanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(FieldMappingHelper.class).setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR)
        .addPropertyValue("basePackage", basePackage).getBeanDefinition();
    registry.registerBeanDefinition(
        StringUtils.uncapitalize(fieldMappingHelperBeanDefinition.getBeanClass().getSimpleName()),
        fieldMappingHelperBeanDefinition);

  }

}
