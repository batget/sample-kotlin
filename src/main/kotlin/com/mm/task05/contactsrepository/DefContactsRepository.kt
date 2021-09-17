package com.mm.task05.contactsrepository

import com.mm.task05.domains.Contacts
import com.mongodb.client.model.Filters.eq
import com.mongodb.reactivestreams.client.MongoCollection
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class DefContactsRepository(val mongo: MongoCollection<Contacts>): ContactsRepository {

  override fun create(contacts: Contacts): Mono<Void> {
    return Mono.from(mongo
      .insertOne(contacts))
      .then()
  }

  override fun readAll(): Flux<Contacts> {
    return Flux.from(mongo
      .find())
  }

  override fun readId(id: Long): Mono<Contacts> {
    return Mono.from(mongo
      .find(eq("borrowerId",id)))
  }

  override fun update(contacts: Contacts): Mono<Void> {
    return Mono.from(mongo
      .replaceOne(eq("borrowerId",contacts.borrowerId),contacts))
      .then()
  }

  override fun delete(id: Long): Mono<Void> {
    return Mono.from(mongo
      .findOneAndDelete(eq("borrowerId",id)))
      .then()
  }
}
