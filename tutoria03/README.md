# API REST - APOO Convocatoria 1

API REST construida con Spring Boot para la gestión de **Estudiantes** y **Docentes**.

## Tecnologías

- Java 17
- Spring Boot 4.0.5
- MariaDB
- Springdoc OpenAPI (Swagger)
- Lombok

## Requisitos previos

- Java 17
- MariaDB corriendo en `localhost:3306`
- Base de datos `grupo01` creada

## Levantar el proyecto

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
cd tutoria03
./mvnw spring-boot:run
```

La aplicación corre en `http://localhost:8089`

## Documentación Swagger

```
http://localhost:8089/swagger-ui/index.html
```

---

## Endpoints — Docentes

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/docentes` | Listar todos los docentes |
| POST | `/docentes` | Crear docente |
| PUT | `/docentes/{id}` | Actualizar docente |
| DELETE | `/docentes/{id}` | Eliminar docente |

### Ejemplo — Crear docente

```json
POST /docentes
{
  "tipoDocumento": "CC",
  "numeroDocumento": "12345678",
  "nombres": "Carlos",
  "apellidos": "Medina",
  "correo": "cmedina@universidad.edu.co",
  "telefono": "3001234567",
  "especialidad": "Programación Orientada a Objetos"
}
```

**Tipos de documento válidos:** CC, TI, CE, PA

### Reglas de negocio

- No se puede crear un docente con el mismo `tipoDocumento` + `numeroDocumento` → `409 Conflict`
- Al actualizar o eliminar, el docente debe existir por ID → `404 Not Found`

---

## Endpoints — Estudiantes

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/estudiantes` | Listar todos los estudiantes |
| GET | `/estudiantes/{id}` | Obtener estudiante por ID |
| POST | `/estudiantes` | Crear estudiante |
| PUT | `/estudiantes/{id}` | Actualizar estudiante |
| DELETE | `/estudiantes/{id}` | Eliminar estudiante |

---

## Manejo de excepciones

| Código | Situación |
|--------|-----------|
| 201 | Docente creado exitosamente |
| 204 | Docente eliminado exitosamente |
| 404 | Docente no encontrado |
| 409 | Documento duplicado (mismo tipo + número) |
