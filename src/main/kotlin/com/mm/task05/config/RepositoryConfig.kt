package com.mm.task05.config

import com.mm.task05.adderessrepository.AddressRepository
import com.mm.task05.adderessrepository.DefAddressRepository
import com.mm.task05.borrowerDocumentRepository.BorrowerDocumentRepository
import com.mm.task05.borrowerDocumentRepository.DefBorrowerDocumentRepository

import com.mm.task05.contactsrepository.ContactsRepository
import com.mm.task05.contactsrepository.DefContactsRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class RepositoryConfig(val mongo: MongoConfig,val jooqConfig: JooqConfig) {

  @Bean
  open fun contactRepository(): ContactsRepository {
    return DefContactsRepository(mongo.contactsCollection())
  }

  @Bean
  open fun addressRepository(): AddressRepository {
    return DefAddressRepository(mongo.addressCollection())
  }
@Bean
open fun borrowerDocument(): DefBorrowerDocumentRepository{
  return DefBorrowerDocumentRepository(jooqConfig.dslContext())
}
}
