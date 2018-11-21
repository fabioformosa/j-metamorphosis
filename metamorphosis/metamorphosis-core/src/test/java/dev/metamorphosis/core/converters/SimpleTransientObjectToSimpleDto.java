package dev.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.entities.converting.SimpleTransientObject;
import dev.metamorphosis.test.dto.SimpleDTO;

@Component
public class SimpleTransientObjectToSimpleDto extends AbstractBaseConverterToDTO<SimpleTransientObject, SimpleDTO> {

  @Override
  protected void convert(SimpleTransientObject source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
