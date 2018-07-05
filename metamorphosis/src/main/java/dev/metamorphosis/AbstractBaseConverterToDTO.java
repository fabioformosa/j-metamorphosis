package dev.metamorphosis;

/**
 * 
 * Extend this class if you have to convert from entity to DTO. <br>
 * <br>
 * 
 * DTO must have a default constructor
 * 
 * @author Fabio.Formosa
 * 
 * @param <S>
 * @param <T>
 */
public abstract class AbstractBaseConverterToDTO<S, T> extends AbstractBaseConverter<S, T> {

  @Override
  protected abstract void convert(S source, T target);

  @Override
  protected T createOrRetrieveTarget(S source) {
    return createNewTargetInstance(source);
  }

}
