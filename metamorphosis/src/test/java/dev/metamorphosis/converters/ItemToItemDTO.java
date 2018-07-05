package dev.metamorphosis.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.entities.ItemEntity;

@Component
public class ItemToItemDTO extends DefaultConverterToDTO<ItemEntity, dev.metamorphosis.dtos.ItemDTO> {


}
