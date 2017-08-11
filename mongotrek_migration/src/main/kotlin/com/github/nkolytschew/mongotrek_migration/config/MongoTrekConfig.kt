package com.github.nkolytschew.mongotrek_migration.config

import net.ozwolf.mongo.migrations.MongoTrek
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * simple Mongo-Trek configuration.
 * set Database URI for MongoDB Source.
 * set Database Name for migration operation.
 * set Path to Migration-Script files.
 * set name of the collection, where all the executed changes will be stored as documents.
 */
@Configuration
class MongoTrekConfig(@Value("\${spring.data.mongodb.database}") val databaseName: String,
                      @Value("\${spring.data.mongodb.uri}") val databaseUri: String,
                      @Value("\${application.property.mongotrek.script.path}") val basePath: String,
                      @Value("\${application.property.mongotrek.changelog.collection.name}") val collectionName: String) {

  /**
   * return a simple MongoTrek Bean.
   * bean is not needed at all, since we are execution the migration in this function.
   */
  @Bean
  fun mongoTrek(): MongoTrek {
    val trek = MongoTrek(basePath, databaseUri + databaseName)
    trek.setSchemaVersionCollection(collectionName)

    // execute migration defined in migration-script file
    trek.migrate()

    return trek
  }
}