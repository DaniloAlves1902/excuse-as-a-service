# Excuse as a Service (EaaS)

[Read in English](#english-version) | [Leia em Português](#versao-em-portugues)

---

<a id="english-version"></a>
## English Version

### About The Project
Why take the blame when an API can do it for you? Welcome to **Excuse as a Service (EaaS)**. 
This project is an over-engineered, cloud-native playground built to solve one of humanity's greatest problems: running out of creative excuses for missing deadlines, skipping meetings, or avoiding social interactions.

While the premise is highly suspicious, the architecture is quite serious. EaaS is an event-driven microservices ecosystem built with Java, Spring Boot, and RabbitMQ. It generates excuses on demand and asynchronously tracks your excuse history, because every good lie needs a reliable audit trail.

### Architecture and Flow
This system is composed of two main microservices that communicate asynchronously:

1. **Excuse Service**: The front-line API. When you request an excuse, this service provides it immediately. But behind the scenes, it publishes an "ExcuseUsedEvent" to a RabbitMQ message broker. It does not wait for the history to be saved; it just fires and forgets, ensuring maximum performance for your immediate excuse needs.
2. **History Service**: The silent auditor. It listens to the RabbitMQ queues. Whenever a new event arrives, it consumes the message and safely stores it in its own database. If the History Service goes down, RabbitMQ holds the messages safely until it comes back online, meaning no excuse goes undocumented.

### Technologies Used
- Java 17+
- Spring Boot (Web, Data JPA, AMQP)
- RabbitMQ (Message Broker)
- Docker & Docker Compose (Containerization)
- PostgreSQL / H2 (Databases)

### How to Run Locally

Since this is a modern application, we packaged all the complex infrastructure dependencies into a neat Docker Compose file. 

**Prerequisites:**
- Docker and Docker Compose installed on your machine.
- Java and Maven (if you want to run it outside Docker).

**Step-by-step:**
1. Clone this repository to your local machine.
2. Open your terminal in the project's root directory.
3. Run the following command to build and start the entire environment (Microservices + RabbitMQ + Databases):
   `docker compose up --build`
4. Wait for all containers to be healthy. The RabbitMQ broker takes a few seconds to boot up.
5. You are ready to start dodging responsibilities!

### API Endpoints
*(Assuming default ports, please check application.yml if different)*

- **GET /excuses/random**: Returns a perfectly crafted random excuse.
- **GET /history**: (History Service) Retrieves the audit trail of all excuses you have used so far.

---

<a id="versao-em-portugues"></a>
## Versão em Português

### Sobre o Projeto
Por que assumir a culpa quando uma API pode fazer isso por você? Bem-vindo ao **Excuse as a Service (EaaS)**.
Este projeto é um laboratório de arquitetura super-engenheirado, criado para resolver um dos maiores problemas da humanidade: a falta de desculpas criativas na hora de fugir de prazos, reuniões ou interações sociais.

Embora o objetivo seja uma brincadeira, a arquitetura é muito séria. O EaaS é um ecossistema de microsserviços orientados a eventos construído com Java, Spring Boot e RabbitMQ. Ele gera desculpas sob demanda e rastreia assincronamente seu histórico de desculpas, porque toda boa desculpa precisa de uma trilha de auditoria confiável.

### Arquitetura e Fluxo
Este sistema é composto por dois microsserviços principais que se comunicam de forma assíncrona:

1. **Excuse Service**: A API de linha de frente. Quando você solicita uma desculpa, este serviço a fornece imediatamente. Mas, nos bastidores, ele publica um evento "ExcuseUsedEvent" em um message broker (RabbitMQ). Ele não espera o histórico ser salvo; apenas envia a mensagem e segue a vida, garantindo desempenho máximo para sua necessidade imediata de uma desculpa.
2. **History Service**: O auditor silencioso. Ele escuta as filas do RabbitMQ. Sempre que um novo evento chega, ele consome a mensagem e a armazena com segurança em seu próprio banco de dados. Se o History Service cair, o RabbitMQ guarda as mensagens em segurança até que ele volte, garantindo que nenhuma desculpa passe despercebida.

### Tecnologias Utilizadas
- Java 17+
- Spring Boot (Web, Data JPA, AMQP)
- RabbitMQ (Message Broker)
- Docker & Docker Compose (Containerização)
- PostgreSQL / H2 (Bancos de Dados)

### Como Rodar Localmente

Como esta é uma aplicação moderna, empacotamos toda a infraestrutura complexa em um arquivo Docker Compose.

**Pré-requisitos:**
- Docker e Docker Compose instalados na sua máquina.
- Java e Maven (caso queira rodar fora do Docker).

**Passo a passo:**
1. Clone este repositório na sua máquina local.
2. Abra o terminal na raiz do projeto.
3. Execute o seguinte comando para compilar e iniciar todo o ambiente (Microsserviços + RabbitMQ + Bancos de Dados):
   `docker compose up --build`
4. Aguarde até que todos os containers estejam prontos. O RabbitMQ demora alguns segundos para iniciar.
5. Você está pronto para começar a fugir das suas responsabilidades!

### Endpoints da API
*(Assumindo as portas padrão, verifique os arquivos application.yml se necessário)*

- **GET /excuses/random**: Retorna uma desculpa aleatória perfeitamente elaborada.
- **GET /history**: (History Service) Retorna o histórico de todas as desculpas que você já usou.
