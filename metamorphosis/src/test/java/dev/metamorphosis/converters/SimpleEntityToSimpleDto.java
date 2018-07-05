package dev.metamorphosis.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.AbstractBaseConverterToDTO;
import dev.metamorphosis.dtos.SimpleDTO;
import dev.metamorphosis.entities.SimpleEntity;

@Component
public class SimpleEntityToSimpleDto extends AbstractBaseConverterToDTO<SimpleEntity, SimpleDTO> {

  @Override
  protected void convert(SimpleEntity source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
