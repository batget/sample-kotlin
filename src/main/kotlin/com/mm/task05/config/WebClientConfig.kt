package com.mm.task05.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
open class WebClientConfig {

  @Bean
  open fun webClient(): WebClient {
    return WebClient.create("http://localhost:8888")
  }
}
