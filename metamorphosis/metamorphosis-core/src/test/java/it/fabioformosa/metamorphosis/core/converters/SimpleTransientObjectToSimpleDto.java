package it.fabioformosa.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import it.fabioformosa.core.entities.converting.SimpleTransientObject;
import it.fabioformosa.metamorphosis.core.converters.AbstractBaseConverterToDTO;
import it.fabioformosa.metamorphosis.test.dto.SimpleDTO;

@Component
public class SimpleTransientObjectToSimpleDto extends AbstractBaseConverterToDTO<SimpleTransientObject, SimpleDTO> {

  @Override
  protected void convert(SimpleTransientObject source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
