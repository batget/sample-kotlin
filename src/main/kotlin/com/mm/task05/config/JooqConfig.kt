package com.mm.task05.config

import com.mm.platform.jooq.config.DefaultJooqBuilder
import com.mm.platform.jooq.config.JooqSettings
import org.cfg4j.provider.ConfigurationProvider
import org.jooq.DSLContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class JooqConfig(private val configurationProvider: ConfigurationProvider) {
  @Bean
  @SuppressWarnings("java:S2696", "squid:S2696")
  open fun dslContext(): DSLContext {
    val settings = configurationProvider.bind("onboarding.jooq", JooqSettings::class.java)
    return DefaultJooqBuilder.of(settings)
      .withDefaultProviders()
      .build()
  }
}
