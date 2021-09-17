package com.mm.task05.config

import com.mm.task05.service.DefConnectorForBorrower
import com.mm.task05.service.DefDocumentServiceConnector
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
open class ServiceConfig(
  val borrowerServiceConvertorConfig: BorrowerServiceConvertorConfig,
  val documentConfig: DocumentConfig
) {
  @Bean
  open fun webClientService(): DefConnectorForBorrower {
    return DefConnectorForBorrower(borrowerServiceConvertorConfig.webClient())
  }

  @Bean
  open fun documentService(): DefDocumentServiceConnector {
    return DefDocumentServiceConnector(documentConfig.documentStorage())
  }
}
