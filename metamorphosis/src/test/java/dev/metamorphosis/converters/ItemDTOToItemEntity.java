package dev.metamorphosis.converters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import dev.metamorphosis.dtos.converting.ItemDTO;
import dev.metamorphosis.entities.converting.ItemEntity;
import dev.metamorphosis.repositories.ItemJpaRepository;

@Component
public class ItemDTOToItemEntity extends DefaultConverterToEntity<ItemDTO, ItemEntity> {

  private ItemJpaRepository itemJpaRepository;

  @Override
  @SuppressWarnings("rawtypes")
  protected JpaRepository getRepository() {
    return itemJpaRepository;
  }

}
