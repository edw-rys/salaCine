-- se crea la base de datos 
CREATE database `salascine` ;

-- se crea la tabla de categoria pelicula en la base de datos salascine
CREATE TABLE `salascine`.`categoriapelicula` (
  `idCategoriaPelicula` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoriaPelicula`)
) ;

-- se inserta las cateogrias
INSERT INTO `salascine`.`categoriapelicula` VALUES (1,'COMEDIA'),(2,'ACCIÓN'),(3,'TERROR'),(4,'ROMANCE'),(5,'MUSICA'),(6,'MELODRAMA'),(7,'SUSPENSO'),(8,'HISTORICO'),(9,'BELICO'),(10,'POLICIACO'),(11,'EXPLOTACION'),(12,'CATASTROFE'),(13,'CINE MUDO'),(14,'CINE NEGRO'),(15,'INFANTIL'),(16,'ANIMADO'),(17,'CINE ARTE'),(18,'CINE INDEPENDIENTE'),(19,'CINE PARA ADULTOS');

-- se crea la tabla de la categoria de las salas
CREATE TABLE `salascine`.`categoriasala` (
  `idCategoriaSala` int(11) NOT NULL AUTO_INCREMENT,
  `nomre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoriaSala`)
) ;
-- se inserta valores
INSERT INTO `salascine`.`categoriasala` VALUES (1,'GENERAL'),(2,'VIP'),(3,'BLACKBOX');


CREATE TABLE `salascine`.`cliente` (
  `Cedula` varchar(15) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Cedula`)
);







