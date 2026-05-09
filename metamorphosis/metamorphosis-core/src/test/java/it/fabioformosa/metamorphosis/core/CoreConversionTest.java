package it.fabioformosa.metamorphosis.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import it.fabioformosa.core.entities.converting.SampleTransientItem;
import it.fabioformosa.core.entities.converting.SimpleTransientObject;
import it.fabioformosa.metamorphosis.test.BaseConversionTest;
import it.fabioformosa.metamorphosis.test.dto.ItemDTO;
import it.fabioformosa.metamorphosis.test.dto.SimpleDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class CoreConversionTest extends BaseConversionTest {

  private SimpleTransientObject simpleMock;
  private SampleTransientItem sampleItemMock;

  @BeforeEach
  public void init() {
    simpleMock = new SimpleTransientObject();
    simpleMock.setId(1L);
    simpleMock.setFoo(FOO);
    simpleMock.setBar(BAR);

    sampleItemMock = new SampleTransientItem();
    sampleItemMock.setId(1L);
    sampleItemMock.setName(SAMPLE);

  }

  @Test
  public void fromTransientClassToDTO() {
    Assertions.assertNotNull(conversionService);

    SimpleDTO simpleDTO = conversionService.convert(simpleMock, SimpleDTO.class);
    Assertions.assertEquals(simpleDTO.getId(), simpleMock.getId());
    Assertions.assertEquals(simpleDTO.getFoo(), simpleMock.getFoo());
    Assertions.assertEquals(FOO + " " + BAR, simpleDTO.getFooBar());
  }

  @Test
  public void fromTransientItemToItemDTO() {
    Assertions.assertNotNull(conversionService);

    ItemDTO itemDTO = conversionService.convert(sampleItemMock, ItemDTO.class);

    Assertions.assertEquals(itemDTO.getId(), sampleItemMock.getId());
    Assertions.assertEquals(itemDTO.getName(), sampleItemMock.getName());
  }

}
