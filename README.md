# Voll.med API

Este proyecto es una **API RESTful** desarrollada en Java con Spring Boot, orientada a la gestión de médicos y pacientes. El objetivo es proporcionar un espacio de servidor robusto y escalable, facilitando la integración y automatización de procesos tanto en desarrollo como en producción.

## Dependencias Clave

El proyecto aprovecha varias dependencias para agilizar el desarrollo y mejorar la mantenibilidad:

- **Spring Boot Starter Web**: Permite crear endpoints HTTP de manera sencilla, gestionando solicitudes y respuestas (GET, POST, PUT, DELETE) de forma eficiente.
- **Spring Boot Starter Data JPA**: Facilita la comunicación con la base de datos mediante repositorios, eliminando la necesidad de escribir SQL manualmente para operaciones CRUD.
- **Spring Boot Starter Validation**: Permite validar automáticamente los datos recibidos en las solicitudes HTTP usando anotaciones en las clases DTO.
- **Spring Boot Starter Security**: Añade mecanismos de autenticación y autorización para proteger los endpoints de la API.
- **jjwt**: Permite la generación y validación de tokens JWT para la autenticación basada en tokens.
- **Lombok**: Reduce el código repetitivo (getters, setters, constructores) mediante anotaciones.
- **Flyway**: Gestiona las migraciones de la base de datos de forma automática y controlada.
- **MySQL Connector/J**: Permite la conexión con bases de datos MySQL.
- **Docker**: Facilita la creación de entornos reproducibles y portables para la base de datos y herramientas de administración.

## Utilidad de las Dependencias

- **Solicitudes HTTP**: Spring Boot gestiona automáticamente las rutas y métodos HTTP, permitiendo exponer endpoints REST para interactuar con la API.
- **DTOs (Data Transfer Objects)**: Las clases DTO definen la estructura de los datos que viajan entre el cliente y el servidor, asegurando validación y separación de responsabilidades.
- **Comunicación entre Clases**: El uso de anotaciones como `@Autowired` y la inyección de dependencias permite que los controladores, servicios y repositorios colaboren de manera desacoplada y eficiente.
- **Validación**: Las anotaciones en los DTOs aseguran que los datos recibidos sean correctos antes de ser procesados o almacenados.
- **Seguridad**: Spring Security y JWT permiten proteger los endpoints, asegurando que solo usuarios autenticados y autorizados puedan acceder a los recursos sensibles.

## Buenas Prácticas y Seguridad

El proyecto implementa buenas prácticas de desarrollo y seguridad, siguiendo los principios de separación de responsabilidades y validación de datos en los DTOs. Además, se utiliza **Spring Security** junto con **JWT** para la autenticación y autorización de usuarios.

### Utilidad del Token JWT

- **Autenticación**: Los usuarios deben autenticarse mediante un endpoint de login, donde reciben un token JWT si las credenciales son válidas.
- **Autorización**: El token JWT debe enviarse en la cabecera `Authorization` para acceder a los endpoints protegidos.
- **Control de Acceso**: Los endpoints sensibles están protegidos y solo pueden ser accedidos por usuarios autenticados. Se pueden definir roles para restringir el acceso según el perfil del usuario.
- **Endpoints públicos**: Algunos endpoints, como el de login o registro, son públicos y no requieren autenticación.

#### Ejemplo de uso de token JWT

Al hacer una petición a un endpoint protegido, debes incluir el token en la cabecera:

```
Authorization: Bearer tu_token_jwt
```

Esto permite que el backend valide la identidad del usuario y determine si tiene permisos para acceder al recurso solicitado.

## Estructura del Proyecto `voll_med`

El proyecto sigue una estructura modular y organizada, facilitando la escalabilidad y el mantenimiento. A continuación se describe cada carpeta y archivo principal:

```
voll_med/
├── docker/
│   └── docker-compose.yml         # Configuración de servicios Docker (MySQL, Adminer, etc.)
├── HELP.md                        # Documentación de ayuda del proyecto
├── mvnw, mvnw.cmd                 # Wrappers de Maven para facilitar la ejecución
├── pom.xml                        # Archivo de configuración de dependencias Maven
├── README.md                      # Documentación principal del proyecto
├── screenshot/                    # Capturas de pantalla ilustrativas
│   ├── captura-adminer.png
│   ├── captura-delete.png
│   ├── captura-estructura.png
│   ├── captura-post.png
│   └── captura-put.png
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── med/
│   │   │       └── voll/
│   │   │           └── api/
│   │   │               ├── ApiApplication.java         # Clase principal de Spring Boot
│   │   │               ├── controller/                 # Controladores REST (HTTP)
│   │   │               │   ├── MedicalController.java
│   │   │               │   ├── PatientController.java
│   │   │               │   └── UserController.java
│   │   │               ├── infra/
│   │   │               │   ├── exceptions/
│   │   │               │   │   └── MannagerErrors.java # Manejo global de errores
│   │   │               │   └── security/               # Seguridad y JWT
│   │   │               │       ├── AutowiredUser.java
│   │   │               │       ├── DataTokenJWT.java
│   │   │               │       ├── SecurityConfi.java
│   │   │               │       ├── SecurityFilter.java
│   │   │               │       └── TokenService.java
│   │   │               ├── model/                      # Modelos de dominio
│   │   │               │   ├── medical/
│   │   │               │   ├── patient/
│   │   │               │   └── person/
│   │   │               └── repository/                 # Repositorios JPA
│   │   └── resources/
│   │       ├── application.properties                  # Configuración de la aplicación
│   │       ├── applicatio.properties.example           # Ejemplo de configuración
│   │       ├── db/
│   │       │   └── migration/                          # Migraciones Flyway
│   │       │       ├── V1__create-tables.sql
│   │       │       ├── V2__alter-table-medicos-add-column-status.sql
│   │       │       ├── V3__alter-table-pacientes-add-column-status.sql
│   │       │       └── V4__create-table-user.sql
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── med/
│               └── voll/
│                   └── api/
│                       └── ApiApplicationTests.java    # Pruebas unitarias e integración
```

