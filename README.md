# Projeto Biblioteca (Backend)

#### 1. Ambiente

A aplicação backend utiliza a porta 8080 do localhost.

#### 2. Stack, ferramentas e bibliotecas utilizadas no backend (Projeto Maven)

Para desenvolvimento do projeto backend foi utilizado a IDE Eclipse.
Foi desenvolvido utilizando Spring Boot 2.7.3 RELEASE, Spring Data e DevTools.
O projeto utiliza o Banco de dados MySQL.

#### 3. Build do backend
Importar como projeto Maven na IDE, rodar a aplicação após carregar as dependências.
Pode-se tentar rodar a aplicação também utilizando o comando mvn spring-boot:run na pasta da aplicação.

#### 4. Alguns dos serviços disponíveis no backend no endereço ```http://localhost:8080```

##### - Assunto
- **[GET]** */api/assunto* : lista todos os assuntos
- **[GET]** */api/assunto/{id}* : lista um assunto pelo *id* informado
- **[POST]** */api/assunto* : cadastra um novo assunto
- **[PUT]** */api/assunto/{id}* : atualiza os dados do assunto informado pelo *id*
- **[DELETE]** */api/assunto/{id}* : elimina o assunto pelo *id* informado

##### - Autor
- **[GET]** */api/autor* : lista todos os autores
- **[GET]** */api/autor/{id}* : lista um autor pelo *id* informado
- **[POST]** */api/autor* : cadastra um novo autor
- **[PUT]** */api/autor/{id}* : atualiza os dados do autor informado pelo *id*
- **[DELETE]** */api/autor/{id}* : elimina o autor pelo *id* informado

##### - Editora
- **[GET]** */api/editora* : lista todas as editoras
- **[GET]** */api/editora/{id}* : lista uma editora pelo *id* informado
- **[POST]** */api/editora* : cadastra uma nova editora
- **[PUT]** */api/editora/{id}* : atualiza os dados da editora informada pelo *id*
- **[DELETE]** */api/editora/{id}* : elimina a editora pelo *id* informado

#### - Idioma
- **[GET]** */api/idioma* : lista todos os idiomas
- **[GET]** */api/idioma/{id}* : lista um idioma pelo *id* informado
- **[POST]** */api/idioma* : cadastra um novo idioma
- **[PUT]** */api/idioma/{id}* : atualiza os dados do idioma informada pelo *id*
- **[DELETE]** */api/idioma/{id}* : elimina o idioma pelo *id* informado

#### - Idioma
- **[GET]** */api/idioma* : lista todos os idiomas
- **[GET]** */api/idioma/{id}* : lista um idioma pelo *id* informado
- **[POST]** */api/idioma* : cadastra um novo idioma
- **[PUT]** */api/idioma/{id}* : atualiza os dados do idioma informada pelo *id*
- **[DELETE]** */api/idioma/{id}* : elimina o idioma pelo *id* informado

#### - Livro
- **[GET]** */api/livro* : lista todos os livros
- **[GET]** */api/livro/{id}* : lista um livro pelo *id* informado
- **[POST]** */api/livro* : cadastra um novo livro
- **[PUT]** */api/livro/{id}* : atualiza os dados do livro informado pelo *id*
- **[DELETE]** */api/livro/{id}* : elimina o livro pelo *id* informado

#### - Usuario
- **[GET]** */api/usuario* : lista todos os usuarios
- **[GET]** */api/usuario/{id}* : lista um usuario pelo *id* informado
- **[POST]** */api/usuario* : cadastra um novo usuario
- **[PUT]** */api/usuario/{id}* : atualiza os dados do usuario informado pelo *id*
- **[DELETE]** */api/usuario/{id}* : elimina o usuario pelo *id* informado

Em caso de dúvidas de entendimento ou para rodar a aplicação, entrar em contato através do email maicon.santos89@hotmail.com
