-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 08 sep. 2017 à 02:10
-- Version du serveur :  10.1.26-MariaDB
-- Version de PHP :  7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanquev4nvbc`
--

-- --------------------------------------------------------

--
-- Structure de la table `comptes`
--

CREATE TABLE `comptes` (
  `TYPE_COMPTE` varchar(31) NOT NULL,
  `ID` int(11) NOT NULL,
  `SOLDE` double DEFAULT NULL,
  `DATE_OUVERTURE` datetime DEFAULT NULL,
  `numeroAgence` varchar(255) DEFAULT NULL,
  `NUMERO_COMPTE` varchar(255) DEFAULT NULL,
  `TAUX_REMUNERATION` double DEFAULT NULL,
  `DECOUVERT` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptes`
--

INSERT INTO `comptes` (`TYPE_COMPTE`, `ID`, `SOLDE`, `DATE_OUVERTURE`, `numeroAgence`, `NUMERO_COMPTE`, `TAUX_REMUNERATION`, `DECOUVERT`) VALUES
('COMPTE_COURANT', 5, -620, '2017-09-07 23:52:04', 'PARIS12', 'FD-201787524-PARIS12-CC', NULL, 1000),
('COMPTE_EPARGNE', 6, 635, '2017-09-07 23:52:04', 'PARIS12', 'FD-201787524-PARIS12-CE', 0.03, NULL),
('COMPTE_COURANT', 7, 4165, '2017-09-08 00:51:14', 'PARIS12', 'CG-2017885114-PARIS12-CC', NULL, 1000),
('COMPTE_EPARGNE', 8, 450, '2017-09-08 00:51:14', 'PARIS12', 'CG-2017885114-PARIS12-CE', 0.03, NULL),
('COMPTE_COURANT', 9, 1000, '2017-09-08 01:03:22', 'PARIS12', 'DA-201788322-PARIS12-CC', NULL, 1000),
('COMPTE_EPARGNE', 10, 2700, '2017-09-08 01:03:22', 'PARIS12', 'DA-201788322-PARIS12-CE', 0.03, NULL),
('COMPTE_COURANT', 11, 1000, '2017-09-08 01:13:33', 'PARIS12', 'AG-2017881333-PARIS12-CC', NULL, 1000),
('COMPTE_EPARGNE', 12, 430, '2017-09-08 01:13:33', 'PARIS12', 'AG-2017881333-PARIS12-CE', 0.03, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

CREATE TABLE `personnes` (
  `TYPE_PERSONNE` varchar(31) NOT NULL,
  `ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `CODE_POSTAL` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NUMERO_RUE` int(11) DEFAULT NULL,
  `RUE` varchar(255) DEFAULT NULL,
  `TELEPHONE` varchar(255) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  `COMPTE_COURANT` int(11) DEFAULT NULL,
  `COMPTE_EPARGNE` int(11) DEFAULT NULL,
  `conseiller_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnes`
--

INSERT INTO `personnes` (`TYPE_PERSONNE`, `ID`, `FIRST_NAME`, `LAST_NAME`, `CODE_POSTAL`, `EMAIL`, `NUMERO_RUE`, `RUE`, `TELEPHONE`, `VILLE`, `COMPTE_COURANT`, `COMPTE_EPARGNE`, `conseiller_ID`) VALUES
('CLIENT', 3, 'delphine', 'FOLLIAUT', 75000, 'delphine_folliaut@outlook.com', 33, 'rue du stade', '0648952310', 'PARIS', 5, 6, NULL),
('CLIENT', 4, 'guillaume', 'CHAZARET', 75004, 'chaz-guillaume@gmail.com', 42, 'impasse du touch', '0532982570', 'PARIS', 7, 8, NULL),
('CLIENT', 5, 'adrien', 'DESCHAMPS', 75000, 'adrienDESCHAMPS@cnrs.fr', 18, 'avenue du colonnel niemen', '0295736412', 'PARIS', 9, 10, NULL),
('CLIENT', 6, 'germaine', 'ADELLINE', 75000, 'germaine75@hotmail.fr', 2, 'place de la mairie', '0187354298', 'PARIS', 11, 12, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `virements`
--

CREATE TABLE `virements` (
  `numOperation` bigint(20) NOT NULL,
  `DATE_OPERATION` datetime DEFAULT NULL,
  `MONTANT` double DEFAULT NULL,
  `COMPTE_CREDITEUR` varchar(255) DEFAULT NULL,
  `COMPTE_DEBITEUR` varchar(255) DEFAULT NULL,
  `NUMEROCOMPTE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `virements`
--

INSERT INTO `virements` (`numOperation`, `DATE_OPERATION`, `MONTANT`, `COMPTE_CREDITEUR`, `COMPTE_DEBITEUR`, `NUMEROCOMPTE`) VALUES
(1, '2017-09-08 00:14:30', 100, 'FD-201787524-PARIS12-CC', 'RN-2017875039-PARIS12-CC', NULL),
(2, '2017-09-08 01:44:02', 150, 'AG-2017881333-PARIS12-CC', 'FD-201787524-PARIS12-CC', NULL),
(3, '2017-09-08 01:46:00', 200, 'DA-201788322-PARIS12-CE', 'CG-2017885114-PARIS12-CC', NULL),
(4, '2017-09-08 01:47:23', 2000, 'CG-2017885114-PARIS12-CC', 'FD-201787524-PARIS12-CC', NULL),
(5, '2017-09-08 01:47:38', 0, 'CG-2017885114-PARIS12-CC', 'FD-201787524-PARIS12-CC', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `comptes`
--
ALTER TABLE `comptes`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `personnes`
--
ALTER TABLE `personnes`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_jklfoi8pqlukjgmr148wg9rk4` (`COMPTE_COURANT`),
  ADD KEY `FK_2vm8tcaswumpaxd8ke05j8goi` (`COMPTE_EPARGNE`),
  ADD KEY `FK_snqadihnlehbjier11lk9uqqh` (`conseiller_ID`);

--
-- Index pour la table `virements`
--
ALTER TABLE `virements`
  ADD PRIMARY KEY (`numOperation`),
  ADD KEY `FK_f7s2vesaq892w3dn6kauj749f` (`NUMEROCOMPTE`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `comptes`
--
ALTER TABLE `comptes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `personnes`
--
ALTER TABLE `personnes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `virements`
--
ALTER TABLE `virements`
  MODIFY `numOperation` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `personnes`
--
ALTER TABLE `personnes`
  ADD CONSTRAINT `FK_2vm8tcaswumpaxd8ke05j8goi` FOREIGN KEY (`COMPTE_EPARGNE`) REFERENCES `comptes` (`ID`),
  ADD CONSTRAINT `FK_jklfoi8pqlukjgmr148wg9rk4` FOREIGN KEY (`COMPTE_COURANT`) REFERENCES `comptes` (`ID`),
  ADD CONSTRAINT `FK_snqadihnlehbjier11lk9uqqh` FOREIGN KEY (`conseiller_ID`) REFERENCES `personnes` (`ID`);

--
-- Contraintes pour la table `virements`
--
ALTER TABLE `virements`
  ADD CONSTRAINT `FK_f7s2vesaq892w3dn6kauj749f` FOREIGN KEY (`NUMEROCOMPTE`) REFERENCES `comptes` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
