package dev.metamorphosis;

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

import dev.metamorphosis.converters.SimpleDtoToSimpleEntity;
import dev.metamorphosis.dtos.SimpleDTO;
import dev.metamorphosis.entities.SimpleEntity;
import dev.metamorphosis.repositories.SimpleJpaRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class ConversionTest {

  private static final String FOO = "foo";
  private static final String BAR = "bar";

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);

    simpleEntityMock = new SimpleEntity();
    simpleEntityMock.setId(1L);
    simpleEntityMock.setFoo(FOO);
    simpleEntityMock.setBar(BAR);

    Mockito.when(simpleJpaRepository.findById(1L)).thenReturn(Optional.of(simpleEntityMock));
  }

  @Resource
  private ConversionService conversionService;

  @Mock
  private SimpleJpaRepository simpleJpaRepository;

  @Resource
  @InjectMocks
  private SimpleDtoToSimpleEntity simpleDtoToSimpleEntity;

  private SimpleEntity simpleEntityMock;

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
    mockSimpleDTO.setId(1L);
    mockSimpleDTO.setFoo("testDTO");

    SimpleEntity simpleEntity = conversionService.convert(mockSimpleDTO, SimpleEntity.class);
    Assert.assertEquals(mockSimpleDTO.getId(), simpleEntity.getId());
    Assert.assertEquals(mockSimpleDTO.getFoo(), simpleEntity.getFoo());
  }

}