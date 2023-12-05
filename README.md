# TP Integrador Desarrollo de Sistemas 2023
## Tecnicatura Universitaria en Tecnologías de la Información
### Docentes: Dardo Kuttel / Luis Stroppi

Repositorio del Trabajo Práctico de la materia Desarrollo de Sistemas (TUTI 2023)
https://github.com/DiegoMMF/tp-desarrollo-de-sistemas


# Integrantes:
- Germán Bruno (german.m.bruno@gmail.com)
- Joaquín Courault (joa.courault@gmail.com)
- Diego M. Maldini Freyre (diegomaldinifreyre@gmail.com)
- Alejandro Rodríguez (rodriguezaristidesalejandro@gmail.com)

# Se debe crear una base de datos con las siguientes características:

spring.datasource.url=jdbc:mysql://localhost:3306/desi2023
spring.datasource.username=root
spring.datasource.password=n0m3n35tnum3n

# Datos iniciales para cargar la BD

CREATE DATABASE `desi2023` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */

INSERT INTO desi2023.cliente (dni, apellido, domicilio, email, fecha_nacimiento, nombre, pasaporte)
VALUES
  (123456789, 'González', 'Calle 123', 'gonzalez@gmail.com', '1990-05-15', 'Ana', 'ABC123'),
  (234567890, 'Martínez', 'Avenida 456', 'martinez@yahoo.com', '1985-08-21', 'Carlos', 'XYZ456'),
  (345678901, 'López', 'Calle Principal', 'lopez@hotmail.com', '1992-02-10', 'Sofía', 'DEF789'),
  (456789012, 'Rodríguez', 'Avenida Central', 'rodriguez@gmail.com', '1988-11-30', 'Juan', 'GHI123'),
  (567890123, 'Fernández', 'Calle Secundaria', 'fernandez@yahoo.com', '1995-07-04', 'Laura', 'JKL456'),
  (678901234, 'Díaz', 'Calle del Medio', 'diaz@hotmail.com', '1983-04-18', 'Miguel', 'MNO789'),
  (789012345, 'Gómez', 'Avenida Principal', 'gomez@gmail.com', '1998-09-25', 'Luis', 'PQR123'),
  (890123456, 'Hernández', 'Calle del Sol', 'hernandez@yahoo.com', '1980-01-12', 'Elena', 'STU456'),
  (901234567, 'Pérez', 'Avenida del Río', 'perez@hotmail.com', '1993-06-28', 'Martín', 'VWX789'),
  (123123123, 'Sánchez', 'Calle de la Luna', 'sanchez@gmail.com', '1987-03-07', 'Ana', 'YZA123');
 
INSERT INTO desi2023.provincia (nombre)
VALUES
  ('Buenos Aires'),
  ('Catamarca'),
  ('Chaco'),
  ('Chubut'),
  ('Córdoba'),
  ('Corrientes'),
  ('Entre Ríos'),
  ('Formosa'),
  ('Jujuy'),
  ('La Pampa'),
  ('La Rioja'),
  ('Mendoza'),
  ('Misiones'),
  ('Neuquén'),
  ('Río Negro'),
  ('Salta'),
  ('San Juan'),
  ('San Luis'),
  ('Santa Cruz'),
  ('Santa Fe'),
  ('Santiago del Estero'),
  ('Tierra del Fuego, Antártida e Islas del Atlántico Sur'),
  ('Tucumán');

INSERT INTO desi2023.ciudad (nombre, provincia_id)
VALUES
  ('Buenos Aires', 1),
  ('Córdoba', 2),
  ('Rosario', 3),
  ('Mendoza', 4),
  ('La Plata', 1),
  ('Salta', 5),
  ('San Juan', 4),
  ('Santa Fe', 3),
  ('Mar del Plata', 1),
  ('Tucumán', 5);

INSERT INTO desi2023.avion (asientos_por_fila, cant_filas, compania, modelo)
VALUES
  (2, 5, 'Aerolíneas Argentinas', 'Boeing 737'),
  (3, 4, 'LATAM Airlines', 'Airbus A320'),
  (2, 3, 'American Airlines', 'Boeing 777'),
  (4, 2, 'Delta Air Lines', 'Airbus A350'),
  (5, 2, 'British Airways', 'Boeing 787'),
  (3, 3, 'Qantas Airways', 'Airbus A330'),
  (2, 4, 'Emirates', 'Boeing 747'),
  (4, 2, 'Lufthansa', 'Airbus A380'),
  (3, 3, 'Singapore Airlines', 'Boeing 767'),
  (2, 4, 'Air Canada', 'Airbus A340');

# Al iniciar, deberán crearse los vuelos y las tasas, ya que no hay ninguno pre-existente.

# Notas de USO:

## Área de Creación de Vuelos:

- El listado de los vuelos figura debajo del formulario de creación de vuelos.
- En caso de haber un error, la aplicación redirije a una pantalla donde muestra el error correspondiente.

## Área de Creación/Edición de Tasas:

#### Vista inicial de Reservas

- Debe ingresarse un DNI.
- Si el DNI no existe, se deberá cargar uno nuevo a través de la opción "Registrar"
- Si el DNI sí existe, se habilitará el ingreso a la vista siguiente.

#### Vista de Registro de Clientes

- En su mayoría, se han quitado las validaciones de los campos para mayor enfoque en la lógica de negocio.
- Esto quiere decir que se pueden ingresar datos que no tengan necesariamente el formato que corresponda (texto, email, etc.)
- Lo único que verifica es que no coincidan los datos con otros ya registrados en la base de datos.

#### Vista de Reserva de Pasajes

- Se debe seleccionar un vuelo de entre los existentes en la BD
- Si el cliente no posee una reserva en el mismo avión, y hay asientos disponibles, entonces, se podrá proceder a la reserva en la BD.
- Tanto si ya ha comprado para ese vuelo, como si no hay asientos disponibles, se ofrecerá salir del proceso y volver a la vista inicial.


## Área de Búsqueda de Vuelos:

- Por cuestiones con la implementación, en la búsqueda de los vuelos, debe ingresarse fecha y hora exacta del vuelo como figura en la BD para que la búsqueda arroje el correspondiente resultado.

## Área de Reserva de Pasajes:

- Las tasas comienzan inicializadas en 0.0 por primera vez.
- Se pueden editar en la misma pantalla y se registran en BD y muestran los datos automáticamente, o se puede cancelar y volver a la página inicial.
