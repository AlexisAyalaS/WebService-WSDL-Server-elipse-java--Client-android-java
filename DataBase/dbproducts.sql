-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2016 a las 09:09:19
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dbproducts`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `RazonSocial` varchar(100) NOT NULL,
  `RFC` varchar(15) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `Estado` varchar(100) NOT NULL,
  `CP` varchar(10) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `RazonSocial`, `RFC`, `Direccion`, `Ciudad`, `Estado`, `CP`, `Telefono`, `Email`) VALUES
(1, 'EMPRESA S.A DE C:V', 'EMPR000000', 'Calle. Ejemplo', 'Municipio. Ejemplo', 'Mexico', '56615', '59712345', 'empresaejemplo@empresa.com'),
(2, 'EMPRESA S.A DE C:V', 'EMPR000000', 'Calle. Ejemplo', 'Municipio. Ejemplo', 'Mexico', '56615', '59712345', 'empresaejemplo@empresa.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Departamento` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Facturas_idFactura` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `Nombre`, `Apellidos`, `Departamento`, `Email`, `Telefono`, `Facturas_idFactura`) VALUES
(1, 'sergio', 'hernandez', 'ventas', 'serg@gmail.com', '59712344', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `idFactura` int(11) NOT NULL,
  `NumFactura` int(11) NOT NULL,
  `Fecha` datetime NOT NULL,
  `idCliente` int(11) NOT NULL,
  `SubTotal` float NOT NULL,
  `IVA` float NOT NULL,
  `Total` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`idFactura`, `NumFactura`, `Fecha`, `idCliente`, `SubTotal`, `IVA`, `Total`) VALUES
(1, 1, '2016-06-08 00:00:00', 1, 100, 16, 116);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturasdetalle`
--

CREATE TABLE `facturasdetalle` (
  `Facturas_idFactura` int(11) NOT NULL,
  `Productos_idProducto` int(11) NOT NULL,
  `PrecioUnitario` float NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioTotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturasdetalle`
--

INSERT INTO `facturasdetalle` (`Facturas_idFactura`, `Productos_idProducto`, `PrecioUnitario`, `Cantidad`, `PrecioTotal`) VALUES
(1, 1, 10, 2, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `UnidadMedida` varchar(45) NOT NULL,
  `PrecioUnitario` float NOT NULL,
  `UnidadesExistentes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `Nombre`, `Descripcion`, `UnidadMedida`, `PrecioUnitario`, `UnidadesExistentes`) VALUES
(1, 'coca-cola', 'bebida 600ml', 'ml', 10, 50),
(2, 'pepsi', 'bebida de dos litros', '2 litros', 20, 50),
(3, 'Gatorade', 'Bebida Energizante', '600ml', 15, 15),
(4, 'DogChow', 'Alimento para Perro Bajo en Grasa', '20Kg', 500, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD UNIQUE KEY `idEmpleado` (`idEmpleado`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`idFactura`);

--
-- Indices de la tabla `facturasdetalle`
--
ALTER TABLE `facturasdetalle`
  ADD PRIMARY KEY (`Facturas_idFactura`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `idFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `facturasdetalle`
--
ALTER TABLE `facturasdetalle`
  MODIFY `Facturas_idFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
