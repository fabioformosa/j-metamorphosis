package dev.metamorphosis.core;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMetamorphosisConversions(basePackages = { "dev.metamorphosis" })
public class ConversionTestConfig {

}
