### Spring boot, MongoDB, Snowflake Crud API
#### This project consider following topic 
- Spring Boot
- Mongo
- Snowflake
- Jwt token based authentication
- Custom and Multi data source
- MongoTemplate, JPA
- Swagger (group wise Presentation) 
- Design Pattern, Interface, Generics, Abstraction

### Operation

1. Change application.properties

2. Run
```
mvn install 
mvn spring-boot:run
```
3. Generate token : change dropdown to auth controller from swagger home. Use this token for mongo api and snowflake api in "Authorization"  header.

```
http://localhost:8282/mongo_snowflake/swagger-ui.html

email: admin@abc.com
password: 1234
```
4. test mongo : change dropdown to mongo controller from swagger home 

```
http://localhost:8282/mongo_snowflake/swagger-ui.html
```
4.  test snowflake : change dropdown to snowflake controller from swagger home.  

```
http://localhost:8282/mongo_snowflake/swagger-ui.html
```