package dev.metamorphosis.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.dtos.converting.SimpleDTO;
import dev.metamorphosis.entities.converting.SimpleEntity;

@Component
public class SimpleEntityToSimpleDto extends AbstractBaseConverterToDTO<SimpleEntity, SimpleDTO> {

  @Override
  protected void convert(SimpleEntity source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
