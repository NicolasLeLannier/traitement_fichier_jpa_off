-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 26, 2023 at 03:31 PM
-- Server version: 5.7.11
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `open-food-facts`
--

-- --------------------------------------------------------

--
-- Table structure for table `additif`
--

CREATE TABLE `additif` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `allergene`
--

CREATE TABLE `allergene` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marque`
--

CREATE TABLE `marque` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nutrition_grade` varchar(255) DEFAULT NULL,
  `presence_huile_palme` bit(1) DEFAULT NULL,
  `ID_CATEGORIE` int(11) DEFAULT NULL,
  `ID_VALEUR_NUTRITIONNELLE` int(11) DEFAULT NULL,
  `ID_VITAMINE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_additif`
--

CREATE TABLE `produit_additif` (
  `ID_PRODUIT` int(11) NOT NULL,
  `ID_ADDITIF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_allergene`
--

CREATE TABLE `produit_allergene` (
  `ID_PRODUIT` int(11) NOT NULL,
  `ID_ALLERGENE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_ingredient`
--

CREATE TABLE `produit_ingredient` (
  `ID_PRODUIT` int(11) NOT NULL,
  `ID_INGREDIENT` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_marque`
--

CREATE TABLE `produit_marque` (
  `ID_PRODUIT` int(11) NOT NULL,
  `ID_MARQUE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `valeurnutrionnelle`
--

CREATE TABLE `valeurnutrionnelle` (
  `id` int(11) NOT NULL,
  `betaCarotene100g` double NOT NULL,
  `calcium100g` double NOT NULL,
  `energie100g` int(11) NOT NULL,
  `fer100g` double NOT NULL,
  `fibres100g` double NOT NULL,
  `graisse100g` double NOT NULL,
  `iron100g` double NOT NULL,
  `magnesium100g` double NOT NULL,
  `proteines100g` double NOT NULL,
  `sel100g` double NOT NULL,
  `sucres100g` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `vitamine`
--

CREATE TABLE `vitamine` (
  `id` int(11) NOT NULL,
  `vitA100g` double NOT NULL,
  `vitB12100g` double NOT NULL,
  `vitB1j100g` double NOT NULL,
  `vitB2100g` double NOT NULL,
  `vitB6100g` double NOT NULL,
  `vitB9100g` double NOT NULL,
  `vitC100g` double NOT NULL,
  `vitD100g` double NOT NULL,
  `vitE100g` double NOT NULL,
  `vitK100g` double NOT NULL,
  `vitPP100g` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `additif`
--
ALTER TABLE `additif`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `allergene`
--
ALTER TABLE `allergene`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsnumv95n9d01cv552ep25ypoj` (`ID_CATEGORIE`),
  ADD KEY `FK4gb1bm3i4xpqatxrf7ifqwx3j` (`ID_VALEUR_NUTRITIONNELLE`),
  ADD KEY `FKmtkdrchfklxk45hwqwt23mg95` (`ID_VITAMINE`);

--
-- Indexes for table `produit_additif`
--
ALTER TABLE `produit_additif`
  ADD KEY `FKom63mkcrytv1h3kug0ffj5y5q` (`ID_ADDITIF`),
  ADD KEY `FKrvi1q8269ilh8xfgmc7e7mddm` (`ID_PRODUIT`);

--
-- Indexes for table `produit_allergene`
--
ALTER TABLE `produit_allergene`
  ADD KEY `FKi4eyk3ohffevpax3j3olup2l0` (`ID_ALLERGENE`),
  ADD KEY `FKsooggxw7h8pk51c26qsg505p` (`ID_PRODUIT`);

--
-- Indexes for table `produit_ingredient`
--
ALTER TABLE `produit_ingredient`
  ADD KEY `FKtaik6isdoinyicy3b3kcaiy9u` (`ID_INGREDIENT`),
  ADD KEY `FKdcjsnbvgd70m9rkht5ernnn09` (`ID_PRODUIT`);

--
-- Indexes for table `produit_marque`
--
ALTER TABLE `produit_marque`
  ADD KEY `FK1ssg9nbw2n1w4thdthlk538be` (`ID_MARQUE`),
  ADD KEY `FK5ffwl5it2nbbe3b8mp6jdnim8` (`ID_PRODUIT`);

--
-- Indexes for table `valeurnutrionnelle`
--
ALTER TABLE `valeurnutrionnelle`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vitamine`
--
ALTER TABLE `vitamine`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `additif`
--
ALTER TABLE `additif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `allergene`
--
ALTER TABLE `allergene`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `marque`
--
ALTER TABLE `marque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `valeurnutrionnelle`
--
ALTER TABLE `valeurnutrionnelle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `vitamine`
--
ALTER TABLE `vitamine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK4gb1bm3i4xpqatxrf7ifqwx3j` FOREIGN KEY (`ID_VALEUR_NUTRITIONNELLE`) REFERENCES `valeurnutrionnelle` (`id`),
  ADD CONSTRAINT `FKmtkdrchfklxk45hwqwt23mg95` FOREIGN KEY (`ID_VITAMINE`) REFERENCES `vitamine` (`id`),
  ADD CONSTRAINT `FKsnumv95n9d01cv552ep25ypoj` FOREIGN KEY (`ID_CATEGORIE`) REFERENCES `categorie` (`id`);

--
-- Constraints for table `produit_additif`
--
ALTER TABLE `produit_additif`
  ADD CONSTRAINT `FKom63mkcrytv1h3kug0ffj5y5q` FOREIGN KEY (`ID_ADDITIF`) REFERENCES `additif` (`id`),
  ADD CONSTRAINT `FKrvi1q8269ilh8xfgmc7e7mddm` FOREIGN KEY (`ID_PRODUIT`) REFERENCES `produit` (`id`);

--
-- Constraints for table `produit_allergene`
--
ALTER TABLE `produit_allergene`
  ADD CONSTRAINT `FKi4eyk3ohffevpax3j3olup2l0` FOREIGN KEY (`ID_ALLERGENE`) REFERENCES `allergene` (`id`),
  ADD CONSTRAINT `FKsooggxw7h8pk51c26qsg505p` FOREIGN KEY (`ID_PRODUIT`) REFERENCES `produit` (`id`);

--
-- Constraints for table `produit_ingredient`
--
ALTER TABLE `produit_ingredient`
  ADD CONSTRAINT `FKdcjsnbvgd70m9rkht5ernnn09` FOREIGN KEY (`ID_PRODUIT`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `FKtaik6isdoinyicy3b3kcaiy9u` FOREIGN KEY (`ID_INGREDIENT`) REFERENCES `ingredient` (`id`);

--
-- Constraints for table `produit_marque`
--
ALTER TABLE `produit_marque`
  ADD CONSTRAINT `FK1ssg9nbw2n1w4thdthlk538be` FOREIGN KEY (`ID_MARQUE`) REFERENCES `marque` (`id`),
  ADD CONSTRAINT `FK5ffwl5it2nbbe3b8mp6jdnim8` FOREIGN KEY (`ID_PRODUIT`) REFERENCES `produit` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
