package dev.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.entities.converting.SimpleTransientObject;
import dev.metamorphosis.test.dto.NoIdDTO;

@Component
public class NoIdDTOToSimpleTransientObject extends DefaultConverterToDTO<NoIdDTO, SimpleTransientObject> {

  @Override
  protected void convert(NoIdDTO source, SimpleTransientObject target) {
    target.setFoo(source.getFoo());
    target.setBar(source.getBar());
  }

}
