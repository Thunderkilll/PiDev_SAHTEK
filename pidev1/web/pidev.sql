CREATE TABLE `carte_service` (
  `id_carte_service` int(11) NOT NULL,
  `num_carte_service` int(8) NOT NULL,
  `specialite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `centre`
--

CREATE TABLE `centre` (
  `id_centre` int(20) NOT NULL,
  `nom_centre` varchar(11) NOT NULL,
  `adresse_centre` varchar(20) NOT NULL,
  `telephone` int(8) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `id_produit` int(69) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hopital`
--

CREATE TABLE `hopital` (
  `id_hopital` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `type` varchar(12) DEFAULT NULL,
  `coodonnees` varchar(500) NOT NULL,
  `image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hopital_service`
--

CREATE TABLE `hopital_service` (
  `id_hopital` int(11) NOT NULL,
  `id_s` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `maladies`
--

CREATE TABLE `maladies` (
  `nom` varchar(50) NOT NULL,
  `symptomes` text NOT NULL,
  `description` text NOT NULL,
  `usrRole` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicament`
--

CREATE TABLE `medicament` (
  `id_medicament` int(11) NOT NULL,
  `nom_medicament` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `nom_labo` varchar(50) NOT NULL,
  `usrRole` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `offres`
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
-- Table structure for table `offre_reservation`
--

CREATE TABLE `offre_reservation` (
  `id_off` varchar(50) NOT NULL,
  `id_res` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacie`
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
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(69) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prix` double DEFAULT NULL,
  `descr_produit` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit_reservation`
--

CREATE TABLE `produit_reservation` (
  `id_produit` int(11) NOT NULL,
  `id_reservation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rendez_vous`
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



CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE `service` (
  `id_s` int(11) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_usr` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `nom` varchar(252) NOT NULL,
  `prenom` varchar(252) NOT NULL,
  `date_naissance` date NOT NULL,
  `cin` int(11) NOT NULL,
  `email` varchar(252) NOT NULL,
  `password` varchar(16) NOT NULL,
  `telephone` int(11) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `user` varchar(20) NOT NULL,
  `num_carte_serv` int(11) DEFAULT NULL,
  `id_pharmacie` int(11) DEFAULT NULL,
  `id_centre` int(53) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `carte_service`
  ADD PRIMARY KEY (`num_carte_service`),
  ADD UNIQUE KEY `id_carte_service` (`id_carte_service`);

--
-- Indexes for table `centre`
--
ALTER TABLE `centre`
  ADD PRIMARY KEY (`id_centre`),
  ADD KEY `nom` (`nom`),
  ADD KEY `id_produit` (`id_produit`);

--
-- Indexes for table `hopital`
--
ALTER TABLE `hopital`
  ADD PRIMARY KEY (`id_hopital`);

--
-- Indexes for table `hopital_service`
--
ALTER TABLE `hopital_service`
  ADD PRIMARY KEY (`id_hopital`,`id_s`);

--
-- Indexes for table `maladies`
--
ALTER TABLE `maladies`
  ADD PRIMARY KEY (`nom`),
  ADD KEY `fk_medecin1` (`usrRole`(1));

--
-- Indexes for table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`id_medicament`),
  ADD KEY `fk_pharmacien` (`usrRole`(1));

--
-- Indexes for table `offres`
--
ALTER TABLE `offres`
  ADD PRIMARY KEY (`nom`);

--
-- Indexes for table `offre_reservation`
--
ALTER TABLE `offre_reservation`
  ADD PRIMARY KEY (`id_off`,`id_res`);

--
-- Indexes for table `pharmacie`
--
ALTER TABLE `pharmacie`
  ADD PRIMARY KEY (`id_pharmacie`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`);

--
-- Indexes for table `produit_reservation`
--
ALTER TABLE `produit_reservation`
  ADD PRIMARY KEY (`id_produit`,`id_reservation`);

--
-- Indexes for table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD PRIMARY KEY (`cin`),
  ADD KEY `id_medecin` (`id_medecin`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id_s`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_usr`),
  ADD UNIQUE KEY `cin` (`cin`),
  ADD UNIQUE KEY `cin_2` (`cin`),
  ADD UNIQUE KEY `cin_3` (`cin`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `id_usr` (`id_usr`),
  ADD UNIQUE KEY `telephone` (`telephone`),
  ADD UNIQUE KEY `id_pharmacie` (`id_pharmacie`),
  ADD UNIQUE KEY `num_carte_serv` (`num_carte_serv`),
  ADD KEY `num_carte_serv_2` (`num_carte_serv`),
  ADD KEY `id_centre` (`id_centre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `centre`
--
ALTER TABLE `centre`
  MODIFY `id_centre` int(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(69) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `service`
--
ALTER TABLE `service`
  MODIFY `id_s` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_usr` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `centre`
--
ALTER TABLE `centre`
  ADD CONSTRAINT `centre_ibfk_1` FOREIGN KEY (`id_centre`) REFERENCES `reservation` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_offre ` FOREIGN KEY (`nom`) REFERENCES `offres` (`nom`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_produit` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `rendez_vous`
--
ALTER TABLE `rendez_vous`
  ADD CONSTRAINT `fk_idMed1` FOREIGN KEY (`id_medecin`) REFERENCES `users` (`id_usr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`cin`) REFERENCES `users` (`cin`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
