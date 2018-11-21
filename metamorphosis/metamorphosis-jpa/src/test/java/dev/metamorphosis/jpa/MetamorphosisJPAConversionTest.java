package dev.metamorphosis.jpa;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.metamorphosis.jpa.converters.ItemDTOToItemEntity;
import dev.metamorphosis.jpa.converters.SimpleDtoToSimpleEntity;
import dev.metamorphosis.jpa.entities.converting.ItemEntity;
import dev.metamorphosis.jpa.entities.converting.SimpleEntity;
import dev.metamorphosis.jpa.repositories.ItemJpaRepository;
import dev.metamorphosis.jpa.repositories.SimpleJpaRepository;
import dev.metamorphosis.test.dto.ItemDTO;
import dev.metamorphosis.test.dto.NoIdDTO;
import dev.metamorphosis.test.dto.SimpleDTO;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ConversionTestConfig.class })
public class MetamorphosisJPAConversionTest {

  protected static final String FOO = "foo";
  protected static final String BAR = "bar";
  protected static final String SAMPLE = "sample";

  @Resource
  protected ConversionService conversionService;

  @Mock
  private SimpleJpaRepository simpleJpaRepository;
  @Mock
  private ItemJpaRepository itemJpaRepository;

  @Resource
  @InjectMocks
  private SimpleDtoToSimpleEntity simpleDtoToSimpleEntity;
  @Resource
  @InjectMocks
  private ItemDTOToItemEntity itemDTOToItem;

  private SimpleEntity simpleEntityMock;
  private ItemEntity itemEntityMock;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);

    simpleEntityMock = new SimpleEntity();
    simpleEntityMock.setId(1L);
    simpleEntityMock.setFoo(FOO);
    simpleEntityMock.setBar(BAR);

    itemEntityMock = new ItemEntity();
    itemEntityMock.setId(1L);
    itemEntityMock.setName(SAMPLE);

    Mockito.when(simpleJpaRepository.findById(1L)).thenReturn(Optional.of(simpleEntityMock));
    Mockito.when(itemJpaRepository.findById(1L)).thenReturn(Optional.of(itemEntityMock));
  }

  @Test
  public void fromEntityToDTO() {
    Assert.assertNotNull(conversionService);

    SimpleDTO simpleDTO = conversionService.convert(simpleEntityMock, SimpleDTO.class);
    Assert.assertEquals(simpleEntityMock.getId(), simpleDTO.getId());
    Assert.assertEquals(simpleEntityMock.getFoo(), simpleDTO.getFoo());
    Assert.assertEquals(FOO + " " + BAR, simpleDTO.getFooBar());
  }

  @Test
  public void fromDTOToEntity() {
    Assert.assertNotNull(conversionService);

    SimpleDTO mockSimpleDTO = new SimpleDTO();
    mockSimpleDTO.setId(null);
    mockSimpleDTO.setFoo("testDTO");

    SimpleEntity simpleEntity = conversionService.convert(mockSimpleDTO, SimpleEntity.class);
    Assert.assertEquals(mockSimpleDTO.getId(), simpleEntity.getId());
    Assert.assertEquals(mockSimpleDTO.getFoo(), simpleEntity.getFoo());
  }

  @Test
  public void fromDTOToEntityWithDBRetrieving() {
    Assert.assertNotNull(conversionService);

    SimpleDTO mockSimpleDTO = new SimpleDTO();
    mockSimpleDTO.setId(1L);
    mockSimpleDTO.setFoo("testDTO");

    SimpleEntity simpleEntity = conversionService.convert(mockSimpleDTO, SimpleEntity.class);
    Assert.assertEquals(mockSimpleDTO.getId(), simpleEntity.getId());
    Assert.assertEquals(mockSimpleDTO.getFoo(), simpleEntity.getFoo());
  }

  @Test
  public void fromNoIdDTOToEntity() {
    Assert.assertNotNull(conversionService);

    NoIdDTO noIdDTO = new NoIdDTO();
    noIdDTO.setFoo(FOO + "2");
    noIdDTO.setBar(BAR + "2");

    SimpleEntity simpleEntity = conversionService.convert(noIdDTO, SimpleEntity.class);
    Assert.assertNull(simpleEntity.getId());
    Assert.assertEquals(noIdDTO.getFoo(), simpleEntity.getFoo());
    Assert.assertEquals(noIdDTO.getBar(), simpleEntity.getBar());
  }

  @Test
  public void fromItemEntityToItemDTO() {
    Assert.assertNotNull(conversionService);

    ItemDTO itemDTO = conversionService.convert(itemEntityMock, ItemDTO.class);

    Assert.assertEquals(itemEntityMock.getId(), itemDTO.getId());
    Assert.assertEquals(itemEntityMock.getName(), itemDTO.getName());
  }

  @Test
  public void fromItemDTOToItemEntity() {
    Assert.assertNotNull(conversionService);

    ItemDTO itemDTO = new ItemDTO();
    itemDTO.setId(1L);
    itemDTO.setName(SAMPLE + "2");

    ItemEntity itemEntity = conversionService.convert(itemDTO, ItemEntity.class);
    Assert.assertEquals(itemDTO.getId(), itemEntity.getId());
    Assert.assertEquals(itemDTO.getName(), itemEntity.getName());

  }

}