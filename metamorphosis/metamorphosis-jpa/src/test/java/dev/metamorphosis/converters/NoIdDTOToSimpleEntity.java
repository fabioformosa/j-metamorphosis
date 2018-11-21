package dev.metamorphosis.converters;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import dev.metamorphosis.dtos.converting.NoIdDTO;
import dev.metamorphosis.entities.converting.SimpleEntity;
import dev.metamorphosis.jpa.converters.AbstractBaseConverterToEntity;
import dev.metamorphosis.repositories.SimpleJpaRepository;

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
