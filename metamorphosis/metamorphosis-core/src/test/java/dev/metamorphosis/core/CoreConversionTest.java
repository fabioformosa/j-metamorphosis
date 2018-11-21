package dev.metamorphosis.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.metamorphosis.core.entities.converting.SampleTransientItem;
import dev.metamorphosis.core.entities.converting.SimpleTransientObject;
import dev.metamorphosis.test.BaseConversionTest;
import dev.metamorphosis.test.dto.ItemDTO;
import dev.metamorphosis.test.dto.SimpleDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class CoreConversionTest extends BaseConversionTest {

  private SimpleTransientObject simpleMock;
  private SampleTransientItem sampleItemMock;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);

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
    Assert.assertNotNull(conversionService);

    SimpleDTO simpleDTO = conversionService.convert(simpleMock, SimpleDTO.class);
    Assert.assertEquals(simpleMock.getId(), simpleDTO.getId());
    Assert.assertEquals(simpleMock.getFoo(), simpleDTO.getFoo());
    Assert.assertEquals(FOO + " " + BAR, simpleDTO.getFooBar());
  }

  @Test
  public void fromTransientItemToItemDTO() {
    Assert.assertNotNull(conversionService);

    ItemDTO itemDTO = conversionService.convert(sampleItemMock, ItemDTO.class);

    Assert.assertEquals(sampleItemMock.getId(), itemDTO.getId());
    Assert.assertEquals(sampleItemMock.getName(), itemDTO.getName());
  }

}