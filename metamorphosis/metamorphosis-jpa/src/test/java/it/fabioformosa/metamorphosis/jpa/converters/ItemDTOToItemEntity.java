package it.fabioformosa.metamorphosis.jpa.converters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.jpa.converters.DefaultConverterToEntity;
import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;
import it.fabioformosa.metamorphosis.jpa.repositories.ItemJpaRepository;
import it.fabioformosa.metamorphosis.test.dto.ItemDTO;

@Component
public class ItemDTOToItemEntity extends DefaultConverterToEntity<ItemDTO, ItemEntity> {

  private ItemJpaRepository itemJpaRepository;

  @Override
  @SuppressWarnings("rawtypes")
  protected JpaRepository getRepository() {
    return itemJpaRepository;
  }

}
