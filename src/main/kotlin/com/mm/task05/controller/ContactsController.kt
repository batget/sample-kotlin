package com.mm.task05.controller

import com.mm.task05.contactsrepository.ContactsRepository
import com.mm.task05.domains.Contacts
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
@RequestMapping("/contacts")
class ContactsController(val contactsRepository: ContactsRepository) {

  @PostMapping("/create")
  fun create(@RequestBody contacts: Contacts): Mono<Void> {
    return contactsRepository.create(contacts)
  }

  @GetMapping("/readAll")
  fun readAll(): Flux<Contacts> {
    return contactsRepository.readAll()
  }

  @GetMapping("/read/{id}")
  fun readId(@PathVariable id: Long): Mono<Contacts> {
    return contactsRepository.readId(id)
  }

  @PutMapping("/update/{id}")
  fun update(@RequestBody contacts: Contacts): Mono<Void> {
    return contactsRepository.update(contacts)
  }

  @DeleteMapping("/delete/{id}")
  fun delete(@PathVariable id: Long): Mono<Void> {
    return contactsRepository.delete(id)
  }
}
