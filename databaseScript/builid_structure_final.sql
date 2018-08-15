CREATE DATABASE IF NOT EXISTS`spring_database_test` CHARACTER SET latin1;

USE `spring_database_test`;


/*Table structure for table `family` */

DROP TABLE IF EXISTS `family`;

CREATE TABLE `family` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*Table structure for table `child` */

DROP TABLE IF EXISTS `child`;

CREATE TABLE `child` (
  `ID` INT(11) NOT NULL,
  `FirstName` VARCHAR(45) DEFAULT NULL,
  `SecondName` VARCHAR(45) DEFAULT NULL,
  `Sex` VARCHAR(45) DEFAULT NULL,
  `PESEL` VARCHAR(45) DEFAULT NULL,
  `BirthDate` DATE DEFAULT NULL,
  KEY `ID` (`ID`),
  CONSTRAINT `child_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `family` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


/*Table structure for table `father` */

DROP TABLE IF EXISTS `father`;

CREATE TABLE `father` (
  `ID` INT(11) NOT NULL,
  `BirthDate` DATE DEFAULT NULL,
  `FirstName` VARCHAR(45) DEFAULT NULL,
  `SecondName` VARCHAR(45) DEFAULT NULL,
  `PESEL` VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  CONSTRAINT `father_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `family` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;