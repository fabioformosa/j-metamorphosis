package it.fabioformosa.metamorphosis.core.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import it.fabioformosa.metamorphosis.core.EnableMetamorphosisConversions;
import it.fabioformosa.metamorphosis.core.mappers.FieldMappingHelper;

public class MetamorphosisConfigRegistrar implements ImportBeanDefinitionRegistrar {

  @Override
  public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
    AnnotationAttributes metamorphosisAttributes = new AnnotationAttributes(
        annotationMetadata.getAnnotationAttributes(EnableMetamorphosisConversions.class.getName()));

    boolean createConversionService = metamorphosisAttributes.getBoolean("createConversionService");
    String[] basePackages = metamorphosisAttributes.getStringArray("basePackages");

    AbstractBeanDefinition metamorphosisBeanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(MetamorphosisConfig.class)
        .setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR)
        .addPropertyValue("createConversionService", createConversionService)
        .addPropertyValue("basePackages", new HashSet<>(Arrays.asList(basePackages))).getBeanDefinition();
    registry.registerBeanDefinition(
        StringUtils.uncapitalize(metamorphosisBeanDefinition.getBeanClass().getSimpleName()),
        metamorphosisBeanDefinition);

    AbstractBeanDefinition fieldMappingHelperBeanDefinition = BeanDefinitionBuilder
        .genericBeanDefinition(FieldMappingHelper.class).setAutowireMode(AbstractBeanDefinition.AUTOWIRE_CONSTRUCTOR)
        .addPropertyValue("basePackages", new HashSet<>(Arrays.asList(basePackages))).getBeanDefinition();
    registry.registerBeanDefinition(
        StringUtils.uncapitalize(fieldMappingHelperBeanDefinition.getBeanClass().getSimpleName()),
        fieldMappingHelperBeanDefinition);

  }

}
