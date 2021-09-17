package com.mm.task05.domains

import com.mm.task05.enums.ContactEnum

class Contacts(val borrowerId: Long, val contact: Map<ContactEnum, String>) {
}
