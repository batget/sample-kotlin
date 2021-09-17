package com.mm.task05.config

import com.mm.platform.mongo.config.MongoClientBuilder
import com.mm.platform.mongo.config.MongoSettings
import com.mm.task05.domains.Address
import com.mm.task05.domains.Contacts
import com.mongodb.reactivestreams.client.MongoCollection
import com.mongodb.reactivestreams.client.MongoDatabase
import org.cfg4j.provider.ConfigurationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class MongoConfig(private val configurationProvider: ConfigurationProvider,private  val jacksonConfig: JacksonConfig) {
  @Bean
  open fun mongoDatabase(): MongoDatabase {
    val mongoSettings = configurationProvider.bind("mongo.db", MongoSettings::class.java)
    return MongoClientBuilder.of(mongoSettings).withJackson(jacksonConfig.objectMapper()).build()
  }

  @Bean
  open fun contactsCollection(): MongoCollection<Contacts> =
    mongoDatabase().getCollection("contacts", Contacts::class.java)

  @Bean
  open fun addressCollection(): MongoCollection<Address> =
    mongoDatabase().getCollection("address", Address::class.java)
}
