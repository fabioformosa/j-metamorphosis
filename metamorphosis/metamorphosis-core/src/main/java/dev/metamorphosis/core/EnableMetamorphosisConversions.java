package dev.metamorphosis.core;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import dev.metamorphosis.core.config.MetamorphosisConfigRegistrar;

@Retention(RUNTIME)
@Target(TYPE)
@Import(MetamorphosisConfigRegistrar.class)
public @interface EnableMetamorphosisConversions {

  @AliasFor(annotation = Import.class, attribute = "value")
  Class<?>[] value() default { MetamorphosisConfigRegistrar.class };

  /**
   * set to basePackage containing metamorphosis DTOs
   */
  String[] basePackages() default "*";

  /**
   * set true to create conversionService
   */
  boolean createConversionService() default true;

}