## Descripción de Carpetas y Archivos

- **docker/**: Configuración para levantar servicios auxiliares (MySQL, Adminer) usando Docker Compose.
- **screenshot/**: Imágenes y capturas de pantalla para documentación y ejemplos.
- **src/main/java/**: Código fuente principal de la aplicación.
  - **controller/**: Controladores REST que gestionan las rutas y solicitudes HTTP.
  - **infra/**: Infraestructura de la aplicación, como manejo de errores y seguridad (JWT, filtros, configuración).
  - **model/**: Entidades y modelos de dominio, organizados por contexto (médicos, pacientes, personas).
  - **repository/**: Interfaces de acceso a datos, extendiendo JPA.
- **src/main/resources/**: Recursos de la aplicación (configuración, migraciones de base de datos, archivos estáticos).
- **src/test/java/**: Pruebas unitarias y de integración.
- **pom.xml**: Archivo de dependencias y configuración de Maven.
- **README.md**: Documentación principal del proyecto.

Esta estructura sigue las buenas prácticas de Spring Boot y Java, permitiendo un desarrollo limpio, modular y fácil de mantener.

## Pruebas con Insomnia

Puedes utilizar [Insomnia](https://insomnia.rest/) para probar los endpoints de la API:

- **GET** `/medicos` y `/pacientes`: Listar médicos y pacientes.
- **POST** `/medicos` y `/pacientes`: Crear nuevos registros enviando un JSON con los datos requeridos.
- **PUT** `/medicos` y `/pacientes`: Actualizar información existente.
- **DELETE** `/medicos/{id}` y `/pacientes/{id}`: Eliminar (deshabilitar) registros.
- **LOGIN** `/login`: Obtener el token JWT para autenticación.

Recuerda incluir el token JWT en la cabecera `Authorization` para acceder a los endpoints protegidos.

Insomnia permite enviar fácilmente solicitudes HTTP y visualizar las respuestas, facilitando el desarrollo y la depuración.

## Espacio DevOps con Docker

El proyecto incluye archivos de configuración para **Docker** y **docker-compose**, permitiendo levantar rápidamente un entorno de base de datos MySQL y herramientas de administración como Adminer. Esto asegura que el entorno de desarrollo sea consistente y fácil de replicar en cualquier máquina o entorno de CI/CD.

## Descripción del archivo `docker-compose.yml`

El archivo `docker-compose.yml` define y orquesta los servicios necesarios para el entorno de desarrollo:

- **mysql**: Contenedor de la base de datos MySQL, configurado con usuario, contraseña y base de datos específicos para la aplicación.
- **adminer**: Herramienta web para la administración visual de la base de datos, accesible desde el navegador.
- **volúmenes**: Permiten la persistencia de los datos de la base de datos incluso si el contenedor se reinicia o elimina.
- **red**: Los servicios se comunican en una red interna definida por Docker Compose.

Esto facilita la configuración y el despliegue del entorno de desarrollo con un solo comando, asegurando consistencia y portabilidad.

### Ejemplo de uso:

```sh
cd docker
docker-compose up -d
```

Esto levantará los servicios necesarios para la base de datos y la administración.

---

## Capturas de Pantalla

A continuación se muestran algunas capturas de pantalla que ilustran la utilidad y funcionamiento del sistema:

### 1. Ejemplo de petición GET en Insomnia

- (Consulta de médicos)
![GET en Insomnia](/screenshot/captura-get.png)

---

### 2. Ejemplo de creación de un médico (POST)

- (Creación de instancia de Médico)
![POST en Insomnia](/screenshot/captura-post.png)

---

### 3. Ejemplo de actualización de un médico (PUT)

- (Actualización de instancia de Médico)
![PUT en Insomnia](/screenshot/captura-put.png)

---

### 4. Ejemplo de eliminación de un médico (DELETE)

- (Eliminación/Cambio de estado de instancia de Médico)
![DELETE en Insomnia](/screenshot/captura-delete.png)

---

### 5. Visualización de la base de datos en Adminer

- (Espacio de Administración de MySQL)
![Adminer](/screenshot/captura-adminer.png)

---

### 6. Estructura del proyecto en el IDE

- (IDE VSCODE manejador de proyecto)
![Estructura del Proyecto](/screenshot/captura-estructura.png)

---

## Conclusión

El uso de estas dependencias y herramientas permite crear una API REST robusta, segura, escalable y fácil de mantener, facilitando tanto el desarrollo como la integración y el despliegue en entornos productivos.

---

## Créditos

- Práctica planificada por [Alura Latam](https://www.aluracursos.com/)
- Elaborado por: [jmikhaelz](https://www.linkedin.com/in/jmikhaelz/)

---