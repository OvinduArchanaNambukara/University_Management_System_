-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 30, 2020 at 12:51 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university_management_system`
--
drop database if exists university_management_system;
create database university_management_system;
use university_management_system;
-- --------------------------------------------------------

--
-- Table structure for table `lecture_course`
--

DROP TABLE IF EXISTS `lecture_course`;
CREATE TABLE IF NOT EXISTS `lecture_course` (
  `user_name` varchar(30) NOT NULL,
  `course_id` varchar(12) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecture_signup`
--

DROP TABLE IF EXISTS `lecture_signup`;
CREATE TABLE IF NOT EXISTS `lecture_signup` (
  `First_Name` varchar(15) NOT NULL,
  `Last_Name` varchar(15) NOT NULL,
  `User_name` varchar(60) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Age` varchar(6) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Lecture_ID` varchar(30) NOT NULL,
  PRIMARY KEY (`User_name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
CREATE TABLE IF NOT EXISTS `student_course` (
  `user_name` varchar(30) NOT NULL,
  `course_id` varchar(12) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_signup`
--

DROP TABLE IF EXISTS `student_signup`;
CREATE TABLE IF NOT EXISTS `student_signup` (
  `First_Name` varchar(15) NOT NULL,
  `Last_Name` varchar(15) NOT NULL,
  `User_Name` varchar(60) NOT NULL,
  `Pasword` varchar(60) NOT NULL,
  `Age` varchar(15) NOT NULL,
  `Student_NO` varchar(15) NOT NULL,
  `Email` varchar(30) NOT NULL,
  PRIMARY KEY (`User_Name`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='student sign up details';
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
