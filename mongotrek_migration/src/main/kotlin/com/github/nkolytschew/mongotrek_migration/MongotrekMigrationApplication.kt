package com.github.nkolytschew.mongotrek_migration

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class MongotrekMigrationApplication

fun main(args: Array<String>) {
    SpringApplication.run(MongotrekMigrationApplication::class.java, *args)
}
