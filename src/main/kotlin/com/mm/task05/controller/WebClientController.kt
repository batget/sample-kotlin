package com.mm.task05.controller

import com.mm.task05.contactsrepository.ContactsRepository
import com.mm.task05.domains.Contacts
import com.mm.task05.service.DefConnectorForBorrower
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/contacts")
class WebClientController(val defConnectorForBorrower: DefConnectorForBorrower , val contactsRepository: ContactsRepository) {

  @GetMapping("/{days}")
  fun borrowerContacts(@PathVariable days: Int): Flux<Contacts> {
    return Flux.from(defConnectorForBorrower.borrowerId(days)
      .flatMap { borrowerId -> contactsRepository.readId(borrowerId) })
  }
}
