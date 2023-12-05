# tp-desarrollo-de-sistemas
Repositorio del Trabajo Práctico de la materia Desarrollo de Sistemas (TUTI 2023)

# Integrantes:
- Germán Bruno
- Joaquín Courault
- Diego M. Maldini Freyre
- Alejandro Rodríguez

# Se debe crear una base de datos con las siguientes características:

spring.datasource.url=jdbc:mysql://localhost:3306/desi2023
spring.datasource.username=root
spring.datasource.password=n0m3n35tnum3n

# Datos iniciales para cargar la BD
INSERT INTO cliente (dni, apellido, domicilio, email, fecha_nacimiento, nombre, pasaporte)
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
 
INSERT INTO provincia (nombre)
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

INSERT INTO ciudad (nombre, provincia_id)
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

INSERT INTO avion (asientos_por_fila, cant_filas, compania, modelo)
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

-
-
-

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

-
-
-

## Área de Reserva de Pasajes:

- 
-
-
