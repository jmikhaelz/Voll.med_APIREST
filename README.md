# Voll.med API

Este proyecto es una **API RESTful** desarrollada en Java con Spring Boot, orientada a la gestión de médicos y pacientes. El objetivo es proporcionar un espacio de servidor robusto y escalable, facilitando la integración y automatización de procesos tanto en desarrollo como en producción.

##  Dependencias Clave

El proyecto aprovecha varias dependencias para agilizar el desarrollo y mejorar la mantenibilidad:

- **Spring Boot Starter Web**: Permite crear endpoints HTTP de manera sencilla, gestionando solicitudes y respuestas (GET, POST, PUT, DELETE) de forma eficiente.
- **Spring Boot Starter Data JPA**: Facilita la comunicación con la base de datos mediante repositorios, eliminando la necesidad de escribir SQL manualmente para operaciones CRUD.
- **Spring Boot Starter Validation**: Permite validar automáticamente los datos recibidos en las solicitudes HTTP usando anotaciones en las clases DTO.
- **Spring Boot Starter HATEOAS**: Estructura las respuestas de la API siguiendo el estándar HATEOAS, facilitando la navegación y el consumo de la API.
- **Lombok**: Reduce el código repetitivo (getters, setters, constructores) mediante anotaciones.
- **Flyway**: Gestiona las migraciones de la base de datos de forma automática y controlada.
- **MySQL Connector/J**: Permite la conexión con bases de datos MySQL.
- **Docker**: Facilita la creación de entornos reproducibles y portables para la base de datos y herramientas de administración.

##  Utilidad de las Dependencias

Gracias a estas dependencias, el desarrollo es más ágil y seguro:

- **Solicitudes HTTP**: Spring Boot gestiona automáticamente las rutas y métodos HTTP, permitiendo exponer endpoints REST para interactuar con la API.
- **DTOs (Data Transfer Objects)**: Las clases DTO definen la estructura de los datos que viajan entre el cliente y el servidor, asegurando validación y separación de responsabilidades.
- **Comunicación entre Clases**: El uso de anotaciones como `@Autowired` y la inyección de dependencias permite que los controladores, servicios y repositorios colaboren de manera desacoplada y eficiente.
- **Validación**: Las anotaciones en los DTOs aseguran que los datos recibidos sean correctos antes de ser procesados o almacenados.

##  Estructura de la API

- **Controladores**: Gestionan las solicitudes HTTP y delegan la lógica a las clases de servicio y repositorio.
- **Modelos y DTOs**: Definen la estructura de los datos y validan la información entrante.
- **Repositorios**: Interactúan con la base de datos usando JPA.

##  Estructura del Proyecto

La organización del proyecto sigue las buenas prácticas de Spring Boot, facilitando la escalabilidad y el mantenimiento:

```
voll_med/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── tuempresa/
│   │   │           └── vollmed/
│   │   │               ├── controller/   # Controladores REST (manejan las solicitudes HTTP)
│   │   │               ├── model/        # Entidades y modelos de dominio
│   │   │               ├── dto/          # Clases DTO para transferencia y validación de datos
│   │   │               ├── repository/   # Interfaces de acceso a datos (JPA)
│   │   │               └── service/      # Lógica de negocio y servicios
│   │   └── resources/
│   │       ├── application.properties    # Configuración de la aplicación
│   │       └── db/
│   │           └── migration/            # Migraciones de base de datos (Flyway)
│   └── test/                             # Pruebas unitarias y de integración
├── docker/                               # Archivos de configuración Docker y docker-compose
├── README.md
└── ...
```

- **controller/**: Gestiona las rutas y métodos HTTP, delegando la lógica a los servicios.
- **model/**: Define las entidades que representan las tablas de la base de datos.
- **dto/**: Contiene los Data Transfer Objects para validar y transferir datos entre cliente y servidor.
- **repository/**: Interfaces que extienden JPA para interactuar con la base de datos.
- **service/**: Implementa la lógica de negocio y orquesta la comunicación entre controladores y repositorios.
- **resources/db/migration/**: Scripts de migración de base de datos gestionados por Flyway.
- **docker/**: Configuración para levantar el entorno de desarrollo con Docker y Docker Compose.

Esta estructura permite un desarrollo modular, facilitando la

##  Pruebas con Insomnia

Puedes utilizar [Insomnia](https://insomnia.rest/) para probar los endpoints de la API:

- **GET** `/medicos` y `/pacientes`: Listar médicos y pacientes.
- **POST** `/medicos` y `/pacientes`: Crear nuevos registros enviando un JSON con los datos requeridos.
- **PUT** `/medicos` y `/pacientes`: Actualizar información existente.
- **DELETE** `/medicos/{id}` y `/pacientes/{id}`: Eliminar (deshabilitar) registros.

Insomnia permite enviar fácilmente solicitudes HTTP y visualizar las respuestas, facilitando el desarrollo y la depuración.

##  Espacio DevOps con Docker

El proyecto incluye archivos de configuración para **Docker** y **docker-compose**, permitiendo levantar rápidamente un entorno de base de datos MySQL y herramientas de administración como Adminer. Esto asegura que el entorno de desarrollo sea consistente y fácil de replicar en cualquier máquina o entorno de CI/CD.

##  Descripción del archivo `docker-compose.yml`

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

- (Creacion de instancia de Medico)
![POST en Insomnia](/screenshot/captura-post.png)

---

### 2. Ejemplo de petición PUT en Insomnia

- (Actualizacion de instancia de Medico)
![POST en Insomnia](/screenshot/captura-put.png)

---
### 3. Ejemplo de petición DELETE en Insomnia

- (Elimicacion/Cambio de estado de instancia de Medico)
![DELETE en Insomnia](/screenshot/captura-delete.png)

---

### 4. Visualización de la base de datos en Adminer

- (Espacio de Administracion de MySQL)
![Adminer](/screenshot/captura-adminer.png)

---

### 5. Estructura del proyecto en el IDE

- (IDE VSCODE manejador de proyecto)
![Estructura del Proyecto](/screenshot/captura-estructura.png)

---

##  Conclusión

El uso de estas dependencias y herramientas permite crear una API REST robusta, escalable y fácil de mantener, facilitando tanto el desarrollo como la integración y el despliegue en entornos productivos.

---


## Créditos

- Practica planificada por [Alura Latam](https://www.aluracursos.com/)
- Elaborado por: [jmikhaelz](https://www.linkedin.com/in/jmikhaelz/)

---
