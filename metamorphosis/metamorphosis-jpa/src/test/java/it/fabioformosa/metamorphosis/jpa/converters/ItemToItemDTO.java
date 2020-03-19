package it.fabioformosa.metamorphosis.jpa.converters;

import org.springframework.stereotype.Component;

import it.fabioformosa.metamorphosis.core.converters.DefaultConverterToDTO;
import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;

@Component
public class ItemToItemDTO extends DefaultConverterToDTO<ItemEntity, it.fabioformosa.metamorphosis.test.dto.ItemDTO> {


}
