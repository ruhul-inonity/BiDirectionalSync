-- phpMyAdmin SQL Dump
-- version 4.0.10.14
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 29, 2016 at 04:23 PM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 5.6.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ruhulaza_volley_work`
--

-- --------------------------------------------------------

--
-- Table structure for table `bi_directional_sync`
--

CREATE TABLE IF NOT EXISTS `bi_directional_sync` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `phoneId` int(20) DEFAULT NULL,
  `Name` varchar(100) NOT NULL,
  `syncsts` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `bi_directional_sync`
--

INSERT INTO `bi_directional_sync` (`Id`, `phoneId`, `Name`, `syncsts`) VALUES
(1, 0, 'mr x', 1),
(2, 0, 'my y', 1),
(3, 0, 'ruhul', 1),
(4, 0, 'ino', 1),
(8, NULL, 'from Web', 1),
(7, NULL, 'yo', 1),
(9, NULL, 'hu ha', 1),
(10, NULL, 'chu chu', 1),
(11, 8, 'hell yeah', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
