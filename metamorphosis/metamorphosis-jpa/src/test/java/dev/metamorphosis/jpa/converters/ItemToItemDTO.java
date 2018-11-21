package dev.metamorphosis.jpa.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.converters.DefaultConverterToDTO;
import dev.metamorphosis.jpa.entities.converting.ItemEntity;

@Component
public class ItemToItemDTO extends DefaultConverterToDTO<ItemEntity, dev.metamorphosis.test.dto.ItemDTO> {


}
