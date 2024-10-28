# API REST con Spring Boot

Este proyecto implementa una API REST utilizando Spring Boot que permite gestionar tipos de oportunidades, oportunidades, instituciones y ubicaciones.

## Características

- CRUD para **Tipos de Oportunidades**
- CRUD para **Oportunidades**
- CRUD para **Instituciones**
- Listado de **Ubicaciones** de las instituciones

## Requisitos

- JDK 11 o superior
- Maven 3.6 o superior
- IDE (recomendado: IntelliJ IDEA, Eclipse)
- Base de datos (puede usar H2, MySQL, etc.)

## Instalación

Sigue estos pasos para configurar y ejecutar el proyecto:

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/nombre-del-repositorio.git`
2. **Navegar al directorio del proyecto**:
`cd nombre-del-repositorio`
3. **Construir el proyecto**:
	``mvn clean install``
4. **Configurar la base de datos**:

-   Asegúrate de que tu base de datos esté corriendo y configurada correctamente.
-   Modifica el archivo `src/main/resources/application.properties` para configurar la conexión a la base de datos. Por ejemplo, para H2:

```bash
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
```

5. **Ejecutar la aplicación**:
``mvn spring-boot:run``
## Uso de la API

Una vez que la aplicación esté en ejecución, puedes realizar las siguientes operaciones usando herramientas como Postman o Swagger:

### Tipos de Oportunidades

-   **Crear Tipo de Oportunidad**: `POST /api/tipos-oportunidades`
-   **Leer Todos los Tipos de Oportunidades**: `GET /api/tipos-oportunidades`
-   **Actualizar Tipo de Oportunidad**: `PUT /api/tipos-oportunidades/{id}`
-   **Eliminar Tipo de Oportunidad**: `DELETE /api/tipos-oportunidades/{id}`

### Oportunidades

-   **Crear Oportunidad**: `POST /api/oportunidades`
-   **Leer Todas las Oportunidades**: `GET /api/oportunidades`
-   **Actualizar Oportunidad**: `PUT /api/oportunidades/{id}`
-   **Eliminar Oportunidad**: `DELETE /api/oportunidades/{id}`

### Instituciones

-   **Crear Institución**: `POST /api/instituciones`
-   **Leer Todas las Instituciones**: `GET /api/instituciones`
-   **Actualizar Institución**: `PUT /api/instituciones/{id}`
-   **Eliminar Institución**: `DELETE /api/instituciones/{id}`

### Ubicaciones

-   **Listar Ubicaciones de Instituciones**: `GET /api/instituciones/{id}/ubicaciones`

### Agradeciminentos 
-  Docente: Marinellys Figueroa.
