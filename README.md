🌱 CRUD de Usuários - Spring Boot + JPA

API REST simples para cadastro de usuários utilizando Spring Boot, Spring Data JPA e Lombok.

📌 Funcionalidades

Criar usuário (POST /usuario)

Buscar usuário por e-mail (GET /usuario?email=...)

Atualizar usuário por ID (PUT /usuario?id=...)

Deletar usuário por e-mail (DELETE /usuario?email=...)

🛠 Tecnologias

Java 17+

Spring Boot

Spring Data JPA

Lombok

Banco de dados relacional (ex: MySQL, PostgreSQL, H2)

🚀 Como executar

Clone o repositório:

git clone https://github.com/seu-usuario/crud-spring.git
cd crud-spring


Configure o application.properties com as credenciais do seu banco:

spring.datasource.url=jdbc:mysql://localhost:3306/crud_db
spring.datasource.username=root
spring.datasource.password=1234
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


Execute a aplicação:

mvn spring-boot:run


Teste a API com Postman, Insomnia ou cURL.

📂 Estrutura do projeto
src/
 └── main/java/com/crudspring/cadastro_usuario
      ├── controller/UsuarioController.java  # Endpoints REST
      ├── business/UsuarioService.java       # Regras de negócio
      ├── insfrastructure/entitys/Usuario.java # Entidade JPA
      └── repository/UsuarioRepository.java  # Interface JPA

✨ Futuras melhorias

Autenticação com Spring Security

Validação com Bean Validation (@Valid)

Documentação com Swagger/OpenAPI

Testes automatizados
