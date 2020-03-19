package it.fabioformosa.metamorphosis.jpa.converters;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.jpa.converters.AbstractBaseConverterToEntity;
import it.fabioformosa.metamorphosis.jpa.entities.converting.SimpleEntity;
import it.fabioformosa.metamorphosis.jpa.repositories.SimpleJpaRepository;
import it.fabioformosa.metamorphosis.test.dto.NoIdDTO;

@Component
public class NoIdDTOToSimpleEntity extends AbstractBaseConverterToEntity<NoIdDTO, SimpleEntity> {

  @Resource
  private SimpleJpaRepository simpleJpaRepository;

  @Override
  @SuppressWarnings("rawtypes")
  protected JpaRepository getRepository() {
    return simpleJpaRepository;
  }

  @Override
  protected void convert(NoIdDTO source, SimpleEntity target) {
    target.setFoo(source.getFoo());
    target.setBar(source.getBar());
  }

}
