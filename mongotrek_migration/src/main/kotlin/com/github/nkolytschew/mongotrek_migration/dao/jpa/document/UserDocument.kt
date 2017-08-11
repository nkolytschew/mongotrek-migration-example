package com.github.nkolytschew.mongotrek_migration.dao.jpa.document

import com.github.nkolytschew.mongobee_migration.dao.jpa.document.embedded.Address
import com.github.nkolytschew.mongobee_migration.dao.jpa.document.embedded.Email
import org.springframework.data.annotation.*
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.*

/**
 * main document for migration example.
 */
@Document(collection = "user")
class UserDocument(@Id val id: String = UUID.randomUUID().toString(),

                   @Field @Indexed
                   /**
                    * @since V6
                    * easiest way to change type in mongoDb without changing/modifying the value, is to simply rename the field.
                    *   <pre>$rename: {oldName: newName}</pre>
                    * please keep in mind, that the newName must differ from the old name.
                    * one way is to rename also this field.
                    * the other way is to create 2 updates, first: rename filed, e.g. emailNameOld; second: rename field again, e.g. email.email
                    */
                   // val String email,
                   val email: Email,

                   @Field @Indexed val username: String,
                   @Field val password: String,
                   @Field
                   /**
                    * @since V7
                    *
                    * to join two fields, we have to use and aggregation function, which concat's the fields.
                    * After the concat, we had to update each document withe the new value and delete/$unset the existing field.
                    * unfortunately mongoDb currently offers no support for referencing a value of a field in an update operation.
                    * we have to update each document manually; or use MongoBee
                    */
                   // val surname:String,
                   // @NonNull
                   // @Field
                   val name: String,

                   /**
                    * adding annotation has no effect on mongodb
                    * @since V8
                    */
                   @CreatedDate
                   /**
                    * @since V2
                    */
                   @Field var creationDate: Date = Date(),
                   /**
                    * adding annotation has no effect on mongodb
                    * @since V8
                    */
                   @CreatedDate

                   /**
                    * @since V3
                    */
                   @Field val modificationDate: Date,
                   /**
                    * @since V3
                    */
                   @Version @Field val version: Int,

                   /**
                    * @since V4
                    */
                   @Field var userAddress: MutableList<Address>,

                   /**
                    * @since V8
                    */
                   @CreatedBy @Field val createdBy: String,
                   /**
                    * @since V8
                    */
                   @LastModifiedBy @Field val modifiedBy: String
)