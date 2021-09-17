package com.mm.task05.controller

import com.mm.task05.adderessrepository.AddressRepository
import com.mm.task05.domains.Address
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/address")
class AddressController(val addressRepository: AddressRepository) {

  @PostMapping("/create")
  fun create(@RequestBody address: Address): Mono<Void> {
    return addressRepository.create(address)
  }

  @GetMapping("/readAll")
  fun readAll(): Flux<Address> {
    return addressRepository.readAll()
  }

  @GetMapping("/read/{id}")
  fun readId(@PathVariable id: Long): Mono<Address> {
    return addressRepository.readId(id)
  }

  @PutMapping("/update/{id}")
  fun update(@RequestBody address: Address): Mono<Void> {
    return addressRepository.update(address)
  }

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long): Mono<Void> {
    return addressRepository.delete(id)
  }
}
