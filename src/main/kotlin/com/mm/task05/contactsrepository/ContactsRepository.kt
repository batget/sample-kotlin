package com.mm.task05.contactsrepository


import com.mm.task05.domains.Contacts
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ContactsRepository {

  fun create(contacts: Contacts): Mono<Void>

  fun readAll(): Flux<Contacts>

  fun readId(id:Long): Mono<Contacts>

  fun update(contacts: Contacts): Mono<Void>

  fun delete(id:Long): Mono<Void>

}
