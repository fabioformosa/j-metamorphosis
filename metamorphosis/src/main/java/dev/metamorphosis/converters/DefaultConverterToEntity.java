package dev.metamorphosis.converters;

import org.springframework.beans.BeanUtils;

/**
 * Extend this class if you have to convert from DTO to Entity. <br>
 * <br>
 *
 * If an ID getter is found into the DTO, so the Entity is retrieved from DB
 * Repository. Otherwise a new entity is instantiated. <br>
 * <br>
 * 
 * Entity must have a default constructor or an ID getter method
 * 
 * <br>
 * 
 * Matching fields by name are automatically set
 * 
 * <br>
 * <br>
 * 
 * Default behaviour: it throws exception if entity is not found by ID of DTO.
 * Override shouldThrowExceptionIfEntityNotFound to change the default
 * behaviour.
 * 
 * @author Fabio.Formosa
 * 
 */
public abstract class DefaultConverterToEntity<S, T> extends AbstractBaseConverterToEntity<S, T> {

  @Override
  protected void convert(S source, T target) {
    BeanUtils.copyProperties(source, target);
  }

}
