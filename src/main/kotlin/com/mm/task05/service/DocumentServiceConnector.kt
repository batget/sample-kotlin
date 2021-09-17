package com.mm.task05.service

import com.mm.crm.documents.model.DocInfo
import com.mm.task05.enums.DocEnum
import org.bson.types.ObjectId
import org.springframework.http.codec.multipart.FilePart
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface DocumentServiceConnector {

  fun uploadDocument(file: FilePart, ownerId: Long, ownerIdType: String, docType: String): Mono<DocInfo>

  fun documentInfo(ownerId: Long, ownerIdType: String, docType: DocEnum): Flux<DocInfo>

  fun downloadDocument(fileId: ObjectId): Mono<ByteArray>

  fun deleteDocument(fileId: ObjectId): Mono<Boolean>
}
