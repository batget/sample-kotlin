package com.mm.task05.config

import org.cfg4j.provider.ConfigurationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class BorrowerServiceConvertorConfig(val configurationProvider: ConfigurationProvider) {
  @Bean
  open fun webClient(): WebClient {
    return WebClient.builder()
      .baseUrl(configurationProvider.getProperty("credit.service.url", String::class.java))
      .build()

  }
}
