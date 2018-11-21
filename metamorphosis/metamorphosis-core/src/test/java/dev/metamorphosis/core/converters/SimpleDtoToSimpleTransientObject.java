package dev.metamorphosis.core.converters;

import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.entities.converting.SimpleTransientObject;
import dev.metamorphosis.test.dto.SimpleDTO;

@Component
public class SimpleDtoToSimpleTransientObject extends AbstractBaseConverterToDTO<SimpleDTO, SimpleTransientObject> {

  @Override
  protected void convert(SimpleDTO source, SimpleTransientObject target) {
    target.setFoo(source.getFoo());

    String bar = Optional.ofNullable(source.getFooBar()).map(fooBar -> fooBar.split(" "))
        .map(split -> split.length > 1 ? split[1] : null).orElse(null);
    target.setBar(bar);
  }

}
