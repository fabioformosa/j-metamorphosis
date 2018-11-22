package dev.metamorphosis.jpa;

import org.springframework.context.annotation.Configuration;

import dev.metamorphosis.core.EnableMetamorphosisConversions;

@Configuration
@EnableMetamorphosisConversions(basePackages = { "dev.metamorphosis" })
public class ConversionTestConfig {

}