CREATE TABLE `salascine`.`cmb_tipos_por_Sala` (
  `id` int(11) NOT NULL,
  `detalle` varchar(90) NOT NULL,
  `referencia_tipo_sala` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cmb_categoriasala1_idx` (`referencia_tipo_sala`),
  CONSTRAINT `fk_cmb_categoriasala1` FOREIGN KEY (`referencia_tipo_sala`) REFERENCES `salascine`.`categoriasala` (`idCategoriaSala`) ON DELETE NO ACTION ON UPDATE NO ACTION
);
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('1', 'SI', '1');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('2', 'NO', '1');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('3', 'Gafas pasivas', '2');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('4', 'Gafas activas', '2');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('5', 'De tejido', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('6', 'De tejido con repozacabezas', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('7', 'Con reposacabezas con reposa pies con mesita', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('8', 'Cuero de acero de polipropeno con reposacabezas', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('9', 'De poliuretano', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('10', 'Con reposa pies ', '3');
INSERT INTO `salascine`.`cmb_tipos_por_sala` (`id`, `detalle`, `referencia_tipo_sala`) VALUES ('11', 'De tejido ergonomica plegable', '3');


CREATE TABLE `salascine`.`sala` (
  `idsala` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(20) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `totalDiasReservados` int(11) NOT NULL,
  `precioHora` double NOT NULL,
  `IdCategoriaSala` int(11) NOT NULL,
  `estado`int(11) NOT NULL DEFAULT 1,
  `numero_reservaciones`int(11) NOT NULL DEFAULT 0,
  `atributo_sala1` varchar(90) ,
  `atributo_sala2` varchar(45) ,
  `imagen` varchar(100) ,
  `ganancias` double  NOT NULL default 0,
  PRIMARY KEY (`idsala`),
  KEY `fk_sala_categoriasala1_idx` (`IdCategoriaSala`),
  CONSTRAINT `fk_sala_categoriasala1` FOREIGN KEY (`IdCategoriaSala`) REFERENCES `salascine`.`categoriasala` (`idCategoriaSala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;




CREATE TABLE `salascine`.`horario` (
`idDia` int(11) NOT NULL AUTO_INCREMENT,
  `dia` varchar(10) NOT NULL,
  `hora_entrada` int(11) NOT NULL,
  `hora_salida` int(11) NOT NULL,
  `sala_IdSala` int(11) not NULL,
  `estado` int(11) default 1,
  PRIMARY KEY (`idDia`),
  KEY `fk_horario_sala1_idx` (`sala_IdSala`),
  CONSTRAINT `fk_horario_sala1` FOREIGN KEY (`sala_IdSala`) REFERENCES `salascine`.`sala` (`idsala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;




CREATE TABLE `salascine`.`pelicula` (
  `idpelicula` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `anio_estreno` varchar(45) NOT NULL,
  `calificacion` int(11) NOT NULL,
  `IdCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idpelicula`),
  KEY `fk_pelicula_ctg_idx` (`IdCategoria`),
  CONSTRAINT `fk_pelicula_ctg` FOREIGN KEY (`IdCategoria`) REFERENCES `salascine`.`categoriapelicula` (`idCategoriaPelicula`) ON DELETE NO ACTION ON UPDATE NO ACTION
);




CREATE TABLE `salascine`.`reservaciones` (
  `idreservaciones` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_reservacion` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `hora_entrada` int(11) NOT NULL,
  `hora_salida` int(11) NOT NULL,
  `precio_reservacion` double NOT NULL,
  `IdSala` int(11) NOT NULL,
  `IdPelicula` int(11) NOT NULL,
  `CedulaCliente` varchar(15) NOT NULL,
  `estado`int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`idreservaciones`),
  KEY `fk_reservaciones_sala1_idx` (`IdSala`),
  KEY `fk_reservaciones_pelicula1_idx` (`IdPelicula`),
  KEY `fk_reservaciones_cliente1_idx` (`CedulaCliente`),
  CONSTRAINT `fk_reservaciones_pelicula1` FOREIGN KEY (`IdPelicula`) REFERENCES `salascine`.`pelicula` (`idpelicula`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservaciones_sala1` FOREIGN KEY (`IdSala`) REFERENCES `salascine`.`sala` (`idsala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ;



INSERT INTO `salascine`.`sala` VALUES (1,'vip-1','edw',4,24.32,2,1,2,'Gafas pasivas','23','ninguna',90.5),(2,'blackbox-2','tm',4,313,3,0,0,'De tejido ergonomica plegable','Nel','ninguna',0),(3,'vip-3','TNX01',1,20.3,2,1,0,'Gafas pasivas','nel','ninguna',0),(4,'vip-4','m',2,55,2,1,0,'Gafas activas','','ninguna',0),(5,'blackbox-5','h',3,2,3,1,0,'De tejido','1','ninguna',0);
INSERT INTO `salascine`.`pelicula` VALUES (1,'SpiderMan','2012',4,2);
INSERT INTO `salascine`.`cliente` VALUES ('0953462544','edward','reyes','km 51 via costa','0988457240'),('0988457240','K','P','Paraiso de la flor','0988457240');
INSERT INTO `salascine`.`reservaciones` VALUES (1,'tim01','2018-08-21',13,15,30.2,1,1,'0953462544',1),(2,'kvp','2018-08-21',15,17,60.3,1,1,'0988457240',1);
INSERT INTO `salascine`.`horario` VALUES (1,'LUNES',8,10,1,0),(2,'MARTES',8,10,1,0),(3,'VIERNES',8,10,1,0),(4,'MARTES',8,10,2,0),(5,'MIERCOLES',8,10,2,0),(6,'LUNES',8,10,1,0),(7,'MARTES',8,10,1,0),(8,'MIERCOLES',8,10,1,0),(9,'JUEVES',8,10,1,0),(10,'VIERNES',8,10,1,0),(11,'MARTES',8,10,2,0),(12,'MIERCOLES',8,10,2,0),(13,'MARTES',8,10,2,0),(14,'MIERCOLES',8,10,2,0),(15,'MARTES',3,9,2,0),(16,'MIERCOLES',12,18,2,0),(17,'MARTES',3,9,2,0),(18,'VIERNES',12,22,2,0),(19,'SABADO',12,13,2,0),(20,'DOMINGO',12,22,2,0),(21,'MARTES',11,12,3,0),(22,'MIERCOLES',10,11,3,0),(23,'SABADO',21,22,3,0),(24,'LUNES',8,10,2,0),(25,'MARTES',3,9,2,0),(26,'MIERCOLES',8,10,2,0),(27,'JUEVES',8,10,2,0),(28,'VIERNES',12,13,2,0),(29,'SABADO',12,13,2,0),(30,'SABADO',8,10,1,0),(31,'DOMINGO',8,10,1,0),(32,'LUNES',8,10,3,1),(33,'LUNES',8,10,2,0),(34,'MARTES',3,9,2,0),(35,'MIERCOLES',8,10,2,0),(36,'LUNES',8,10,2,0),(37,'MARTES',3,9,2,0),(38,'MIERCOLES',8,10,2,0),(39,'VIERNES',8,10,2,0),(40,'LUNES',8,10,2,1),(41,'MARTES',3,9,2,1),(42,'MIERCOLES',8,10,2,1),(43,'VIERNES',8,10,2,1),(44,'MARTES',8,10,4,1),(45,'MIERCOLES',8,10,4,1),(46,'LUNES',8,10,1,0),(47,'MARTES',8,10,1,0),(48,'JUEVES',8,10,1,0),(49,'SABADO',8,10,1,0),(50,'DOMINGO',8,10,1,0),(51,'MARTES',8,10,5,1),(52,'MIERCOLES',8,10,5,1),(53,'JUEVES',8,10,5,1),(54,'LUNES',8,10,1,0),(55,'MARTES',8,10,1,0),(56,'JUEVES',8,10,1,0),(57,'SABADO',8,10,1,0),(58,'DOMINGO',8,10,1,0),(59,'LUNES',12,23,1,1),(60,'MARTES',13,23,1,1),(61,'SABADO',18,23,1,1),(62,'DOMINGO',3,10,1,1);
