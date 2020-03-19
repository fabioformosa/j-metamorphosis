package it.fabioformosa.metamorphosis.core.mappers;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface MappedOnEntity {

  /**
   * Class of entity mapped by DTO
   */
  Class<?> value() default Void.class;

}
