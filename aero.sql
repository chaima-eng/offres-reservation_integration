-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 23 oct. 2021 à 17:09
-- Version du serveur : 10.4.19-MariaDB
-- Version de PHP : 7.4.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `aero_space`
--
CREATE DATABASE IF NOT EXISTS `aero_space` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `aero_space`;

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `idCli` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `detail_reservation`
--

CREATE TABLE `detail_reservation` (
  `idR` varchar(255) NOT NULL,
  `idRes` varchar(255) NOT NULL,
  `idoffre` varchar(255) NOT NULL,
  `idCli` varchar(255) NOT NULL,
  `idevent` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

CREATE TABLE `events` (
  `idevent` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `period` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `available` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`idevent`, `name`, `period`, `location`, `date`, `available`) VALUES
('ffh', 'asd', 'asd', 'zxc', '2021-10-13', '777'),
('gggg', 'asd', 'asd', 'cccccccc', '2021-10-13', 'ccccc'),
('lll', 'asd', 'asd', 'zxc', '2021-10-13', '777'),
('tt', 'rrr', 'ggg', 'fff', '2021-11-03', 'nnnn');

-- --------------------------------------------------------

--
-- Structure de la table `factures_clients`
--

CREATE TABLE `factures_clients` (
  `id_Fac` varchar(42) NOT NULL,
  `nom_client` varchar(42) NOT NULL,
  `date_fac` date NOT NULL,
  `reglement_fac` varchar(42) NOT NULL,
  `etat_fac` varchar(42) NOT NULL,
  `TVA_fac` int(42) NOT NULL,
  `remise_fac` int(42) NOT NULL,
  `NB_fac` varchar(42) NOT NULL,
  `Table_fac` int(42) NOT NULL,
  `idR` int(42) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `fruit`
--

CREATE TABLE `fruit` (
  `idF` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `imgSrc` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `color` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `fruit`
--

INSERT INTO `fruit` (`idF`, `name`, `imgSrc`, `price`, `color`, `date`) VALUES
('1', 'Kiwi', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\kiwi.png', 55.2, '6A7324', '2021-10-01'),
('10', 'Banana', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\banana.png', 100, 'E7C00F', '2021-10-17'),
('2', 'Coconut', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\coconut.png', 4.6, 'A7745B', '2021-10-23'),
('3', 'Peach', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\peach.png', 85.3, 'F16C31', '2021-10-31'),
('4', 'Grapes', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\grapes.png', 14.6, '291D36', '2021-10-21'),
('5', 'Watermelon', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\peach.png', 58.7, '22371D', '2021-10-23'),
('6', 'Orange', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\grapes.png', 44, 'FB5D03', '2021-10-19'),
('7', 'StrawBerry', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\strawBerry.png', 12, '80080C', '2021-10-18'),
('8', 'Mango', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\watermelon.png', 88, 'FFB605', '2021-10-30'),
('9', 'Cherry', 'C:\\Users\\LEGION-5\\Downloads\\Compressed\\Fruits-Market-master\\Fruits-Market-master\\FruitMarket\\src\\img\\orange.png', 55.3, '5F060E', '2021-10-21');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `idH` varchar(255) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `etoile` int(100) NOT NULL,
  `hebergement` varchar(100) NOT NULL,
  `lieu` varchar(100) NOT NULL,
  `Path_image` varchar(255) NOT NULL,
  `Path_video` varchar(255) NOT NULL,
  `chambre` varchar(100) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hotel`
--

INSERT INTO `hotel` (`idH`, `nom`, `etoile`, `hebergement`, `lieu`, `Path_image`, `Path_video`, `chambre`, `prix`) VALUES
('0', 'dad', 252, 'okop', 'zad', 'C:UsersBadis KhalsiDocumentsCapture d’écran 2021-09-11 123210.png', 'C:UsersBadis KhalsiVideosCapturesIonic App - Opera 2021-09-27 20-09-18.mp4', '', 0),
('1', 'bb', 2, 'aaa', 'sousse', 'C:UsersBadis KhalsiPictures\0004.jpg', 'C:UsersBadis KhalsiVideosCapturesIonic App - Opera 2021-09-27 20-09-18.mp4', 'Single/ ', 0),
('12', 'Badis', 2, 'hahah', 'soussse', '0', '0', '', 0),
('1215', 'baada', 252, 'fezf', 'zefze', 'C:UsersBadis KhalsiPictureshotel.PNG', 'C:UsersBadis KhalsiVideosCapturesIonic App - Opera 2021-09-27 20-09-18.mp4', 'Chambre Quadriple Chambre Single ', 0),
('1262', 'baada', 252, 'fezf', 'zefze', 'C:UsersBadis KhalsiPictureshotel.PNG', 'C:UsersBadis KhalsiVideosCapturesIonic App - Opera 2021-09-27 20-09-18.mp4', 'Chambre Triple ', 0),
('5', 'tunis', 5, 'toto', 'bizerte', 'C:\\Users\\LEGION-5\\Downloads\\HackerLogo.png', 'tttttttttt', 'individual ', 1540),
('555', 'ffff', 2, 'fefe', 'tun', '0', '0', '', 0),
('99', 'dvd', 898, 'sds', 'fvds', '0', '0', '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `offre`
--

CREATE TABLE `offre` (
  `idoffre` varchar(255) NOT NULL,
  `id_reservation` varchar(255) NOT NULL,
  `Titre` varchar(255) NOT NULL,
  `date_validite` date NOT NULL,
  `taux_de_remise` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `Path_image` varchar(255) NOT NULL,
  `Path_video` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `offre`
--

INSERT INTO `offre` (`idoffre`, `id_reservation`, `Titre`, `date_validite`, `taux_de_remise`, `description`, `Path_image`, `Path_video`) VALUES
('99', '1', 'tunis', '2021-10-21', 30, 'hobiiiiii', 'asd', 'sss');

-- --------------------------------------------------------

--
-- Structure de la table `resevation`
--

CREATE TABLE `resevation` (
  `idRes` varchar(255) NOT NULL,
  `idH` varchar(255) NOT NULL,
  `referance` varchar(255) NOT NULL,
  `numv` varchar(255) NOT NULL,
  `idF` varchar(255) NOT NULL,
  `dateValidation` date NOT NULL,
  `etat` varchar(200) NOT NULL,
  `pos_map` varchar(255) NOT NULL,
  `prixT` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `resevation`
--

INSERT INTO `resevation` (`idRes`, `idH`, `referance`, `numv`, `idF`, `dateValidation`, `etat`, `pos_map`, `prixT`) VALUES
('1', '99', 'test', 'tunis', '8', '2021-10-07', 'bonne', 'wwwwww', 1500);

-- --------------------------------------------------------

--
-- Structure de la table `transport`
--

CREATE TABLE `transport` (
  `reference` varchar(255) NOT NULL,
  `typee` varchar(255) NOT NULL,
  `availability` varchar(255) NOT NULL,
  `driver` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `nomv` varchar(255) NOT NULL,
  `numv` varchar(255) NOT NULL,
  `dated` date NOT NULL,
  `datea` date NOT NULL,
  `chauffeur` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`idCli`),
  ADD KEY `idCli` (`idCli`),
  ADD KEY `idCli_2` (`idCli`);

--
-- Index pour la table `detail_reservation`
--
ALTER TABLE `detail_reservation`
  ADD PRIMARY KEY (`idR`),
  ADD UNIQUE KEY `idRes` (`idRes`),
  ADD UNIQUE KEY `idoffre` (`idoffre`),
  ADD UNIQUE KEY `idCli` (`idCli`),
  ADD UNIQUE KEY `idevent` (`idevent`);

--
-- Index pour la table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`idevent`),
  ADD KEY `idevent` (`idevent`);

--
-- Index pour la table `factures_clients`
--
ALTER TABLE `factures_clients`
  ADD PRIMARY KEY (`id_Fac`),
  ADD UNIQUE KEY `idR` (`idR`);

--
-- Index pour la table `fruit`
--
ALTER TABLE `fruit`
  ADD PRIMARY KEY (`idF`);

--
-- Index pour la table `hotel`
--
ALTER TABLE `hotel`
  ADD PRIMARY KEY (`idH`),
  ADD KEY `idH` (`idH`);

--
-- Index pour la table `offre`
--
ALTER TABLE `offre`
  ADD PRIMARY KEY (`idoffre`),
  ADD KEY `id_reservation` (`id_reservation`);

--
-- Index pour la table `resevation`
--
ALTER TABLE `resevation`
  ADD PRIMARY KEY (`idRes`),
  ADD UNIQUE KEY `idH` (`idH`),
  ADD KEY `idH_2` (`idH`),
  ADD KEY `referance` (`referance`),
  ADD KEY `numv` (`numv`),
  ADD KEY `idH_3` (`idH`),
  ADD KEY `idCli` (`idF`),
  ADD KEY `idRes` (`idRes`);

--
-- Index pour la table `transport`
--
ALTER TABLE `transport`
  ADD PRIMARY KEY (`reference`),
  ADD KEY `reference` (`reference`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`numv`),
  ADD UNIQUE KEY `numv` (`numv`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `offre`
--
ALTER TABLE `offre`
  ADD CONSTRAINT `offre_ibfk_1` FOREIGN KEY (`id_reservation`) REFERENCES `resevation` (`idRes`);

--
-- Contraintes pour la table `resevation`
--
ALTER TABLE `resevation`
  ADD CONSTRAINT `resevation_ibfk_7` FOREIGN KEY (`idH`) REFERENCES `hotel` (`idH`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
