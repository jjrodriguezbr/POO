# Tutoria03 - API REST APOO

Proyecto de la materia Aplicación de Programación Orientada a Objetos.

## Como correr el proyecto

Tener MariaDB corriendo con la base de datos `grupo01` creada.

```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk
export PATH=$JAVA_HOME/bin:$PATH
./mvnw spring-boot:run
```

Corre en `http://localhost:8089`

Swagger: `http://localhost:8089/swagger-ui/index.html`

## Endpoints Docentes

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET | `/docentes` | Listar docentes |
| POST | `/docentes` | Crear docente |
| PUT | `/docentes/{id}` | Actualizar docente |
| DELETE | `/docentes/{id}` | Eliminar docente |

## Endpoints Estudiantes

| Metodo | Ruta | Descripcion |
|--------|------|-------------|
| GET | `/estudiantes` | Listar estudiantes |
| GET | `/estudiantes/{id}` | Buscar por ID |
| POST | `/estudiantes` | Crear estudiante |
| PUT | `/estudiantes/{id}` | Actualizar estudiante |
| DELETE | `/estudiantes/{id}` | Eliminar estudiante |
