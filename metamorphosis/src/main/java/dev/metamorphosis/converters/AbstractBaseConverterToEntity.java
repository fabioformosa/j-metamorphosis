package dev.metamorphosis.converters;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

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
 * <br>
 * 
 * Default behaviour: it throws exception if entity is not found by ID of DTO.
 * Override shouldThrowExceptionIfEntityNotFound to change the default
 * behaviour.
 * 
 * @author Fabio.Formosa
 * 
 */

@SuppressWarnings("rawtypes")
public abstract class AbstractBaseConverterToEntity<S, T> extends AbstractBaseConverter<S, T> {

  @SuppressWarnings("unchecked")
  @Override
  protected T createOrRetrieveTarget(S source) {
    if (extractEntityIdFromDTO(source) == null)
      return createNewTargetInstance(source);

    T entity = (T) Optional.ofNullable(extractEntityIdFromDTO(source)).flatMap(id -> getRepository().findById(id))
        .orElse(null);
    if (shouldThrowExceptionIfEntityNotFound() && entity == null)
      throw entityNotFoundExceptionSupplier(source);

    return entity;
  }

  protected boolean shouldThrowExceptionIfEntityNotFound() {
    return true;
  }

  @SuppressWarnings("unchecked")
  protected <E extends RuntimeException> E entityNotFoundExceptionSupplier(S source) {
    return (E) new EntityNotFoundException(
        "Not found " + getTargetClass() + " with id " + extractEntityIdFromDTO(source));
  }

  protected Serializable extractEntityIdFromDTO(S source) {
    Method idGetter;
    try {
      idGetter = source.getClass().getMethod("getId");
      return (Serializable) idGetter.invoke(source);
    } catch (ReflectiveOperationException e) {
      return null;
    }
  }

  protected abstract JpaRepository getRepository();


}
