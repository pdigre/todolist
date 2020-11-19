CREATE TABLE IF NOT EXISTS `bruker` (
  `bruker_id` int(11) NOT NULL AUTO_INCREMENT,
  `bruker` varchar(24) COLLATE utf8_bin NOT NULL,
  `navn` text COLLATE utf8_bin NOT NULL,
  `epost` varchar(80) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`bruker_id`),
  UNIQUE KEY `bruker` (`bruker`),
  UNIQUE KEY `epost` (`epost`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

ALTER TABLE `bruker` ADD FULLTEXT KEY `navn` (`navn`);

INSERT INTO `bruker` (`bruker_id`, `bruker`, `navn`, `epost`) VALUES ('1', 'pdigre', 'Per Digre', 'per@digre.com');
INSERT INTO `bruker` (`bruker_id`, `bruker`, `navn`, `epost`) VALUES ('2', 'ukjent', 'Navn Ukjent', 'navn@ukjent.com');
