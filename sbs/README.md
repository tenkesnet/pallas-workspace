# SpringBoot System

## Konfiguráció

```
spring.jpa.hibernate.ddl-auto

create – Hibernate first drops existing tables and then creates new tables.
update – The object model created based on the mappings (annotations or XML) is compared with the existing schema, and then Hibernate updates the schema according to the diff. It never deletes the existing tables or columns even if they are no longer required by the application.
create-drop – similar to create, with the addition that Hibernate will drop the database after all operations are completed; typically used for unit testing
validate – Hibernate only validates whether the tables and columns exist; otherwise, it throws an exception.
none – This value effectively turns off the DDL generation.
```