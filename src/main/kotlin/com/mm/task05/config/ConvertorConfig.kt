package com.mm.task05.config


import com.mm.task05.convertor.FileConvertor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ConvertorConfig {

  @Bean
  open fun fileConvertor(): FileConvertor {
    return FileConvertor()
  }

}
