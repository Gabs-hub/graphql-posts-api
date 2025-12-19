# GraphQL Java Application

### API GraphQL com Spring Boot 4 e MongoDB

Este repositório contém uma aplicação **GraphQL em Java**, desenvolvida com **Spring Boot 4**, criada com foco em aprender realmente como funciona o fluxo de uma api desse tipo.

⚠️ **Este é o meu primeiro projeto com GraphQL** e foi construído de forma **intencionalmente didática**. Algumas configurações consideradas inseguras em produção foram mantidas **propositalmente para estudo**.

## Visão Geral

A aplicação atua como um sistema simples de **posts e comentários**, implementado com GraphQL ao invés de REST, para entender o funcionamento de:

- Schema GraphQL
- Queries e Mutations
- Resolvers
- Integração com MongoDB

A estrutura foi pensada para se aproximar de um backend real.

## Schema GraphQL e Capacidades da API 

## Tipos Disponíveis:


### Post
Representa um post do sistema.

Campos:
- `id`: identificador único
- `title`: título do post
- `content`: conteúdo do post
- `comments`: lista de comentários associados ao post

___

### Comment
Representa um comentário vinculado a um post.

Campos:
- `id`: identificador único
- `postId`: referência ao post
- `author`: autor do comentário
- `text`: conteúdo do comentário

___

### Queries

- `getPostById`  
  Retorna um post específico pelo ID.

- `getAllPosts`  
  Retorna **todos os posts** cadastrados.

- `getCommentById`  
  Retorna um comentário específico pelo ID.

- `getAllComments`  
  Retorna **todos os comentários** do sistema.

___

### Mutations

- `createPost`  
  Cria um novo post informando título e conteúdo.

- `updatePost`  
  Atualiza o título e/ou conteúdo de um post existente a partir do ID.

- `deletePost`  
  Remove um post do sistema (junto aos seus comentários) com base no ID do post.

- `createComment`  
  Cria um comentário associado a um post específico.

- `updateComment`  
  Atualiza o texto de um comentário existente a partir do ID.

- `deleteComment`  
  Remove um comentário do sistema com base no ID informado.

## Introspection como Vulnerabilidade

A API possui a **introspection habilitada propositalmente**, não apenas para aprendizado, mas também para **simular uma misconfiguration** comum em ambientes reais. A instrospection geralmente é habilitada por padrão, sendo necessário desabilitar manualmente.

### Isso representa uma vulnerabilidade porque:

- Permite mapear completamente o schema
- Expõe tipos, queries, mutations e relacionamentos
- Facilita enumeração de dados e endpoints lógicos
- Ajuda atacantes a entenderem a API sem qualquer autenticação

**OBS:** Em produção, a introspection **DEVE SER RESTRINGIDA OU DESABILITADA**. No caso desta aplicação, basta descomentar a linha `spring.graphql.schema.introspection.enabled=false` em `application.properties` que ela será desabilitada.


## O que pode ser testado

Este projeto permite explorar:

- Queries com campos aninhados
- Mutations de criação, edição e remoção
- Resolvers para relacionamento entre entidades
- Diferenças práticas entre GraphQL e REST
- Enumeração do schema via introspection
- Impacto de uma má configuração em APIs GraphQL


## Tecnologias

- **Java**
- **Spring Boot 4**
- **Spring GraphQL**
- **MongoDB**


## Estrutura da Aplicação (resumo)

```
/src
├─ controller/ (PostController, CommentController)
├─ exception/ (GraphQlExceptionResolver)
├─ model/ (Post, Comment)
├─ repository/ (PostRepository, CommentRepository)
├─ resolver/ (PostResolver)
├─ service/ (PostService, CommentService)
└─ resources/graphql/schema.graphqls

```

## Execução

1. Suba o MongoDB (`27017`) -> Pode ser pelo docker ou pelo próprio mongo instalado
2. Execute o GraphqlApplication.java
3. Acesse o /graphiql e explore as funcionalidades ou o schema via introspection.

## ⚠️ Aviso

Projeto **exclusivamente educacional**.

* Introspection habilitada **intencionalmente**
* Configuração insegura **proposital**
* Não utilizar em produção
