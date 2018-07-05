package dev.metamorphosis;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.metamorphosis.convertibles.Metamorphic;

/**
 * Extend this class if you have to convert from DTO to Entity. <br>
 * <br>
 *
 * The Entity is retrieved from DB Repository, according to ID of DTO. <br>
 * <br>
 * 
 * Entity must have a default constructor and must implement
 * {@link dev.metamorphosis.convertibles.Metamorphic} <br>
 * 
 * <br>
 * <br>
 * 
 * Default behaviour: it throws exception if entity is not found. Override
 * shouldThrowExceptionIfEntityNotFound to change the default behaviour.
 * 
 * @author Fabio.Formosa
 * @param <ID_TYPE>
 * @param <ID_TYPE>
 * 
 */

@SuppressWarnings("rawtypes")
public abstract class AbstractBaseConverterToEntity<S extends Metamorphic, T extends Metamorphic>
extends AbstractBaseConverter<S, T> {

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
    return source.getId();
  }

  protected abstract JpaRepository getRepository();


}
