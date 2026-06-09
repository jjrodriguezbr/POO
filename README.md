# API REST - Gestión de Estudiantes

API REST desarrollada con Spring Boot para la gestión de estudiantes. Proyecto de entrega del 60% del curso de Programación Orientada a Objetos (APOO).

## Integrantes

- Jheampier Rodríguez
- Sebastián Prieto
- Alejandro García

## Tecnologías

- Java 17
- Spring Boot 4.0.5
- MariaDB
- Swagger / OpenAPI 3
- Lombok
- Maven

## Endpoints

| Método | URL | Descripción |
|--------|-----|-------------|
| GET | /estudiantes | Obtener todos los estudiantes |
| GET | /estudiantes/{id} | Obtener estudiante por ID |
| POST | /estudiantes | Crear estudiante |
| PUT | /estudiantes/{id} | Actualizar estudiante |
| DELETE | /estudiantes/{id} | Eliminar estudiante |

## Documentación

Con el proyecto corriendo, acceder a Swagger UI en:

```
http://localhost:8089/swagger-ui/index.html
```

## Configuración de la base de datos

Crear la base de datos antes de correr el proyecto:

```sql
CREATE DATABASE grupo01;
```

Configurar las credenciales en `tutoria03/src/main/resources/application.properties`.

## Cómo correr el proyecto

```bash
cd tutoria03
./mvnw spring-boot:run
```

## Colección Postman

La colección de endpoints está disponible en `/collection/Api-Estudiantes.postman_collection.json`.
