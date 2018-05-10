
CREATE TABLE T_Alquileres
(
	Cod_Alq              NUMBER NOT NULL ,
	Fec_Ent              DATE NULL ,
	Fec_Sal              DATE NULL ,
	Cos_Alq              INTEGER NULL ,
	Obs_Alq              VARCHAR2(80) NULL ,
	Hor_Sal              TIMESTAMP NULL ,
	Hor_Ent              TIMESTAMP NULL ,
	Cod_Hab              NUMBER NULL ,
	DNI_Cli              CHAR(8) NULL ,
	DNI_Reg              CHAR(8) NULL 
);



ALTER TABLE T_Alquileres
	ADD  PRIMARY KEY (Cod_Alq);



CREATE TABLE T_Cliente
(
	DNI_Cli              CHAR(8) NOT NULL ,
	Nom_Cli              VARCHAR2(50) NULL ,
	Ape_Cli              VARCHAR2(50) NULL ,
	idUbi                INTEGER NULL ,
	Dir_Cli              VARCHAR2(100) NULL 
);



ALTER TABLE T_Cliente
	ADD  PRIMARY KEY (DNI_Cli);



CREATE TABLE T_Habitaciones
(
	Cod_Hab              NUMBER NOT NULL ,
	Num_Hab              INTEGER NULL ,
	Est_Hab              CHAR(1) NULL ,
	Des_Est              VARCHAR2(80) NULL ,
	Cos_Hab              INTEGER NULL ,
	Des_Hab              VARCHAR2(80) NULL ,
	Cod_Tip              NUMBER NULL 
);



ALTER TABLE T_Habitaciones
	ADD  PRIMARY KEY (Cod_Hab);



CREATE TABLE T_Registrador
(
	DNI_Reg              CHAR(8) NOT NULL ,
	Nom_Reg              VARCHAR2(50) NULL ,
	Ape_Reg              VARCHAR2(50) NULL ,
	idUbi                INTEGER NULL 
);



ALTER TABLE T_Registrador
	ADD  PRIMARY KEY (DNI_Reg);



CREATE TABLE T_TipoHabitacion
(
	Cod_Tip              NUMBER NOT NULL ,
	Tip_Hab              VARCHAR2(80) NULL 
);



ALTER TABLE T_TipoHabitacion
	ADD  PRIMARY KEY (Cod_Tip);



CREATE TABLE Ubigeo
(
	idUbi                INTEGER NOT NULL ,
	DepUbi               VARCHAR2(50) NULL ,
	provUbi              VARCHAR2(50) NULL ,
	distUbi              VARCHAR2(50) NULL 
);



ALTER TABLE Ubigeo
	ADD  PRIMARY KEY (idUbi);



ALTER TABLE T_Alquileres
	ADD (FOREIGN KEY (Cod_Hab) REFERENCES T_Habitaciones (Cod_Hab) ON DELETE SET NULL);



ALTER TABLE T_Alquileres
	ADD (FOREIGN KEY (DNI_Cli) REFERENCES T_Cliente (DNI_Cli) ON DELETE SET NULL);



ALTER TABLE T_Alquileres
	ADD (FOREIGN KEY (DNI_Reg) REFERENCES T_Registrador (DNI_Reg) ON DELETE SET NULL);



ALTER TABLE T_Cliente
	ADD (FOREIGN KEY (idUbi) REFERENCES Ubigeo (idUbi) ON DELETE SET NULL);



ALTER TABLE T_Habitaciones
	ADD (FOREIGN KEY (Cod_Tip) REFERENCES T_TipoHabitacion (Cod_Tip) ON DELETE SET NULL);



ALTER TABLE T_Registrador
	ADD (FOREIGN KEY (idUbi) REFERENCES Ubigeo (idUbi) ON DELETE SET NULL);


