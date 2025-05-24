INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, es_admin)
VALUES ('admin', 'admin', '12345678A', 'Administrador General',sysdate, 1);

INSERT INTO Trabajador (usuario, contraseña, DNI, fecha_contratacion, nombre)
VALUES ('trabajador01', 'pass123', '87654321B',sysdate, 'Juan Pérez');

INSERT INTO Trabajador (usuario, contraseña, DNI, fecha_contratacion, nombre)
VALUES ('trabajador02', 'pass123', '11223344C',sysdate, 'Lucía Gómez');

INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion)
VALUES ('cliente01', 'cliente123', '99887766D', 'Carlos Ruiz', '666123456', 'Calle Falsa 123');

INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion)
VALUES ('cliente02', 'cliente123', '88776655E', 'Ana López', '666654321', 'Av. Siempre Viva 742');

INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion)
VALUES ('cliente03', 'cliente123', '77665544F', 'Luis Torres', '666987654', 'Plaza Mayor 1');

INSERT INTO Especie (nombre) VALUES ('Perro');
INSERT INTO Especie (nombre) VALUES ('Gato');
INSERT INTO Especie (nombre) VALUES ('Conejo');

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie)
VALUES ('100000000000001', 'Firulais', TO_DATE('2020-05-10', 'YYYY-MM-DD'), 'Labrador', 1);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie, adoptada)
VALUES ('100000000000002', 'Misu', TO_DATE('2019-08-22', 'YYYY-MM-DD'), 'Persa', 2, 1);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie, adoptada)
VALUES ('100000000000003', 'Pelusa', TO_DATE('2021-12-05', 'YYYY-MM-DD'), 'Mini Lop', 3, 1);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie)
VALUES ('100000000000004', 'Rocky', TO_DATE('2022-11-03', 'YYYY-MM-DD'), 'Pastor Alemán', 1);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie)
VALUES ('100000000000005', 'Luna', TO_DATE('2023-01-12', 'YYYY-MM-DD'), 'Siames', 2);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie)
VALUES ('100000000000006', 'Copito', TO_DATE('2021-07-30', 'YYYY-MM-DD'), 'Enano Holandés', 3);

INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha)
VALUES ('cliente02', '100000000000002', TO_DATE('2019-09-01', 'YYYY-MM-DD'));

INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha)
VALUES ('cliente03', '100000000000003', TO_DATE('2022-01-01', 'YYYY-MM-DD'));

INSERT INTO Tipo_Trato (nombre) VALUES ('Adopcion');
INSERT INTO Tipo_Trato (nombre) VALUES ('Dar adopcion');


INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo)
VALUES (TO_DATE('2023-02-15', 'YYYY-MM-DD'), 'trabajador01', 'cliente01', '100000000000001', 2);

INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo)
VALUES (TO_DATE('2023-03-20', 'YYYY-MM-DD'), 'trabajador02', 'cliente02', '100000000000002', 1);

INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo)
VALUES (TO_DATE('2023-04-10', 'YYYY-MM-DD'), 'trabajador01', 'cliente03', '100000000000003', 1);
