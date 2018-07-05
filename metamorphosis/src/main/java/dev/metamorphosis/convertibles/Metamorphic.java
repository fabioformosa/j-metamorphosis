package dev.metamorphosis.convertibles;

import java.io.Serializable;

/**
 * Your entities or DTOs must implement this interface to be converted by
 * metamorphic converters
 * 
 * @author Fabio.Formosa
 *
 * @param <ID_TYPE>
 */
public interface Metamorphic<ID_TYPE extends Serializable> {
  ID_TYPE getId();
}
