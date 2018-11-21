package dev.metamorphosis.core.mappers;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(value = { FIELD, METHOD })
public @interface MappedOnEntityField {

  /**
   * 
   * set field name in entity. <br/>
   * <br/>
   * <ul>
   * <li>If both fields (in DTO and in entity) are not primitive, you must set
   * true cascade attribute.</li>
   * <li>If DTO field is a primitive type and entity field is not-primitive, you
   * must use dots to specify the path of fieldname in entity e.g. dto.foo ->
   * entity.bar.name, then set this attribute to "bar.name"</li>
   * </ul>
   * 
   */
  String entityField() default "";

  /**
   * 
   * set true if both fields (in DTO and in entity) are not primitive.<br/>
   * <b>e.g.</b> dto.fooDto -> entity.foo, then set fieldName to "foo" and
   * cascade=true to discover mapping between all fields within fooDto and all
   * fields within foo
   * 
   */
  boolean cascade() default false;

  /**
   * Use this only in case of cascade=true!<br/>
   * <br/>
   * Set false if you're annotating a dto field that is a not-primitive and you
   * would like to map all its fields to primitive fields within entity<br/>
   * <br/>
   * <b>e.g.</b> myDTO.auditDTO.creationDate -> entity.creationDate
   */
  boolean concatOnCascade() default true;



  /**
   * Use this only in case of cascade=false!<br/>
   * <br/>
   * Set this attribute if you're annotating a not-primitive field in DTO, and you
   * don't want a cascading mapping from all fields within DTO fields to all
   * fields within entity field.<br/>
   * <br/>
   * 
   * e.g. dto.enumDTO.label -> entity.label (annotate enumDTO with cascade=false
   * and innerDtoField="label")
   */
  String innerDtoField() default "";

}
