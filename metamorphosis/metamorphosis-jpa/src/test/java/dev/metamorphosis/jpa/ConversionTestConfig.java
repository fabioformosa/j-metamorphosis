package dev.metamorphosis.jpa;

import org.springframework.context.annotation.Configuration;

import dev.metamorphosis.core.EnableMetamorphosisConversions;

@Configuration
@EnableMetamorphosisConversions(basePackage = "dev.metamorphosis")
public class ConversionTestConfig {

}
