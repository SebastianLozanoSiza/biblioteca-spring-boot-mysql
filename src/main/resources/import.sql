-- Inserts para la entidad Libro
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('Cien años de soledad', 'Gabriel García Márquez', 'Realismo mágico', '1967-01-01', 5);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('El amor en los tiempos del cólera', 'Gabriel García Márquez', 'Realismo mágico', '1985-01-01', 3);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('El túnel', 'Ernesto Sabato', 'Novela', '1948-01-01', 2);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('Rayuela', 'Julio Cortázar', 'Novela', '1963-01-01', 4);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('La ciudad y los perros', 'Mario Vargas Llosa', 'Novela', '1963-01-01', 6);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('El principito', 'Antoine de Saint-Exupéry', 'Literatura infantil', '1943-01-01', 8);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('Don Quijote de la Mancha', 'Miguel de Cervantes', 'Novela', '1605-01-01', 1);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('El aleph', 'Jorge Luis Borges', 'Ficción', '1949-01-01', 3);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('1984', 'George Orwell', 'Ciencia ficción', '1949-01-01', 5);
INSERT INTO libros (titulo, autor, genero, publicacion, cantidad_disponible) VALUES ('Crimen y castigo', 'Fiodor Dostoievski', 'Novela', '1866-01-01', 2);

-- Inserts para la entidad Usuario
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('1234567890', 'Juan', 'Perez', 'juan@gmail.com', 'juan123', '123456789');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('0987654321', 'Maria', 'Gomez', 'maria@example.com', 'to_be_continued', '987654321');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('1122334455', 'Pedro', 'Rodriguez', 'pedro@gmail.com', 'pedro123', '1122334455');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('5544332211', 'Ana', 'Martinez', 'ana@example.com', 'to_be_continued', '5544332211');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('7788990011', 'Luis', 'Lopez', 'luis@gmail.com', 'luis123', '7788990011');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('6677889900', 'Laura', 'Gonzalez', 'laura@example.com', 'to_be_continued', '6677889900');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('3355778899', 'Carlos', 'Sanchez', 'carlos@example.com', 'to_be_continued', '3355778899');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('9900112233', 'Sofia', 'Fernandez', 'sofia@example.com', 'to_be_continued', '9900112233');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('2244668800', 'Elena', 'Rojas', 'elena@example.com', 'to_be_continued', '2244668800');
INSERT INTO usuarios (cedula, nombre, apellido, email, pwd, telefono) VALUES ('8877665544', 'Pablo', 'Ramirez', 'pablo@example.com', 'to_be_continued', '8877665544');

-- Inserts para la entidad Roles
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_ADMIN', 1);      
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_ADMIN', 2); 
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_LIBRARIAN', 3); 
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_LIBRARIAN', 4); 
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 5); 
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 6);
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 7);
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 8);
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 9);
INSERT INTO roles (nombre_rol, id_usuario) VALUES ('ROLE_USER', 10);
-- Inserts para la entidad Prestamo
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (1, 1, '2024-04-13', '2024-05-13', 0);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (2, 2, '2024-04-13', '2024-05-13', 1);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (3, 3, '2024-04-13', '2024-05-13', 2);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (4, 4, '2024-04-13', '2024-05-13', 3);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (5, 5, '2024-04-13', '2024-05-13', 3);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (6, 6, '2024-04-13', '2024-05-13', 2);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (7, 7, '2024-04-13', '2024-05-13', 1);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (8, 8, '2024-04-13', '2024-05-13', 0);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (9, 9, '2024-04-13', '2024-05-13', 0);
INSERT INTO prestamos (id_usuario, id_libro, fecha_prestamo, fecha_devolucion, estado_prestamo) VALUES (10, 10, '2024-04-13', '2024-05-13', 0);
