-- Trabajador admin de prueba
INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, es_admin, es_activo) VALUES
('adminTest', 'passTest123', '99999999A', 'Admin Test', TO_DATE('2021-01-01','YYYY-MM-DD'), 1, 1);

-- Trabajador no admin de prueba
INSERT INTO Trabajador (usuario, contraseña, DNI, nombre, fecha_contratacion, es_admin, es_activo) VALUES
('trabajadorTest', 'passTrabajador', '77777777C', 'Trabajador Test', TO_DATE('2022-05-10','YYYY-MM-DD'), 0, 1);

-- Cliente de prueba
INSERT INTO Cliente (usuario, contraseña, DNI, nombre, telf, direccion, es_activo) VALUES
('clienteTest', 'passCliente', '88888888B', 'Cliente Test', '600000000', 'Calle Test 123', 1);

-- Mascotas de prueba
INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie, adoptada) VALUES
('MC_TEST_001', 'Rex Test', TO_DATE('2017-06-01','YYYY-MM-DD'), 'Pastor Alemán', 1, 0);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie, adoptada) VALUES
('MC_TEST_002', 'Michi Test', TO_DATE('2019-07-15','YYYY-MM-DD'), 'Siames', 2, 0);

INSERT INTO Mascota (Numero_Microchip, nombre, fecha_nacimiento, raza, id_especie, adoptada) VALUES
('MC_TEST_003', 'Bugs Test', TO_DATE('2020-03-20','YYYY-MM-DD'), 'Conejo Holandés', 3, 0);

-- Asociación mascotas-cliente test
INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha) VALUES ('clienteTest', 'MC_TEST_001', SYSDATE);
INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha) VALUES ('clienteTest', 'MC_TEST_002', SYSDATE);
INSERT INTO Cliente_posee_Mascota (id_cliente, id_mascota, fecha) VALUES ('clienteTest', 'MC_TEST_003', SYSDATE);

-- Trato de prueba (usa id_tipo = 1 solo como valor de prueba, asumiendo que existe)
INSERT INTO Trato (fecha_trato, id_trabajador, id_cliente, id_animal, id_tipo) VALUES
(SYSDATE, 'trabajadorTest', 'clienteTest', 'MC_TEST_001', 1);
