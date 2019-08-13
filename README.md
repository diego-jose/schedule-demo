## Getting Started

### Run Locally
```sh
$ mvn spring-boot:run
```
Application will be available at http://localhost:8090/api .

#Swagger Access
Application will be available athttp://localhost:8090/swagger-ui.html/

### Run Tests 
Run all tests
 
```sh
$ mvn clean test
```

###Cache e Criptografia
Não desenvolvi nenhuma estrutura de cache e criptografia por falta de tempo e por entender tambem que existem frameworks que auxiliam nestas questões. 
Também não achei valido implementar um endpoint que envie chaves publicas de usuario por questão de segurança
 acretido que o prorpio spring oferece recursos superiores de autenticação como o spring-security e JWT token.

### Going further
Segui o desenvolvimento me baseando em Clean Arch, a arquitetura ainda não está totalmente fechada, ainda pode evoluir e contribuir para uma cobertura de testes de 100%

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring-Boot](https://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".
* [H2 Database](https://www.h2database.com) - In-memory database.
* [Clean Architeture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) - The Clean Architecture.