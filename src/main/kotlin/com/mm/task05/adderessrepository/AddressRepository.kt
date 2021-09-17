package com.mm.task05.adderessrepository

import com.mm.task05.domains.Address
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AddressRepository {

  fun create(address: Address): Mono<Void>

  fun readAll(): Flux<Address>

  fun readId(id:Long): Mono<Address>

  fun update(address: Address): Mono<Void>

  fun delete(id:Long):Mono<Void>
}
