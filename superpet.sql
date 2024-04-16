-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para superpet
CREATE DATABASE IF NOT EXISTS `superpet` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `superpet`;

-- Volcando estructura para tabla superpet.clientes
CREATE TABLE IF NOT EXISTS `clientes` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla superpet.clientes: ~13 rows (aproximadamente)
INSERT INTO `clientes` (`dni`, `nombre`, `apellidos`, `direccion`, `telefono`, `correo`) VALUES
	('01234567', 'Isabel', 'Jiménez', 'Calle N, 987', '99074567', 'isabel@gmail.com'),
	('12345678', 'Lucas', 'Molina', 'Calle O, 654', '99075678', 'lucas@gmail.com'),
	('23456789', 'Patricia', 'Navarro', 'Calle P, 321', '99076789', 'patricia@gmail.com'),
	('34567890', 'Francisco', 'Ruiz', 'Calle Q, 876', '99077890', 'francisco@gmail.com'),
	('45678901', 'Laura', 'Hernández', 'Calle H, 321', '99078901', 'laura@gmail.com'),
	('54321678', 'Ana', 'López', 'Calle D, 321', '99074567', 'ana@gmail.com'),
	('56789012', 'Pedro', 'Ramírez', 'Calle E, 654', '99075678', 'pedro@gmail.com'),
	('67890123', 'Elena', 'Vargas', 'Calle J, 543', '99070123', 'elena@gmail.com'),
	('78901234', 'Roberto', 'Ramos', 'Calle K, 210', '99071234', 'roberto@gmail.com'),
	('87654321', 'María', 'González', 'Calle B, 456', '99072345', 'maria@gmail.com'),
	('89012345', 'Marta', 'Sánchez', 'Calle L, 765', '99072345', 'marta@gmail.com'),
	('90123456', 'Antonio', 'Torres', 'Calle M, 432', '99073456', 'antonio@gmail.com'),
	('98765432', 'Luis', 'Martínez', 'Calle C, 789', '99073456', 'luis@gmail.com');

