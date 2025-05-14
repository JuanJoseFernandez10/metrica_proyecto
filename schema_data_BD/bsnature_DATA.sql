INSERT INTO Especie (nombre) VALUES ('Perro');
INSERT INTO Especie (nombre) VALUES ('Gato');
INSERT INTO Especie (nombre) VALUES ('Ave');

INSERT INTO Tipo_Trato (nombre) VALUES ('adoptar');
INSERT INTO Tipo_Trato (nombre) VALUES ('donar');

INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, id_administrador)
VALUES ('admin', 'admin', '47312378F', 'Pedro Benito', TO_DATE('2020-09-12', 'YYYY-MM-DD'), NULL);

INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, id_administrador)
VALUES ('trabajador1', 'bsnature', '47362578F', 'Rafael', TO_DATE('2024-05-12', 'YYYY-MM-DD'), 'admin');

INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, id_administrador)
VALUES ('trabajador2', 'bsnature', '12345678A', 'Juan Pérez', TO_DATE('2025-02-10', 'YYYY-MM-DD'), 'admin');

INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion)
VALUES ('usuario1', 'usuario', '23457612E', 'Alejandro', '453443871', 'Calle Almeria Blq 3 2ºDerecha');

INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion)
VALUES ('andre_Xd', 'camas123', '47473612E', 'Antonio', '654143871', 'Av Razas Blq 45 1ºDerecha');

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie)
VALUES ('010101ABC', 'Max', TO_DATE('2018-05-12', 'YYYY-MM-DD'), 'Labrador', 1);

INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha)
VALUES ('usuario1', '010101ABC', SYSDATE);

INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo)
VALUES (TO_DATE('2025-04-12', 'YYYY-MM-DD'), 'trabajador1', 'andre_Xd', '010101ABC', 2);

INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo)
VALUES (SYSDATE, 'trabajador2', 'usuario1', '010101ABC', 1);