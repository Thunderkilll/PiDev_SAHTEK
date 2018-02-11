-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 11 Février 2018 à 17:10
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `carte_service`
--

CREATE TABLE `carte_service` (
  `id_carte_service` int(11) NOT NULL,
  `num_carte_service` int(8) NOT NULL,
  `specialite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `centre`
--

CREATE TABLE `centre` (
  `id_centre` int(20) NOT NULL,
  `nom_centre` varchar(11) NOT NULL,
  `adresse_centre` varchar(20) NOT NULL,
  `telephone` int(8) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `id_produit` int(69) NOT NULL,
  `categories` enum('BeauteEsthetique','Soin','RemiseEnForme','Reeducation','Sport') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hopital`
--

CREATE TABLE `hopital` (
  `id_hopital` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `type` enum('general','specialisées','universitaires','clinique') DEFAULT NULL,
  `coodonnees` varchar(500) NOT NULL,
  `image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `hopital_service`
--

CREATE TABLE `hopital_service` (
  `id_hopital` int(11) NOT NULL,
  `id_s` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `maladies`
--

CREATE TABLE `maladies` (
  `nom` varchar(50) NOT NULL,
  `symptomes` text NOT NULL,
  `description` text NOT NULL,
  `user` enum('medecin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `id_medicament` int(11) NOT NULL,
  `nom_medicament` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `nom_labo` varchar(50) NOT NULL,
  `user` enum('pharmacien') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offres`
--

CREATE TABLE `offres` (
  `nom` varchar(50) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `descr_offre` text,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `offre_reservation`
--

CREATE TABLE `offre_reservation` (
  `id_off` varchar(50) NOT NULL,
  `id_res` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pharmacie`
--

CREATE TABLE `pharmacie` (
  `id_pharmacie` int(11) NOT NULL,
  `nom_pharmacie` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `telephone` int(8) NOT NULL,
  `code_postal` int(11) NOT NULL,
  `horaire_travail` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(69) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` double DEFAULT NULL,
  `descr_produit` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `reference`, `nom`, `prix`, `descr_produit`) VALUES
(12, 'ob18', 'mac', 150, 'rouge à levre');

-- --------------------------------------------------------

--
-- Structure de la table `produit_reservation`
--

CREATE TABLE `produit_reservation` (
  `id_produit` int(11) NOT NULL,
  `id_reservation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit_reservation`
--

INSERT INTO `produit_reservation` (`id_produit`, `id_reservation`) VALUES
(12, 158);

-- --------------------------------------------------------

--
-- Structure de la table `rendez_vous`
--

CREATE TABLE `rendez_vous` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cin` int(8) NOT NULL,
  `date_naissance` date NOT NULL,
  `telephone` int(8) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `Date_Reservation` datetime DEFAULT NULL,
  `id_medecin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id`, `nom`, `date`) VALUES
(158, 'res1', '1988-12-05');

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `id_s` int(11) NOT NULL,
  `nom` enum('Radiologie','Chirurgie','Neurologie','Urgence','Cardiologie','Dermetologie','Traumatologie','Maternité','Pédiatrie','Laboratoire') DEFAULT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `nom` varchar(252) NOT NULL,
  `prenom` varchar(252) NOT NULL,
  `date_naissance` date NOT NULL,
  `cin` int(11) NOT NULL,
  `email` varchar(252) NOT NULL,
  `password` varchar(16) NOT NULL,
  `telephone` int(11) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `user` enum('medecin','pharmacien','propcentre','patient','admin') NOT NULL,
  `num_carte_serv` int(11) DEFAULT NULL,
  `id_f` int(11) NOT NULL,
  `id_pharmacie` int(11) NOT NULL,
  `id_centre` int(53) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `carte_service`
--
ALTER TABLE `carte_service`
  ADD PRIMARY KEY (`num_carte_service`),
  ADD UNIQUE KEY `id_carte_service` (`id_carte_service`);

--
-- Index pour la table `centre`
--
ALTER TABLE `centre`
  ADD PRIMARY KEY (`id_centre`),
  ADD KEY `nom` (`nom`),
  ADD KEY `id_produit` (`id_produit`);

--
-- Index pour la table `hopital`
--
ALTER TABLE `hopital`
  ADD PRIMARY KEY (`id_hopital`);

--
-- Index pour la table `hopital_service`
--
ALTER TABLE `hopital_service`
  ADD PRIMARY KEY (`id_hopital`,`id_s`);

--
-- Index pour la table `maladies`
--
ALTER TABLE `maladies`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `fk_medecin1` (`user`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`id_medicament`),
  ADD KEY `fk_pharmacien` (`user`);

--
-- Index pour la table `offres`
--
ALTER TABLE `offres`
  ADD PRIMARY KEY (`nom`);

--
-- Index pour la table `offre_reservation`
--
ALTER TABLE `offre_reservation`
  ADD PRIMARY KEY (`id_off`,`id_res`);

--
-- Index pour la table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD PRIMARY KEY (`id_pharmacie`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- Index pour la table `produit_reservation`
--
ALTER TABLE `produit_reservation`
  ADD PRIMARY KEY (`id_produit`,`id_reservation`);

--
-- Index pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`cin`),
  ADD KEY `id_medecin` (`id_medecin`);

--
-- Index pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_s`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user`),
  ADD UNIQUE KEY `id_pharmacie` (`id_pharmacie`),
  ADD UNIQUE KEY `num_carte_serv` (`num_carte_serv`),
  ADD KEY `id_f` (`id_f`),
  ADD KEY `num_carte_serv_2` (`num_carte_serv`),
  ADD KEY `id_centre` (`id_centre`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `centre`
--
ALTER TABLE `centre`
  MODIFY `id_centre` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(69) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT pour la table `service`
--
ALTER TABLE `service`
  MODIFY `id_s` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `centre`
--
ALTER TABLE `centre`
  ADD CONSTRAINT `centre_ibfk_1` FOREIGN KEY (`id_centre`) REFERENCES `reservation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_offre ` FOREIGN KEY (`nom`) REFERENCES `offres` (`nom`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `maladies`
--
ALTER TABLE `maladies`
  ADD CONSTRAINT `fk_medecin1` FOREIGN KEY (`user`) REFERENCES `users` (`user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `fk_pharmacien` FOREIGN KEY (`user`) REFERENCES `users` (`user`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `fk_idMed1` FOREIGN KEY (`id_medecin`) REFERENCES `carte_service` (`num_carte_service`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_carta` FOREIGN KEY (`num_carte_serv`) REFERENCES `carte_service` (`num_carte_service`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_centre` FOREIGN KEY (`id_centre`) REFERENCES `centre` (`id_centre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_pharmacie` FOREIGN KEY (`id_pharmacie`) REFERENCES `pharmacie` (`id_pharmacie`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

ALTER TABLE `users` ADD UNIQUE(`cin`);

ALTER TABLE `users` ADD `username` VARCHAR(50) NOT NULL AFTER `id_centre`;