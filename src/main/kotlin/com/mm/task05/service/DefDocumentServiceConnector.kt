package com.mm.task05.service

import com.mm.crm.documents.model.DocFile
import com.mm.crm.documents.model.DocInfo
import com.mm.task05.enums.DocEnum
import org.bson.types.ObjectId
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class DefDocumentServiceConnector(private  val documentStorage: WebClient): DocumentServiceConnector {

  override fun uploadDocument(file: FilePart, ownerId: Long, ownerIdType: String, docType: String): Mono<DocInfo> {
    return documentStorage
      .post()
      .uri("/upload-document/{ownerId}/{ownerIdType}/{docType}", ownerId, ownerIdType, docType)
      .contentType(MediaType.MULTIPART_FORM_DATA)
      .body(BodyInserters.fromMultipartData("file",file))
      .retrieve()
      .bodyToMono(DocInfo::class.java)
  }

  override fun documentInfo(ownerId: Long, ownerIdType: String, docType: DocEnum): Flux<DocInfo> {
   return documentStorage
     .get()
     .uri("/get-documents-info/{ownerId}/{ownerIdType}/{docType}", ownerId, ownerIdType, docType)
     .retrieve()
     .bodyToFlux(DocInfo::class.java)
  }

  override fun downloadDocument(fileId: ObjectId): Mono<ByteArray> {
    return documentStorage
      .get()
      .uri("/download-document/{fileId}", fileId)
      .retrieve()
      .bodyToMono(ByteArray::class.java)
  }

  override fun deleteDocument(fileId: ObjectId): Mono<Boolean> {
    return documentStorage
      .get()
      .uri("/delete-document/{fileId}", fileId)
      .retrieve()
      .bodyToMono(Boolean::class.java)
  }
}
