package dev.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import dev.metamorphosis.core.entities.converting.SampleTransientItem;
import dev.metamorphosis.test.dto.ItemDTO;

@Component
public class SampleTransientItemToItemDTO extends DefaultConverterToDTO<SampleTransientItem, ItemDTO> {


}