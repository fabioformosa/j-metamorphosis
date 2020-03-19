package it.fabioformosa.metamorphosis.jpa;

import org.springframework.context.annotation.Configuration;

import it.fabioformosa.metamorphosis.core.EnableMetamorphosisConversions;

@Configuration
@EnableMetamorphosisConversions(basePackages = { "it.fabioformosa.metamorphosis" })
public class ConversionTestConfig {

}
