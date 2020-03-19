package it.fabioformosa.metamorphosis.jpa.converters;

import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.core.converters.AbstractBaseConverterToDTO;
import it.fabioformosa.metamorphosis.jpa.entities.converting.SimpleEntity;
import it.fabioformosa.metamorphosis.test.dto.SimpleDTO;

@Component
public class SimpleEntityToSimpleDto extends AbstractBaseConverterToDTO<SimpleEntity, SimpleDTO> {

  @Override
  protected void convert(SimpleEntity source, SimpleDTO target) {
    target.setId(source.getId());
    target.setFoo(source.getFoo());
    target.setFooBar(source.getFoo() + " " + source.getBar());
  }

}
