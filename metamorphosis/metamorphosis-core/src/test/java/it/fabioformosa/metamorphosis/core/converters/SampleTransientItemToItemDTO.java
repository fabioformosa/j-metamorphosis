package it.fabioformosa.metamorphosis.core.converters;

import org.springframework.stereotype.Component;

import it.fabioformosa.core.entities.converting.SampleTransientItem;
import it.fabioformosa.metamorphosis.core.converters.DefaultConverterToDTO;
import it.fabioformosa.metamorphosis.test.dto.ItemDTO;

@Component
public class SampleTransientItemToItemDTO extends DefaultConverterToDTO<SampleTransientItem, ItemDTO> {


}
