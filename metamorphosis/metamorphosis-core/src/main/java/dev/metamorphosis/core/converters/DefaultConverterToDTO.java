package dev.metamorphosis.core.converters;

import org.springframework.beans.BeanUtils;

/**
 * Extend this class if you have to convert from entity to DTO. <br>
 * Matching fields by name are automatically set.
 * 
 * <br>
 * 
 * DTO must have a default constructor.
 * 
 * @author Fabio.Formosa
 *
 * @param <S>
 * @param <T>
 */
public class DefaultConverterToDTO<S, T> extends AbstractBaseConverterToDTO<S, T> {

  @Override
  protected void convert(S source, T target) {
    BeanUtils.copyProperties(source, target);
  }

}
