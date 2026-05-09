package it.fabioformosa.metamorphosis.jpa.converters;

import jakarta.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.jpa.converters.DefaultConverterToEntity;
import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;
import it.fabioformosa.metamorphosis.jpa.repositories.ItemJpaRepository;
import it.fabioformosa.metamorphosis.test.dto.ItemDTO;

@Component
public class ItemDTOToItemEntity extends DefaultConverterToEntity<ItemDTO, ItemEntity> {

  @Resource
  private ItemJpaRepository itemJpaRepository;

  @Override
  protected JpaRepository<ItemEntity, Long> getRepository() {
    return itemJpaRepository;
  }

}
