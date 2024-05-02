# **Read Me First**

o PROJETO a seguir tem como principal objetivo:

- Uma aplicação de uma APIRest com controle de usuarios e manipulação de lista, com foco em praticar conhecimentos adiquiridos durantes estudos.
- As principais funções dentro do sistema são as sequintes: create user, login user and an individual list for each user with crud functionality

---

# **Getting Started**

### Tools

- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.11/reference/htmlsingle/index.html#using.devtools)
- [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.11/reference/htmlsingle/index.html#web)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.11/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
- [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.11/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)
- MySQL

## **Pré-requisito**

- Spring Boot 3.1.11
- Java 17

```java
# Clone este repositório
$ git clone 

# Acesse a pasta do projeto no terminal/cmd
$ cd 

# Instale as dependências
$ mvn clean package

# Execute o comando para rodar a migrations  
npm run migration:run

# Execute a aplicação 
$ mvn spring-boot:run

# O servidor inciará na porta:8081 - acesse http://localhost:8081/
```

## Config File Application.properties

```java
spring.datasource.username= Nome do seu usuario
spring.datasource.password= Senha do seu usuario

//Se tiver usando MySQL deve ser feito as seguintes configurações
spring.datasource.url=jdbc:mysql://localhost:3306/nomeDoSeuBancoDeDados

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect

//Se tiver usando PostgreSQL deve ser feito as seguintes configurações
spring.datasource.url=jdbc:postgresql://localhost:5432/nomeDoSeuBancoDeDados

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
```

# **Guides - Endpoints**

The following guides illustrate how to use some features concretely:

---

## User

**Route function : Create User**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)users
- Http: POST
- Headers: default
- Parameters: default

### Request:

```java
{
	"name":"Joao",
	"username":"joaozinho",
	"email":"joaozinho@gmail.com",
	"password":"123"
}
```

### Response:

```java
{
	"id": "5a6ab725-1293-4f53-8070-701682deed8a",
	"name": "Joao",
	"username": "joaozinho",
	"password": "123",
	"email": "joaozinho@gmail.com",
	"createdAt": "2024-05-01T10:55:16.6729464"
}
```

---

**Route function : Login**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)users/login
- Http: POST
- Headers: default
- Parameters: default

### Request:

```java
{
	"username":"JoaoUpdateAllData",
	"password":"123456"
}
```

### Response:

```java
{
	"id": "23b377ad-0f67-4eb5-b34b-801a41aa3de4",
	"name": "Joao",
	"username": "joaozinho",
	"email": "joaozinho@gmail.com",
	"createdAt": "2024-05-02T08:43:41.486564",
	"tasks": []
}
```

---

**Route function : Update**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)users
- Http: PUT
- Headers: ID
- Parameters: default

### Request:

```java
{
	"name":"JoaoTesteRotaUpdateAllData",
	"username":"JoaoUpdateAllData",
	"email":"joaoUpdateAllData@gmail.com"
}
```

### Response:

```java
{
	"id": "5a6ab725-1293-4f53-8070-701682deed8a",
	"name": "JoaoTesteRotaUpdateAllData",
	"username": "JoaoUpdateAllData",
	"password": "123456",
	"email": "joaoUpdateAllData@gmail.com",
	"createdAt": "2024-05-01T10:55:16.672946",
	"updateAt": "2024-05-01T11:09:02.1732391"
}
```

---

**Route function : Password Update**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)users
- Http: PATCH
- Headers: ID
- Parameters: default

### Request:

```java
{
	"password":"123456"
}
```

### Response:

```java
204 No Content
```

---

**Route function :  User Delete**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)users
- Http: Delete
- Headers: ID
- Parameters: default

### Request:

```java

```

### Response:

```java
204 No Content
```

---

## Task

**Route function : Task Create**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)
- Http: POST
- Headers: default
- Parameters: default

### Request:

```java
{
  "title":"Teste 4 EEEEEE",
	"description":"Lorem lorem lorem lorem",
	"userid":"4ebac25f-4a04-4e4b-9e51-d12d47fbe989"
}
```

### Response:

```java
{
	"id": "2849510f-4bbb-4d5b-8f8e-515b4c1847ad",
	"title": "Teste 4 EEEEEE",
	"description": "Lorem lorem lorem lorem",
	"taskStatus": "pending",
	"createdAt": "2024-04-30T20:39:33.1564987",
	"userid": "4ebac25f-4a04-4e4b-9e51-d12d47fbe989"
}
```

---

**Route function : List Task**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)tasks/listTasks
- Http: GET
- Headers: ID
- Parameters: default

### Request:

```java

```

### Response:

```java
[
	{
		"id": "3b24ea59-bd7d-4d31-b3cb-5bb68d11a102",
		"title": "Teste 1 AAAAAAA",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T11:33:59.613501",
		"updateAt": null
	},
	{
		"id": "5c464f52-eaad-45a3-82ae-d287f763924a",
		"title": "Teste 3 EEEEEEE",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T11:33:45.913812",
		"updateAt": null
	},
	{
		"id": "be531191-1d2c-4388-9db7-be06bfd4676b",
		"title": "Teste 2 BBBBBBBBB",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T11:33:53.99484",
		"updateAt": null
	}
]
```

---

**Route function : List Task by status**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)tasks/filter/:STATUS
- Http: POST
- Headers: ID
- Parameters: :STATUS

Status disponivel no sistema : completed / pending

### Request:

```java

```

### Response:

```java
[
	{
		"id": "0067dbce-eab0-406c-856b-25dade66e0d6",
		"title": "Teste 1 AAAAAAA",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T20:34:36.602814",
		"updateAt": null
	},
	{
		"id": "157fa2f3-0da6-4d40-8d76-2032fd825fb8",
		"title": "Teste 2 BBBBB",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T20:34:48.494089",
		"updateAt": null
	},
	{
		"id": "2849510f-4bbb-4d5b-8f8e-515b4c1847ad",
		"title": "Teste 4 EEEEEE",
		"description": "Lorem lorem lorem lorem",
		"taskStatus": "pending",
		"createdAt": "2024-04-30T20:39:33.156499",
		"updateAt": null
	}
]
```

---

**Route function :  Update**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)task
- Http: PUT
- Headers: default
- Parameters: default

### Request:

```java
{
  "id":"3b24ea59-bd7d-4d31-b3cb-5bb68d11a102",
	"title":"ota de atualizar Task",
	"description":"Droga"
}
```

### Response:

```java
{
	"id": "7bc9a477-1b31-4abc-9352-7edace5cb284",
	"title": "ota de atualizar Task",
	"description": "Droga",
	"taskStatus": "pending",
	"createdAt": "2024-05-02T08:57:13.807188",
	"userid": "23b377ad-0f67-4eb5-b34b-801a41aa3de4"
}
```

---

**Route function : Update Status**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)
- Http: PATCH
- Headers: ID
- Parameters: default

### Request:

```java

```

### Response:

```java
{
	"id": "e67d5959-34da-4cbe-a169-56611f4f4211",
	"title": "Teste 3 EEEEEE",
	"description": "Lorem lorem lorem lorem",
	"taskStatus": "completed",
	"createdAt": "2024-04-30T20:34:58.376134",
	"userid": "4ebac25f-4a04-4e4b-9e51-d12d47fbe989"
}
```

---

**Route function : Task Delete**

- URL: [http://localhost:8081/](http://localhost:8081/tasks)task/:ID
- Http: Delete
- Headers: default
- Parameters: :ID

### Request:

```java

```

### Response:

```java
204 No Content'
```

---