package com.github.nkolytschew.mongotrek_migration.dao.jpa.repository

import com.github.nkolytschew.mongotrek_migration.dao.jpa.document.UserDocument
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * @author NKO
 * @version %I%, %G%
 * @since 1.X-SNAPSHOT
 */
@RepositoryRestResource(path = "users")
interface UserRepository : MongoRepository<UserDocument, String>