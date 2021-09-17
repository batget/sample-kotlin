package com.mm.task05.domains

import java.util.*

class BorrowerDocumentDomain (
  val id: String,
  val ownerId: Long?,
  val ownerIdType: String?,
  val docType: String?,
  val fileName: String,
  val uploadDate: Date?){
}
