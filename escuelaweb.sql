use EscuelaWeb;

DROP TABLE IF EXISTS Alumno;
DROP TABLE IF EXISTS Carrera;

CREATE TABLE Carrera (
  idCarrera int(10) NOT NULL AUTO_INCREMENT,
  nombreCarrera varchar(50) NOT NULL,
  descripcionCarrera varchar(50) NOT NULL,
  PRIMARY KEY (idCarrera)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE Alumno (
  idAlumno int(10) NOT NULL AUTO_INCREMENT,
  nombreAlumno varchar(50) DEFAULT NULL,
  paternoAlumno varchar(50) DEFAULT NULL,
  maternoAlumno varchar(50) DEFAULT NULL,
  emailAlumno varchar(50) DEFAULT NULL,
  idCarrera int(10) DEFAULT NULL,
  PRIMARY KEY (idAlumno),
  KEY idCarrera (idCarrera),
  FOREIGN KEY (idCarrera) REFERENCES carrera (idCarrera) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO Carrera(nombreCarrera,descripcionCarrera)
	VALUES
		('LCD 2020','Datos'),
        ('ISC 2009	','Sistemas');

INSERT INTO Alumno(nombreAlumno,paternoAlumno,maternoAlumno,emailAlumno,idCarrera) 
	VALUES
		('Alberto','Peña','Atanasio','a@gmail.com',1),
        ('José','Asunción ','Zárate','zaj@gmail.com',2);