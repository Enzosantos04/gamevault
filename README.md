#  GameVault (Backend)

**GameVault** é um projeto backend desenvolvido com **Spring Boot**, projetado para gerenciar um catálogo de jogos com funcionalidades como cadastro de jogos, autenticação de usuários e compras.  
Ele utiliza **PostgreSQL**, **Docker**, **Spring Security (com roles)**, **Flyway** e **JWT** para garantir segurança, escalabilidade e facilidade de implantação.

---

##  Tecnologias Principais

- **Java / Spring Boot** – Framework para desenvolvimento ágil de aplicações web robustas  
- **PostgreSQL** – Banco de dados relacional  
- **Docker & docker-compose** – Facilita o empacotamento e execução em containers  
- **Spring Security com Roles** – Controle de acesso baseado em papéis (admin, user, etc.)  
- **JWT (JSON Web Tokens)** – Autenticação stateless e segura  
- **Flyway Migrations** – Gerenciamento de versões de banco de dados

---

##  Estrutura do Repositório

gamevault/
├── src/
│ ├── main/
│ │ ├── java/… (código-fonte)
│ │ └── resources/…
│ └── test/…
├── docker-compose.yaml
├── pom.xml
└── mvnw, mvnw.cmd, .mvn/…


- **`src/`**: implementação dos controllers, serviços, repositórios, modelos, configurações de segurança e migrações.
- **`docker-compose.yaml`**: facilita o setup com backend e banco PostgreSQL prontos para uso.
- **`pom.xml`**: dependências do Spring Boot e plugins.
- **Wrapper Maven (`mvnw`)**: execução do projeto sem exigir instalação prévia do Maven.

---

##  Como Executar

### Pré-requisitos
- Java 17+ (ou a versão definida no `pom.xml`)  
- Docker e docker-compose instalados

### Passos

```bash
# Clone o repositório
git clone https://github.com/Enzosantos04/gamevault.git
cd gamevault

# Inicie o backend + banco de dados via Docker Compose
docker-compose up --build

# Alternativamente, execute com Maven (com banco configurado manualmente)
./mvnw spring-boot:run

