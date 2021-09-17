package com.mm.task05.config

import com.mm.task05.controller.AddressController
import com.mm.task05.controller.ContactsController
import com.mm.task05.controller.DocumentController
import com.mm.task05.controller.WebClientController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ControllerConfig(
  val repositoryConfig: RepositoryConfig,
  val serviceConfig: ServiceConfig,
  val convertorConfig: ConvertorConfig
) {

  @Bean
  open fun contactsController(): ContactsController {
    return ContactsController(repositoryConfig.contactRepository())
  }

  @Bean
  open fun addressController(): AddressController {
    return AddressController((repositoryConfig.addressRepository()))
  }

  @Bean
  open fun webClientController(): WebClientController {
    return WebClientController(serviceConfig.webClientService(), repositoryConfig.contactRepository())
  }

  @Bean
  open fun documentController(): DocumentController {
    return DocumentController(serviceConfig.documentService(),repositoryConfig.borrowerDocument(),convertorConfig.fileConvertor())
  }
}
