package com.mm.task05.domains

import com.mm.task05.enums.AddressEnum

class Address(val borrowerId: Long, val address: Map<AddressEnum, String>) {

}
