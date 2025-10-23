-----

# `spring-boot-todo-api`

## 📝 Visión General

Este repositorio contiene el *backend* de una API de lista de tareas ("Todo App") desarrollada con **Spring Boot 3 (Java 21)**. La aplicación utiliza **PostgreSQL** como base de datos y está completamente **contenida en Docker** para facilitar su despliegue y desarrollo. Incluye **Swagger/OpenAPI** para la documentación y prueba de *endpoints*.

-----

## 🚀 Tecnologías Clave

  * **Lenguaje:** Java 21
  * **Framework:** Spring Boot 3
  * **Base de Datos:** PostgreSQL
  * **Contenedorización:** Docker & Docker Compose
  * **Documentación:** SpringDoc (Swagger/OpenAPI)
  * **Build Tool:** Maven

-----

## 🛠️ Requisitos Previos

Asegúrate de tener instalado lo siguiente en tu sistema:

1.  **Docker & Docker Compose:** Necesarios para construir y ejecutar los contenedores de la aplicación y la base de datos.
2.  **Git:** Para clonar el repositorio.

-----

## ⚙️ Configuración y Ejecución

La aplicación está diseñada para ser levantada completamente con un solo comando de Docker Compose.

### 1\. Clonar el Repositorio

```bash
git clone https://github.com/tu-usuario/spring-boot-todo-api.git
cd spring-boot-todo-api
```

### 2\. Levantar los Contenedores con Docker Compose

Este comando realizará tres pasos clave:

1.  **Compilar** la aplicación Spring Boot dentro del contenedor (utilizando el `Dockerfile`).
2.  **Construir** la imagen Docker de la API.
3.  **Crear y levantar** la base de datos PostgreSQL y la API en contenedores separados, conectándolos a través de una red interna.

<!-- end list -->

```bash
docker compose up --build -d
```

### 3\. Verificar el Estado

Una vez que el comando haya terminado, puedes verificar que los contenedores estén corriendo:

```bash
docker compose ps
```

Deberías ver listados los contenedores `todoapp` y `todoapp_db`.

-----

## 🌐 Endpoints y Documentación

Una vez que la aplicación esté en funcionamiento, puedes acceder a la API y su documentación:

| Recurso | URL | Descripción |
| :--- | :--- | :--- |
| **API Base URL** | `http://localhost:8080/api/tasks` | Todos los *endpoints* de la API (Crear, Leer, Actualizar, Borrar Tareas). |
| **Swagger UI** | `http://localhost:8080/swagger-ui.html` | Interfaz gráfica para probar y ver la documentación. |
| **OpenAPI Docs** | `http://localhost:8080/v3/api-docs` | Especificación JSON/YAML de la API. |

-----

## 🛑 Detener la Aplicación

Para detener y eliminar los contenedores y la red que creó Docker Compose, usa el siguiente comando en la raíz del proyecto:

```bash
docker compose down
```

-----

## 📦 Estructura del Proyecto

  * **`src/`:** Código fuente de la aplicación Spring Boot.
  * **`Dockerfile`:** Define los pasos para construir la imagen de la aplicación, incluyendo la compilación con `mvn clean install`.
  * **`docker-compose.yml`:** Define los servicios (**`api`** y **`postgres`**), sus imágenes, volúmenes, puertos y la red interna.
  * **`pom.xml`:** Archivo de configuración de Maven.
  * **`README.md`:** (Este archivo)

-----

## 🛠️ Notas de Desarrollo

  * La compilación de la aplicación **Java** y la creación de la imagen final se realizan automáticamente dentro del proceso de `docker compose up --build`.
  * Las variables de conexión a la base de datos están configuradas en el archivo `application.properties` y referenciadas a través del servicio `postgres` en `docker-compose.yml`.
