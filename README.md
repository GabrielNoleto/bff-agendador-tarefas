# 🚀 BFF - Orquestrador de Tarefas e Notificações

Este projeto é um **BFF (Backend For Frontend)** desenvolvido em Java. Ele atua como o ponto central de inteligência do ecossistema, orquestrando a comunicação entre o Frontend e os microserviços de backend, além de gerenciar tarefas automatizadas via Cron.

---

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando tecnologias modernas para sistemas distribuídos:

* **Java 17+** & **Spring Boot 3**
* **Spring Cloud OpenFeign**: Cliente HTTP declarativo para comunicação entre microsserviços.
* **Spring Mail** & **Thymeleaf**: Para construção e disparo de e-mails HTML.
* **Project Lombok**: Produtividade e redução de código boilerplate.
* **Docker & Docker Compose**: Containerização e orquestração de infraestrutura.
* **Gradle**: Gerenciador de dependências e automação de build.
* **Swagger**: Para documentação.

---

## 🏗️ Arquitetura e Estrutura do Projeto

A estrutura de pastas reflete a separação de responsabilidades:

* **`business`**: Regras de negócio, Services e DTOs (`in`/`out`).
* **`controller`**: Endpoints da API e tratamento global de erros.
* **`infrastructure`**: 
    * **`client`**: Onde residem os **FeignClients** e as configurações de integração.
    * **`exceptions`**: Exceções de domínio e infraestrutura.
* **`security`**: Configurações de segurança, filtros e política de CORS.

---

## 🔌 Integração com Microsserviços (OpenFeign)

A comunicação com os serviços de backend é feita através do **OpenFeign**, permitindo uma integração limpa e tipada. O BFF consome:

1. **Email Service**: Disparo de notificações e comunicações.
2. **Tarefas Service**: Gestão do ciclo de vida das tarefas.
3. **Usuario Service**: Dados cadastrais e perfis.

### 🛡️ Tratamento de Erros no Feign
Utilizamos uma configuração customizada de `FeignError` para interceptar falhas nas chamadas externas. Isso permite que, se o microserviço de e-mail retornar um erro, o BFF capture a mensagem e a processe antes de responder ao Frontend.

---

## 🛡️ Tratamento Global de Erros (GlobalExceptionHandler)

O projeto utiliza `@RestControllerAdvice` para centralizar o tratamento de exceções. Isso garante que o Frontend receba sempre um JSON padronizado, independentemente de onde o erro ocorreu.  
exemplo:

| Exceção | Descrição | Status HTTP |
| :--- | :--- | :--- |
| `InfrastructureException` | Falhas de comunicação (ex: erro no Feign). | 500 |
| `ResourceNotFoundException` | Recurso não encontrado. | 404 |
| `UnauthorizedException` | Falhas de autenticação. | 401 |

---

## 🕒 Automação com Cron Job

O sistema possui um motor de notificações agendado via **`CronService`**:

* **Expressão**: `0 0/5 * * * ?` (Executa a cada 5 minutos).
* **Fluxo**: O BFF varre as tarefas e aciona o **Email Service** via Feign para disparar notificações automáticas.

---

## 🐳 Containerização (Docker)

O projeto está pronto para rodar em containers.
```bash
docker estado: Run

docker-compose up --build

http://localhost:8084/swagger-ui/index.html#/
