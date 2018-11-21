package dev.metamorphosis.test;

import javax.annotation.Resource;

import org.springframework.core.convert.ConversionService;

public class BaseConversionTest {

  protected static final String FOO = "foo";
  protected static final String BAR = "bar";
  protected static final String SAMPLE = "sample";

  @Resource
  protected ConversionService conversionService;

  public BaseConversionTest() {
    super();
  }

}