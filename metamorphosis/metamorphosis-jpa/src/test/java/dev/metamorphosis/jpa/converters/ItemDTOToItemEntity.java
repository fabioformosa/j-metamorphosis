package dev.metamorphosis.jpa.converters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import dev.metamorphosis.jpa.converters.DefaultConverterToEntity;
import dev.metamorphosis.jpa.entities.converting.ItemEntity;
import dev.metamorphosis.jpa.repositories.ItemJpaRepository;
import dev.metamorphosis.test.dto.ItemDTO;

@Component
public class ItemDTOToItemEntity extends DefaultConverterToEntity<ItemDTO, ItemEntity> {

  private ItemJpaRepository itemJpaRepository;

  @Override
  @SuppressWarnings("rawtypes")
  protected JpaRepository getRepository() {
    return itemJpaRepository;
  }

}
