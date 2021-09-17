package com.mm.task05.adderessrepository

import com.mm.task05.domains.Address
import com.mongodb.client.model.Filters.eq
import com.mongodb.reactivestreams.client.MongoCollection
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class DefAddressRepository(val mongo: MongoCollection<Address>) : AddressRepository {

  override fun create(address: Address): Mono<Void> {
    return Mono.from(mongo
      .insertOne(address))
      .then()
  }

  override fun readAll(): Flux<Address> {
    return Flux.from(
      mongo.find())
  }

  override fun readId(id: Long): Mono<Address> {
    return Mono.from(mongo
        .find(eq("borrowerId", id)))
  }

  override fun update( address: Address): Mono<Void> {
    return Mono.from(mongo
          .replaceOne(eq("borrowerId", address.borrowerId), address))
      .then()
  }

  override fun delete(id: Long): Mono<Void> {
    return Mono.from(mongo
        .findOneAndDelete(eq("borrowerId", id)))
      .then()
  }
}
