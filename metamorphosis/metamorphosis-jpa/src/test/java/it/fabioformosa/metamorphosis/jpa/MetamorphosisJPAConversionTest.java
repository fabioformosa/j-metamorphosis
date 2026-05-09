package it.fabioformosa.metamorphosis.jpa;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.fabioformosa.metamorphosis.jpa.entities.converting.ItemEntity;
import it.fabioformosa.metamorphosis.jpa.entities.converting.SimpleEntity;
import it.fabioformosa.metamorphosis.test.dto.ItemDTO;
import it.fabioformosa.metamorphosis.test.dto.NoIdDTO;
import it.fabioformosa.metamorphosis.test.dto.SimpleDTO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class MetamorphosisJPAConversionTest {

  protected static final String FOO = "foo";
  protected static final String BAR = "bar";
  protected static final String SAMPLE = "sample";

  @Resource
  protected ConversionService conversionService;

  private SimpleEntity simpleEntityMock;
  private ItemEntity itemEntityMock;

  @BeforeEach
  public void init() {
    simpleEntityMock = new SimpleEntity();
    simpleEntityMock.setId(1L);
    simpleEntityMock.setFoo(FOO);
    simpleEntityMock.setBar(BAR);

    itemEntityMock = new ItemEntity();
    itemEntityMock.setId(1L);
    itemEntityMock.setName(SAMPLE);
  }

  @Test
  public void fromEntityToDTO() {
    Assertions.assertNotNull(conversionService);

    SimpleDTO simpleDTO = conversionService.convert(simpleEntityMock, SimpleDTO.class);
    Assertions.assertEquals(simpleDTO.getId(), simpleEntityMock.getId());
    Assertions.assertEquals(simpleDTO.getFoo(), simpleEntityMock.getFoo());
    Assertions.assertEquals(FOO + " " + BAR, simpleDTO.getFooBar());
  }

  @Test
  public void fromDTOToEntity() {
    Assertions.assertNotNull(conversionService);

    SimpleDTO mockSimpleDTO = new SimpleDTO();
    mockSimpleDTO.setId(null);
    mockSimpleDTO.setFoo("testDTO");

    SimpleEntity simpleEntity = conversionService.convert(mockSimpleDTO, SimpleEntity.class);
    Assertions.assertEquals(mockSimpleDTO.getId(), simpleEntity.getId());
    Assertions.assertEquals(mockSimpleDTO.getFoo(), simpleEntity.getFoo());
  }

  @Test
  public void fromDTOToEntityWithDBRetrieving() {
    Assertions.assertNotNull(conversionService);

    SimpleDTO mockSimpleDTO = new SimpleDTO();
    mockSimpleDTO.setId(1L);
    mockSimpleDTO.setFoo("testDTO");

    SimpleEntity simpleEntity = conversionService.convert(mockSimpleDTO, SimpleEntity.class);
    Assertions.assertEquals(mockSimpleDTO.getId(), simpleEntity.getId());
    Assertions.assertEquals(mockSimpleDTO.getFoo(), simpleEntity.getFoo());
  }

  @Test
  public void fromNoIdDTOToEntity() {
    Assertions.assertNotNull(conversionService);

    NoIdDTO noIdDTO = new NoIdDTO();
    noIdDTO.setFoo(FOO + "2");
    noIdDTO.setBar(BAR + "2");

    SimpleEntity simpleEntity = conversionService.convert(noIdDTO, SimpleEntity.class);
    Assertions.assertNull(simpleEntity.getId());
    Assertions.assertEquals(noIdDTO.getFoo(), simpleEntity.getFoo());
    Assertions.assertEquals(noIdDTO.getBar(), simpleEntity.getBar());
  }

  @Test
  public void fromItemEntityToItemDTO() {
    Assertions.assertNotNull(conversionService);

    ItemDTO itemDTO = conversionService.convert(itemEntityMock, ItemDTO.class);

    Assertions.assertEquals(itemDTO.getId(), itemEntityMock.getId());
    Assertions.assertEquals(itemDTO.getName(), itemEntityMock.getName());
  }

  @Test
  public void fromItemDTOToItemEntity() {
    Assertions.assertNotNull(conversionService);

    ItemDTO itemDTO = new ItemDTO();
    itemDTO.setId(1L);
    itemDTO.setName(SAMPLE + "2");

    ItemEntity itemEntity = conversionService.convert(itemDTO, ItemEntity.class);
    Assertions.assertEquals(itemDTO.getId(), itemEntity.getId());
    Assertions.assertEquals(itemDTO.getName(), itemEntity.getName());

  }

}
