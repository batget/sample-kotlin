package com.mm.task05.convertor

import com.mm.crm.documents.model.DocInfo
import com.mm.task05.domains.BorrowerDocumentDomain
import reactor.core.publisher.Mono

class FileConvertor {
  fun convertorFromFile(docInfo:DocInfo): Mono<BorrowerDocumentDomain>{
    return Mono.just(BorrowerDocumentDomain(docInfo.id,docInfo.ownerId,docInfo.ownerIdType,docInfo.docType,docInfo
      .fileName,docInfo.uploadDate))

  }
}
