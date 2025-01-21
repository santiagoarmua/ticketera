Ticketera - TicketPary

TicketPary es una aplicación desarrollada para la gestión de eventos y entradas.
Este proyecto permite a los usuarios explorar eventos, adquirir entradas y realizar un seguimiento de sus transacciones. 
La aplicación está compuesta por un backend desarrollado con Spring Boot.

Características principales

Gestión de eventos: Creación, edición y eliminación de eventos.
Compra de entradas: Sistema de compra y reserva de tickets para eventos.
Historial de transacciones: Seguimiento de todas las operaciones realizadas.

Tecnologías utilizadas

Backend
Framework: Spring Boot
Base de datos: MySQL
Gestor de dependencias: Maven

Instalación y configuración
Prerrequisitos
Tener instalado:
JDK 11 o superior.
MySQL.

Clonar el repositorio:
git clone https://github.com/santiagoarmua/ticketera.git
cd ticketera/ticketpary

Configuración del backend
Configura las credenciales de la base de datos en el archivo application.properties o application.yml:
spring.datasource.url=jdbc:mysql://localhost:3306/ticketera
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update

Ejecuta la aplicación:
mvn spring-boot:run

USO
Explora los eventos disponibles.
Compra o reserva entradas.
Consulta tu historial de transacciones.





