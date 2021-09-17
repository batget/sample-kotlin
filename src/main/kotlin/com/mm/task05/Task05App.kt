package com.mm.task05

import com.mm.base.MMAppBuilder
import com.mm.base.config.DefaultSpringAppConfig
import com.mm.base.config.ObjectMapperWebFluxConfigurer
import com.mm.base.config.WebFluxConfig
import com.mm.task05.config.BorrowerServiceConvertorConfig
import com.mm.task05.config.ControllerConfig
import com.mm.task05.config.ConvertorConfig
import com.mm.task05.config.DocumentConfig
import com.mm.task05.config.JacksonConfig
import com.mm.task05.config.JooqConfig
import com.mm.task05.config.MongoConfig
import com.mm.task05.config.RepositoryConfig
import com.mm.task05.config.ServiceConfig
import com.mm.task05.config.WebClientConfig

object Task05App {
  @JvmStatic
  fun main(args: Array<String>) {
    MMAppBuilder()
      .sources(
        DefaultSpringAppConfig::class.java,
        WebFluxConfig::class.java,
        ControllerConfig::class.java,
        MongoConfig::class.java,
        RepositoryConfig::class.java,
        WebClientConfig::class.java,
        DocumentConfig::class.java,
        JooqConfig::class.java,
        ObjectMapperWebFluxConfigurer::class.java,
        JacksonConfig::class.java,
        BorrowerServiceConvertorConfig::class.java,
        ConvertorConfig::class.java,
        ServiceConfig::class.java)
      .run(8889, "lab", "task-05")
  }
}
