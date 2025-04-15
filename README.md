<h1 align="center" id="title">API pruebas moleculares COVID 19</h1>

<p align="center"><img src="https://github.com/vape2205/java_springboot_pruebasmolecularesapi" alt="project-image"></p>

<p id="description">API para registro y consulta de pruebas moleculares</p>

  
  
<h2>🧐 Features</h2>

Caracteristicas

*   Crear registro de prueba molecular
*   Eliminar registro de prueba
*   Modificar registro de prueba molecular
*   Listado de registros de pruebas moleculares
*   Busqueda por departamento de muestra

<h2>🛠️ Installation Steps:</h2>

<p>1. Agregar archivo de environment</p>

Crear un archivo .env en la raiz del proyecto

```
# Variables de entorno para la bd 
POSTGRES_DB=db_pruebas_moleculares
POSTGRES_USER="Usuario de la base de datos" 
POSTGRES_PASSWORD="Password de la base de datos"
POSTGRES_PORT=5432  

# Variables de entorno para Spring Boot 
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/db_pruebas_moleculares
SPRING_DATASOURCE_USERNAME="Usuario de la base de datos" 
SPRING_DATASOURCE_PASSWORD="Password de la base de datos"
SERVER_PORT=9200
```

<p>2. Ejecutar Docker Compose</p>

```
docker compose up -d --build
```

<h2>Endpoints</h2>

* Listar establecimientos
```
http://localhost:9200/api/pruebas-moleculares
```
* Listar establecimientos paginados
```
http://localhost:9200/api/pruebas-moleculares?page=1&size=20
```
* Cargar archivo establecimientos
```
curl --location 'http://localhost:9200/api/pruebas-moleculares/upload' \
--header 'Content-Disposition: attachment; filename=<<Nombre archivo>>' \
--form 'file=@"/<<Ruta archivo>>"'
```
  
<h2>💻 Built with</h2>

Tecnologias usadas en este proyecto:

*   Spring Boot
*   Postgres