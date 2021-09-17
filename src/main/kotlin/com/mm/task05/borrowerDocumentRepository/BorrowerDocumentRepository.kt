package com.mm.task05.borrowerDocumentRepository


import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface BorrowerDocumentRepository {

  fun createBorrowerDocument( borrowerId: Long, documentId: String, date: LocalDateTime): Mono<Void>
}
