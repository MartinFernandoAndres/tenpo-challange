# Tenpo challange - Andres Martin

## How to run


   - Clone repository
   
   - Install docker, maven and java 11
  
   - Install Maven dependencies and run the project on docker containers with

```
   mvn clean install && docker-compose up
```

## Technologies

   - Lombok: Logs, getters, settersn
   
   - Tests with JUnit y Mockito, naming pattern Given-When-Then
   
   - Cache for Users with google common
   
   - Swagger available in http://localhost:8080/swagger-ui.html#/ and attached postman collection
   
   - Authorization through JWT via the Authorization header: "Token: ${token}" that provides when logging in the previously created user
   
   - Spring security, JPA
   
   - Exception handling

##  Requirement

Los requerimientos son los siguientes:
1. Debes desarrollar una API REST en Spring Boot utilizando java 11 con las siguientes
   funcionalidades:
   a. Sign up usuarios.
   b. Login usuarios.
   c. Sumar dos números. Este endpoint debe retornar el resultado de la
   suma y puede ser consumido solo por usuarios logueados.
   d. Historial de todos los llamados a todos los endpoint junto con la respuesta en caso de haber sido exitoso. Responder en Json, con data paginada.
   e. Logout usuarios.
   f. El historial y la información de los usuarios se debe almacenar en
   una database PostgreSQL.
   g. Incluir errores http. Mensajes y descripciones para la serie 4XX.

2. Esta API debe ser desplegada en un docker container. Este docker
   puede estar en un dockerhub público. La base de datos también debe
   correr en un contenedor docker. Recomendación usar docker compose.

3. Debes agregar un Postman Collection o Swagger para que probemos tu API.

4. Tu código debe estar disponible en un repositorio público, junto
   con las instrucciones de cómo desplegar el servicio y cómo utilizarlo.

Feedback 21/6/22

1. El SignUp de usuarios falla con un 500 internal server error que no es manejado cuando se trata de hacer un registro de usuario con un mismo mail
2. El endpoint del historial de llamadas devuelve un 500 internal server error cuando se le envía un  pageSize negativo, lo mismo pasa con el pageNumber
3. A nivel código vimos que estas realizando muchas acciones en los controller, detallo las mismas:
   a. En el UserController estas realizando la autenticación del usuario y después realizas la generación del access token. Esta acción ya podría ser realizada por el servicio en el primer método y que el controller solo reciba el AccessTokenDTO
   b. También en el UserController se está realizando la creación de objetos para devolver una respuesta como es en el caso del logout, esto se podría realizar directamente en el servicio.
   c. Se están elevando excepciones en la capa del controller (UserController), esto debería de realizarlo el servicio.
5. No se están utilizando interfaces para el MathService ni para el HistoryService