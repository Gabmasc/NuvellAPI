# 💋 Nuvell API

## 🔥 Sobre o Projeto. V01_0415

Desenvolvimento de uma API para cadastro de mulheres interessadas em prestar serviços de relacionamentos adultos (+18) por meio de uma plataforma online.

### 📖 Storytelling

Imagine "Adalgisa", uma mulher linda, confiante, que sempre chamou atenção por onde passa. Cansada de trocar 10 horas diárias por um salário mínimo, ela decide mudar de vida. Em vez das esquinas da cidade, onde todos a conhecem, ela busca anonimato, autonomia e segurança.

Ela encontra uma plataforma que oferece autonomia, segurança e discrição, permitindo que atue no mercado de relacionamentos adultos, de forma independente e protegida.

> ⚠️ **Disclaimer**: Este projeto é fictício e tem fins puramente educacionais e acadêmicos.  Caso haja evolução para uso comercial, será devidamente ajustado. Nenhum dado real é coletado ou processado. O conteúdo pode conter linguagem adulta. Use com responsabilidade.

---

## Diagrama de Classes (Domínio da API)
```mermaid
class User {
    -String fullname
    -String cpf
    -Integer age
    -String email
    -String contact
    -String state
    -String gender
  }

  class Artist {
    -String jobName
    -Integer age
    -String gender
    -String state
    -String description
    -Double pricePerHour
    -String state
    -String targetAudience

  }

  User "1" *-- "1" Artist : has

  ```

---

## 🧠 Funcionalidades/Detalhes

A API permite o cadastro de mulheres com os seguintes dados:
> ✅ Os dados que estão em ✅ serão salvos no DataBase da API em uma tabela **'User'** e são dados sigilosos a pessoa que se cadastra, escolhi essa medida para separar a pessoa do ramo. Assim criando um relacionamento *ORM(Object Relacional-Mapping)* posteriormente vinculando este **'User'** com a próxima base de dados a ser adicionad.
---
> 🔥 Os dados que estão em 🔥 serão salvos no DataBase da API em uma tabela **'Artist'** . Os dados aqui presentes são diretamente voltados para retorno de verbos *HTTP* GET. Estes dados estão ligados com os dados de *User* pelo relacionamento de 1(um) para 1(um)

- ✅ Nome
- ✅ cpf
- ✅ Idade
- ✅ email
- ✅ contato
- ✅ Estado
- ✅ genero

    #
- 🔥 Nome Artístico 
- 🔥 Idade
- 🔥 Estado(Trabalho)
- 🔥 Descrição
- 🔥 Gênero
- 🔥 Valor do programa/Hora
- 🔥 Publico Alvo:(Men \ Woman)
---

## 🛠️ Tecnologias Utilizadas

- Java (versão 17)
- Spring Boot 
- Banco de dados (SQL - MySQL)
- Maven
- Swagger (API Documentation)

---

## 🚀 Como Rodar o Projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/nome-do-repo.git

# Acesse a pasta do projeto
cd nome-do-repo

# Instale as dependências (caso use Maven)
mvn install

# Rode o projeto
mvn spring-boot:run
```

> Em versões futuras, novas entidades, novos campos e validações serão adicionados.
