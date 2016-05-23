-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2016 a las 23:29:02
-- Versión del servidor: 10.0.17-MariaDB
-- Versión de PHP: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jguerrero`
--
CREATE DATABASE IF NOT EXISTS `jguerrero` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `jguerrero`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE IF NOT EXISTS `alumno` (
  `numMatricular` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido1` varchar(50) NOT NULL,
  `apellido2` varchar(50) NOT NULL,
  `horaAlta` varchar(50) NOT NULL,
  `horaModificacion` varchar(50) NOT NULL,
  `dni` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`numMatricular`, `nombre`, `apellido1`, `apellido2`, `horaAlta`, `horaModificacion`, `dni`) VALUES
(10001, 'Francisco Javier', 'Primero ', 'Primero ', '13/12/2015 13:23:32', '13/12/2015 13:23:32', '31000001A'),
(10002, 'Abel ', 'Primero ', 'Segundo', '13/12/2015 13:23:32', '13/12/2015 13:23:32', '31000002A'),
(10003, 'Inmaculada  ', 'Primero ', 'Tercero', '13/12/2015 13:23:40', '13/12/2015 14:23:32', '31000003A'),
(10004, 'Fernando', 'Primero ', 'Cuarto', '13/12/2015 13:23:32', '15/12/2015 13:23:32', '31000004U'),
(10005, 'José Luis ', 'Primero ', 'Quinto', '13/12/2015 13:23:32', '16/12/2015 13:23:32', '31000005V'),
(10006, 'Gabriel ', 'Segundo', 'Primero ', '13/12/2015 14:23:32', '18/12/2015 13:23:32', '31000006X'),
(10007, 'José Antonio ', 'Segundo', 'Segundo', '13/12/2015 11:23:32', '19/12/2015 13:23:32', '31000007A'),
(10008, 'Óscar ', 'Segundo', 'Cuarto', '13/12/2015 13:23:32', '13/12/2015 17:23:32', '31000008J'),
(10009, 'Javier ', 'Segundo', 'Tercero', '13/12/2015 13:23:34', '13/12/2015 16:23:32', '31000009P'),
(10010, 'Clemente ', 'Tercero', 'Segundo', '13/12/2015 13:23:33', '13/12/2015 17:23:32', '31000010C'),
(10011, 'Ignacio ', 'Tercero', 'Tercero', '13/12/2015 13:23:31', '13/12/2015 18:23:32', '31000011A'),
(10012, 'José Luis ', 'Tercero', 'Primero ', '13/12/2015 13:23:31', '13/12/2015 19:23:32', '32000002B'),
(10013, 'Ezequiel', 'Guerrero', 'Lopez', '13/02/2016 20:45:28', '13/02/2016 20:45:28', '23456623D'),
(10014, 'José Salvador  ', 'Ruiz', 'Palma', '13/02/2016 20:48:28', '13/02/2016 20:48:28', '23325445A'),
(10015, 'Antonio  ', 'Toro', 'Luna', '13/02/2016 21:01:29', '13/02/2016 21:01:29', '12545361T');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
