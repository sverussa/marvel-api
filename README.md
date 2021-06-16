# Getting Started

### Reference Documentation

Desafio Api Marvel

O Projeto foi desenvolvido em Spring Boot com Java versão 16 (AdoptOpendJDK)
Os dados são armazenados em um banco de dados Postgres.

Tudo rodando com o Docker configurado com pelo arquivo docker compose.

Quando iniciada a aplicação o banco de dados é criado e populado com Scripts de migração.

Os testes utilizam banco de dados em memória.

Alguns Heróis tem mais dados nos end points:
    
    ID      | Name
    1009664	| Thor
    1009610	| Spider-Man
    1009220	| Captain America
    1009368	| Iron Man

# Comando para inicializar API
    docker compose up

# Estrutura

# Documentação do Swagger pode ser encontrada nos links

    http://localhost:8080/swagger-ui/index.html#/
    http://localhost:8080/v2/api-docs

# Os End Points Implementados conforme abaixo:

    GET /v1/public/characters
    GET /v1/public/characters/{characterId}
    GET /v1/public/characters/{characterId}/comics
    GET /v1/public/characters/{characterId}/events
    GET /v1/public/characters/{characterId}/series
    GET /v1/public/characters/{characterId}/stories

