package com.mm.task05.service

import reactor.core.publisher.Flux

interface ConnectorForBorrower {

  fun borrowerId(days:Int):Flux<Long>
}
