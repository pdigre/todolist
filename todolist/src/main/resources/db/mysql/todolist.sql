CREATE TABLE IF NOT EXISTS `bruker` (
  `bruker_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(24) COLLATE utf8_bin NOT NULL,
  `navn` text COLLATE utf8_bin NOT NULL,
  `epost` varchar(80) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`bruker_id`),
  UNIQUE KEY `epost` (`epost`),
  UNIQUE KEY `login` (`login`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `bruker` (`bruker_id`, `login`, `navn`, `epost`) VALUES
(1, 'pdigre', 'Per Digre', 'per@digre.com'),
(2, 'ukjent', 'Navn Ukjent', 'navn@ukjent.com');




CREATE TABLE IF NOT EXISTS `deltaker` (
  `bruker_id` int(11) NOT NULL,
  `liste_id` int(11) NOT NULL,
  PRIMARY KEY (`bruker_id`,`liste_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `deltaker` (`bruker_id`, `liste_id`) VALUES
(1, 1),
(1, 2),
(2, 3);



CREATE TABLE IF NOT EXISTS `liste` (
  `liste_id` int(11) NOT NULL AUTO_INCREMENT,
  `tittel` varchar(80) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`liste_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `liste` (`liste_id`, `tittel`) VALUES
(1, 'Julegaver 2020'),
(2, 'Huskeliste Hytta'),
(3, 'Min Todo Liste');




CREATE TABLE IF NOT EXISTS `punkt` (
  `liste_id` int(11) NOT NULL,
  `punkt_id` int(11) NOT NULL,
  `tekst` text COLLATE utf8_bin NOT NULL,
  `kategorier` text COLLATE utf8_bin NOT NULL,
  `erFerdig` tinyint(1) NOT NULL,
  PRIMARY KEY (`liste_id`,`punkt_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


INSERT INTO `punkt` (`liste_id`, `punkt_id`, `tekst`, `kategorier`, `erFerdig`) VALUES
(1, 1, 'Ny Tesla', 'Per,Pappa', 0),
(1, 2, 'Trekkspill', 'Per', 0),
(1, 3, 'Frimerkesamling', 'Hei', 0),
(1, 4, 'Gavekort Vinmonopolet', 'Evert', 0),
(2, 1, 'Vanne planter', 'må gjøre,har gjort', 0),
(2, 2, 'tømme søppel', '', 0);


ALTER TABLE `bruker` ADD FULLTEXT KEY `navn` (`navn`);
