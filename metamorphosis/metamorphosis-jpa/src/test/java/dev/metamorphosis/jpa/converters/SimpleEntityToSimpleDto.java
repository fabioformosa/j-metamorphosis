package dev.metamorphosis.jpa.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.converters.AbstractBaseConverterToDTO;
import dev.metamorphosis.jpa.entities.converting.SimpleEntity;
import dev.metamorphosis.test.dto.SimpleDTO;

@Component
public class SimpleEntityToSimpleDto extends AbstractBaseConverterToDTO<SimpleEntity, SimpleDTO> {

  @Override
  protected void convert(SimpleEntity source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
