-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 30, 2021 at 11:36 AM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `DBGestion`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(10) NOT NULL,
  `nom_complet` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `nom_complet`, `login`, `password`) VALUES
(1, 'Youssef ELMOUMEN', 'youssef_elmoumen', 'youssef123');

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `date_naiss` date NOT NULL,
  `adresse` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`id`, `nom`, `prenom`, `date_naiss`, `adresse`) VALUES
(6, 'Youssef', 'ELMOUMEN', '1907-01-01', 'rabat'),
(56, 'eiofjowie', 'fweofojwe', '1900-01-01', 'efwefiewok'),
(112, 'oifoiwej', 'owjeoijfweoi', '1945-05-03', 'jocejfoewi'),
(102, 'ewjfiwe', 'oijweeoijfoeiw', '1900-01-01', 'Hahahahah'),
(11, 'AZZDIN', 'ALAMMAI', '2007-07-03', 'RBAR'),
(123, 'Youssef', 'ELMOUMEN', '1977-01-01', 'iefowjfeoiw'),
(654, 'oiwejof', 'oijfweoijfowe', '1900-01-01', 'iejjfowei'),
(394, 'eewjfoiew', 'jdofiwjfoew', '1900-01-01', 'oijfowifwq');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
