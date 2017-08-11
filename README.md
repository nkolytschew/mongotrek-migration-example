# mongotrek-migration-example
See http://blog.novatec-gmbh.de/author/nko/


## Problems
* cannot create documents with current date; need to "update" or "upsert" documents and set date to function $currentDate
* need to escape chars like ß, or ä, ü, ö