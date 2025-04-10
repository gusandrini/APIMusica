# API de Música 🎶

**Desenvolvido pelos alunos:**

- **Gustavo de Oliveira Turci Sandrini** (RM557505)  
- **Heitor Romero da Rocha** (RM558301)  
- **Leonardo Bianchi** (RM558576)  

---

Bem-vindo à **API de Música**, um projeto desenvolvido para gerenciar álbuns, músicas e artistas, permitindo a interação com dados de forma prática e eficiente. Esta API foi construída utilizando o **Spring Boot** e **Swagger** para documentação automática.

## 📖 Descrição

A **API de Música** permite que você crie, leia, atualize e delete álbuns, músicas e artistas em um sistema de gerenciamento musical. A API fornece endpoints para:

- Gerenciar **Álbuns**: Criar, listar, atualizar e deletar álbuns de artistas.
- Gerenciar **Músicas**: Associar músicas a álbuns e artistas, e realizar operações CRUD.
- Gerenciar **Artistas**: Criar e atualizar informações sobre artistas.

Além disso, a documentação da API é gerada automaticamente com o **Swagger** (OpenAPI 3), permitindo fácil navegação e testes interativos dos endpoints.

---

## 🛠 Tecnologias Utilizadas

A seguir, estão as tecnologias e ferramentas que foram utilizadas neste projeto:

- **Spring Boot 3.x** - Framework Java para construir aplicações web.
- **Java 17** - Versão do JDK utilizada.
- **Spring Data JPA** - Para persistência de dados em banco de dados.
- **Spring Web** - Para construir APIs RESTful.
- **Spring HATEOAS** - Para criar links de navegação (HATEOAS) nas respostas da API.
- **Swagger (OpenAPI 3)** - Para gerar a documentação interativa da API.
- **Gradle** - Ferramenta de automação de builds.

---

## 🚀 Funcionalidades

- **Gerenciamento de Artistas**:
  - Criar, atualizar, listar e excluir artistas.
  - Exemplo de Artista: Nome, Estilo Musical, Email.
  
- **Gerenciamento de Álbuns**:
  - Criar, atualizar, listar e excluir álbuns.
  - Exemplo de Álbum: Nome, Artista (ID).
  
- **Gerenciamento de Músicas**:
  - Criar, atualizar, listar e excluir músicas.
  - Exemplo de Música: Título, Duração, Artista (ID), Álbum (ID).

- **Documentação da API**: 
  - A API está documentada com o **Swagger UI**, permitindo que você visualize e interaja com todos os endpoints da API de forma interativa.

---

## 🧑‍💻 Como Rodar o Projeto

### Pré-requisitos

- **Java 17** ou superior.
- **Gradle** (se necessário, o wrapper do Gradle será utilizado).
- **IDE** (como IntelliJ IDEA ou Eclipse) ou terminal para executar os comandos.

### Passos para rodar a API localmente

1. **Clone este repositório**:

```bash
git clone https://github.com/seu-usuario/apimusica.git
```

2. **Entre no diretório do projeto**:

```bash
cd apimusica
```

3. **Baixe as dependências** (usando Gradle):

```bash
./gradlew build --refresh-dependencies
```

4. **Execute a aplicação**:

```bash
./gradlew bootRun
```

5. **Acesse a API**: Abra o navegador e vá até [http://localhost:8080](http://localhost:8080).

6. **Swagger UI**: Para visualizar a documentação interativa da API, acesse [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

---

## 🔧 Endpoints

A API contém os seguintes endpoints principais:

### Artistas

- `POST /artistas` - Criar um novo artista.
- `GET /artistas` - Listar todos os artistas.
- `GET /artistas/{id}` - Buscar um artista por ID.
- `PUT /artistas/{id}` - Atualizar informações de um artista.
- `DELETE /artistas/{id}` - Deletar um artista.

### Álbuns

- `POST /albums` - Criar um novo álbum.
- `GET /albums` - Listar todos os álbuns.
- `GET /albums/{id}` - Buscar um álbum por ID.
- `PUT /albums/{id}` - Atualizar informações de um álbum.
- `DELETE /albums/{id}` - Deletar um álbum.

### Músicas

- `POST /musicas` - Criar uma nova música.
- `GET /musicas` - Listar todas as músicas.
- `GET /musicas/{id}` - Buscar uma música por ID.
- `PUT /musicas/{id}` - Atualizar informações de uma música.
- `DELETE /musicas/{id}` - Deletar uma música.

---

## 💡 Exemplos de Uso

### Exemplo de Requisição para Criar um Artista

**POST** `http://localhost:8080/artistas`

```json
{
  "nome": "Artista 1",
  "estilo": "Rock",
  "email": "artista1@exemplo.com"
}
```

**Resposta**:

```json
{
  "id": 1,
  "nome": "Artista 1",
  "estilo": "Rock",
  "email": "artista1@exemplo.com"
}
```
