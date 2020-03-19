package it.fabioformosa.metamorphosis.core;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Component;

/**
 * It collects all converters (declared as bean) and registers them into
 * conversionService
 * 
 * @author Fabio.Formosa
 *
 */

@Component
public class ConversionServiceInitializer {

  @Autowired(required = false)
  private Set<Converter<?, ?>> customConverters;

  @Resource
  private ConfigurableConversionService conversionService;

  @PostConstruct
  @SuppressWarnings("rawtypes")
  public void registerConverters() {
    if (customConverters != null)
      for (Converter converter : customConverters) {
        conversionService.addConverter(converter);
      }
  }

}
