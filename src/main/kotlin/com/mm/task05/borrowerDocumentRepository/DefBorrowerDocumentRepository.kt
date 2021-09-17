package com.mm.task05.borrowerDocumentRepository

import com.mm.task05.db.tables.BorrowerDocument.BORROWER_DOCUMENT
import org.jooq.DSLContext
import reactor.core.publisher.Mono
import java.time.LocalDateTime

class DefBorrowerDocumentRepository(val dslContext: DSLContext):  BorrowerDocumentRepository{

  override fun createBorrowerDocument(borrowerId: Long, documentId: String, date: LocalDateTime): Mono<Void> {
    return Mono.from(dslContext
        .insertInto(
          BORROWER_DOCUMENT,
          BORROWER_DOCUMENT.BORROWER_ID,
          BORROWER_DOCUMENT.DOCUMENT_ID,
          BORROWER_DOCUMENT.UPLOADED_DATE)
        .values(borrowerId, documentId, date))
      .then()
  }
}
