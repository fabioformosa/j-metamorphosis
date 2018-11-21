package dev.metamorphosis.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.converters.DefaultConverterToDTO;
import dev.metamorphosis.entities.converting.ItemEntity;

@Component
public class ItemToItemDTO extends DefaultConverterToDTO<ItemEntity, dev.metamorphosis.dtos.converting.ItemDTO> {


}
