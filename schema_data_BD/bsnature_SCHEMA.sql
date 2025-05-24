CREATE TABLE Trabajador (
    usuario VARCHAR2(50) PRIMARY KEY,
    contraseña VARCHAR2(100) NOT NULL,
    DNI VARCHAR2(9) UNIQUE NOT NULL,
    nombre VARCHAR2(100) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    es_admin NUMBER default 0 NOT NULL,
    es_activo NUMBER DEFAULT 1
);

CREATE TABLE Cliente (
    usuario VARCHAR2(50) PRIMARY KEY,
    contraseña VARCHAR2(100) NOT NULL,
    DNI VARCHAR2(9) UNIQUE NOT NULL,
    nombre VARCHAR2(100) NOT NULL,
    telf VARCHAR2(15),
    direccion VARCHAR2(200),
    es_activo NUMBER DEFAULT 1
);

CREATE TABLE Especie (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(50) NOT NULL
);

CREATE TABLE Mascota (
    Numero_Microchip VARCHAR(15) PRIMARY KEY,
    nombre VARCHAR2(100),
    fecha_nacimiento DATE,
    raza VARCHAR2(50),
    id_especie NUMBER NOT NULL,
    adoptada NUMBER DEFAULT 0,
    CONSTRAINT fk_mascota_especie FOREIGN KEY (id_especie)
        REFERENCES Especie(id) ON DELETE CASCADE
);

CREATE TABLE Cliente_posee_Mascota (
    id_cliente VARCHAR2(50),
    id_mascota VARCHAR(15),
    fecha DATE,
    PRIMARY KEY (id_cliente, id_mascota),
    CONSTRAINT fk_posee_cliente FOREIGN KEY (id_cliente)
        REFERENCES Cliente(usuario) ON DELETE CASCADE,
    CONSTRAINT fk_posee_mascota FOREIGN KEY (id_mascota)
        REFERENCES Mascota(Numero_Microchip) ON DELETE CASCADE
);

CREATE TABLE Tipo_Trato (
    id NUMBER PRIMARY KEY,
    nombre VARCHAR2(100) NOT NULL
);

CREATE TABLE Trato (
    id NUMBER PRIMARY KEY,
    fecha_trato DATE NOT NULL,
    id_trabajador VARCHAR2(50),
    id_cliente VARCHAR2(50),
    id_animal VARCHAR(15),
    id_tipo NUMBER,
    CONSTRAINT fk_trato_trabajador FOREIGN KEY (id_trabajador)
        REFERENCES Trabajador(usuario) ON DELETE CASCADE,
    CONSTRAINT fk_trato_cliente FOREIGN KEY (id_cliente)
        REFERENCES Cliente(usuario) ON DELETE CASCADE,
    CONSTRAINT fk_trato_mascota FOREIGN KEY (id_animal)
        REFERENCES Mascota(Numero_Microchip) ON DELETE CASCADE,
    CONSTRAINT fk_trato_tipo FOREIGN KEY (id_tipo)
        REFERENCES Tipo_Trato(id) ON DELETE CASCADE
);


CREATE SEQUENCE seq_especie
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE seq_trato
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE SEQUENCE seq_tipo_trato
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE OR REPLACE TRIGGER trg_especie_autoincrement
BEFORE INSERT ON Especie
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT seq_especie.NEXTVAL INTO :NEW.id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_trato_autoincrement
BEFORE INSERT ON Trato
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT seq_trato.NEXTVAL INTO :NEW.id FROM dual;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_tipo_trato_autoincrement
BEFORE INSERT ON Tipo_Trato
FOR EACH ROW
BEGIN
    IF :NEW.id IS NULL THEN
        SELECT seq_tipo_trato.NEXTVAL INTO :NEW.id FROM dual;
    END IF;
END;
/

