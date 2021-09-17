package com.mm.task05.controller

import com.mm.task05.borrowerDocumentRepository.DefBorrowerDocumentRepository
import com.mm.task05.convertor.FileConvertor
import com.mm.task05.domains.BorrowerDocumentDomain
import com.mm.task05.enums.DocEnum
import com.mm.task05.service.DefDocumentServiceConnector
import org.bson.types.ObjectId
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@RestController
@RequestMapping("/document")
class DocumentController(
  val defDocumentServiceConnector: DefDocumentServiceConnector,
  val borrowerDocumentRepository: DefBorrowerDocumentRepository,
  val convertor: FileConvertor

) {

  @PostMapping("/{ownerId}/{ownerIdType}/{docEnum}")
  fun uploadDocument(@RequestParam file: FilePart, @PathVariable ownerId: Long, @PathVariable ownerIdType: String, @PathVariable docEnum:String
  ) : Mono<Void> {
    return defDocumentServiceConnector.uploadDocument(file, ownerId, ownerIdType, docEnum)
      .flatMap { borrowerDocumentRepository.createBorrowerDocument(ownerId,it.id, LocalDateTime.now()) }
  }

  @GetMapping("/{ownerId}/{ownerIdType}/{docType}")
  fun documentInfo(
    @PathVariable("ownerId") ownerId: Long, @PathVariable("ownerIDType") ownerIdType: String, @PathVariable
      ("docType") docEnum:DocEnum
  ): Flux<BorrowerDocumentDomain> {
    return defDocumentServiceConnector.documentInfo(ownerId, ownerIdType, docEnum)
      .flatMap { convertor.convertorFromFile(it) }
  }

  @GetMapping("/{fileId}")
  fun downloadDocument(@PathVariable("fileId") fileId: ObjectId): Mono<ByteArray> {
    return defDocumentServiceConnector.downloadDocument(fileId)
  }

  @GetMapping("/delete/{fileId}")
  fun deleteDocument(@PathVariable("fileId") fileId: ObjectId): Mono<Boolean> {
    return defDocumentServiceConnector.deleteDocument(fileId)
  }
}