-- Volcando estructura para tabla superpet.historias_clinicas
CREATE TABLE IF NOT EXISTS `historias_clinicas` (
  `id_historia` int NOT NULL AUTO_INCREMENT,
  `id_mascota` int DEFAULT NULL,
  `fecha_consulta` date DEFAULT NULL,
  `diagnostico` text,
  `tratamiento` text,
  PRIMARY KEY (`id_historia`),
  KEY `id_mascota` (`id_mascota`),
  CONSTRAINT `historias_clinicas_ibfk_1` FOREIGN KEY (`id_mascota`) REFERENCES `mascotas` (`id_mascota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla superpet.historias_clinicas: ~0 rows (aproximadamente)

-- Volcando estructura para tabla superpet.horarios
CREATE TABLE IF NOT EXISTS `horarios` (
  `idhorario` int NOT NULL AUTO_INCREMENT,
  `idveterinario` int NOT NULL,
  `dia` varchar(100) NOT NULL,
  `horainicio` time DEFAULT NULL,
  `horafin` time DEFAULT NULL,
  PRIMARY KEY (`idhorario`),
  KEY `idveterinario` (`idveterinario`),
  CONSTRAINT `horarios_ibfk_1` FOREIGN KEY (`idveterinario`) REFERENCES `veterinario` (`idveterinario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla superpet.horarios: ~7 rows (aproximadamente)
INSERT INTO `horarios` (`idhorario`, `idveterinario`, `dia`, `horainicio`, `horafin`) VALUES
	(1, 1, 'Lunes', '09:00:00', '12:00:00'),
	(2, 1, 'Martes', '14:00:00', '17:00:00'),
	(3, 2, 'Miercoles', '08:00:00', '11:00:00'),
	(4, 2, 'Jueves', '13:00:00', '16:00:00'),
	(5, 3, 'Viernes', '10:00:00', '13:00:00'),
	(6, 4, 'Sabado', '09:30:00', '12:30:00'),
	(7, 5, 'Domingo', '14:30:00', '17:30:00'),
	(8, 7, '1', '09:06:00', '13:06:00'),
	(9, 7, '1', '09:06:00', '13:06:00');

-- Volcando estructura para tabla superpet.mascotas
CREATE TABLE IF NOT EXISTS `mascotas` (
  `id_mascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `raza` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `dni_cliente` varchar(8) NOT NULL,
  `observacion` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `dni_cliente` (`dni_cliente`),
  CONSTRAINT `mascotas_ibfk_1` FOREIGN KEY (`dni_cliente`) REFERENCES `clientes` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla superpet.mascotas: ~0 rows (aproximadamente)
INSERT INTO `mascotas` (`id_mascota`, `nombre`, `raza`, `fecha_nacimiento`, `dni_cliente`, `observacion`) VALUES
	(1, 'walter', 'poodle', '2023-12-04', '12345678', 'alegico al pollo');

-- Volcando estructura para tabla superpet.reserva_citas
CREATE TABLE IF NOT EXISTS `reserva_citas` (
  `id_cita` int NOT NULL AUTO_INCREMENT,
  `dni_cliente` varchar(8) NOT NULL,
  `id_mascota` int NOT NULL,
  `fecha_cita` date DEFAULT NULL,
  `motivo` text,
  PRIMARY KEY (`id_cita`),
  KEY `dni_cliente` (`dni_cliente`),
  KEY `id_mascota` (`id_mascota`),
  CONSTRAINT `reserva_citas_ibfk_1` FOREIGN KEY (`dni_cliente`) REFERENCES `clientes` (`dni`),
  CONSTRAINT `reserva_citas_ibfk_2` FOREIGN KEY (`id_mascota`) REFERENCES `mascotas` (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla superpet.reserva_citas: ~0 rows (aproximadamente)
INSERT INTO `reserva_citas` (`id_cita`, `dni_cliente`, `id_mascota`, `fecha_cita`, `motivo`) VALUES
	(4, '12345678', 1, '2023-12-15', 'manchas rojas');

-- Volcando estructura para tabla superpet.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `clave` varchar(20) DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla superpet.usuarios: ~0 rows (aproximadamente)
INSERT INTO `usuarios` (`id_usuario`, `nombre`, `apellidos`, `usuario`, `clave`, `tipo`, `estado`) VALUES
	(1, 'walter', 'Sulca', 'admin', 'admin', 1, 1);

-- Volcando estructura para tabla superpet.veterinario
CREATE TABLE IF NOT EXISTS `veterinario` (
  `idveterinario` int NOT NULL AUTO_INCREMENT,
  `nombresveterinario` varchar(100) NOT NULL,
  `apellidosveterinario` varchar(50) NOT NULL,
  `aniosexperiencia` int NOT NULL,
  `telefono` varchar(10) DEFAULT '',
  `correo` varchar(100) DEFAULT '',
  `nrocolegiatura` int NOT NULL,
  `puesto` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idveterinario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla superpet.veterinario: ~5 rows (aproximadamente)
INSERT INTO `veterinario` (`idveterinario`, `nombresveterinario`, `apellidosveterinario`, `aniosexperiencia`, `telefono`, `correo`, `nrocolegiatura`, `puesto`) VALUES
	(1, 'Ana', 'Garcia', 5, '1234567890', 'ana@example.com', 12345, 'Veterinario General'),
	(2, 'Maria', 'Lopez', 10, '0987654321', 'maria@example.com', 54321, 'Cirujano Veterinario'),
	(3, 'Jose', 'Perez', 15, '9876543210', 'jose@example.com', 98765, 'Anestesiologo Veterinario'),
	(4, 'Luis', 'Martinez', 20, '1234567890', 'luis@example.com', 43210, 'Oftalmologo Veterinario'),
	(5, 'Pedro', 'Gonzalez', 25, '0987654321', 'pedro@example.com', 12345, 'Cardiólogo Veterinario'),
	(7, 'walter editado', 'sulca', 1, '923438508', 'sulcallallahui@gmail.com', 4, 'Medico Veterinario');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
