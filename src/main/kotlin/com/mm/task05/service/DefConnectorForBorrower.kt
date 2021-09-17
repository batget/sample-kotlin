package com.mm.task05.service

import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

class DefConnectorForBorrower(private  val webClient: WebClient):ConnectorForBorrower {

  override fun borrowerId(days: Int): Flux<Long> {
    return webClient
      .get()
      .uri("credit/expired/{days}",days)
      .retrieve()
      .bodyToFlux(Long::class.java)
  }
}
