package it.fabioformosa.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import it.fabioformosa.core.entities.converting.SimpleTransientObject;
import it.fabioformosa.metamorphosis.core.converters.DefaultConverterToDTO;
import it.fabioformosa.metamorphosis.test.dto.NoIdDTO;

@Component
public class NoIdDTOToSimpleTransientObject extends DefaultConverterToDTO<NoIdDTO, SimpleTransientObject> {

  @Override
  protected void convert(NoIdDTO source, SimpleTransientObject target) {
    target.setFoo(source.getFoo());
    target.setBar(source.getBar());
  }

}
