package com.mm.task05.config

import org.cfg4j.provider.ConfigurationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class DocumentConfig(val configurationProvider: ConfigurationProvider) {

  @Bean
  open fun documentStorage(): WebClient {
    return WebClient.builder()
      .baseUrl(configurationProvider.getProperty("document-storage.url", String::class.java))
      .build()
  }
}
