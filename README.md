# Catalogue Service API

## Présentation

**Catalogue Service API** est un microservice REST développé avec
**Spring Boot** permettant de gérer les fonctionnalités liées au
catalogue de produits. Cette première version expose des points d'accès
permettant de vérifier la disponibilité du service et de consulter sa
version.

------------------------------------------------------------------------

## Technologies utilisées

-   Java 21
-   Spring Boot
-   Spring Web
-   Spring Data JPA
-   Maven
-   MySQL
-   Docker (optionnel)

------------------------------------------------------------------------

## Prérequis

-   JDK 21 ou supérieur
-   Maven 3.9+
-   MySQL 8+
-   Git

------------------------------------------------------------------------

## Installation

### Cloner le projet

``` bash
git clone https://github.com/lifpro/myshop-catalog.git
cd myshop-catalog
```

### Compiler le projet

``` bash
mvn clean install
```

### Démarrer l'application

``` bash
mvn spring-boot:run
```

L'API sera disponible à l'adresse :

    http://localhost:8081

------------------------------------------------------------------------

## Configuration

Exemple de fichier `application.properties` :

``` properties
spring.datasource.url=jdbc:mysql://localhost:3306/myshop_catalog
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

# Endpoints disponibles

## 1. Vérification du service

**GET** `/api/v1/hello`

URL :

    http://localhost:8081/api/v1/hello

Réponse :

``` json
{
  "message": "Hello from Catalogue Service!"
}
```

------------------------------------------------------------------------

## 2. Version de l'API

**GET** `/api/v1/version`

URL :

    http://localhost:8080/api/v1/version

Réponse :

``` json
{
  "service": "catalogue-service",
  "version": "1.0.0"
}
```

------------------------------------------------------------------------

## Test avec cURL

### Hello

``` bash
curl http://localhost:8081/api/v1/hello
```

### Version

``` bash
curl http://localhost:8080/api/v1/version
```

------------------------------------------------------------------------

## Structure du projet

``` text
src
├── main
│   ├── java
│   └── resources
│       └── application.properties
├── test
└── pom.xml
```

------------------------------------------------------------------------

## Évolutions prévues

-   Gestion des catégories
-   Gestion des produits
-   Recherche multicritère
-   Pagination
-   Validation des données
-   Documentation OpenAPI / Swagger
-   Authentification JWT
-   Conteneurisation Docker
-   Déploiement Kubernetes

------------------------------------------------------------------------

## Auteur

**TECHNOLAB**

Développement de solutions logicielles, intégration de systèmes
d'information et accompagnement à la transformation numérique.

------------------------------------------------------------------------

## Licence

Ce projet est distribué sous licence **MIT**.
