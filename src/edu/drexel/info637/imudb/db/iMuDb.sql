-- MySQL dump 10.9
--
-- Host: localhost    Database: iMuDb
-- ------------------------------------------------------
-- Server version	4.1.22-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `PKey` int(11) NOT NULL auto_increment,
  `Album_ID` int(8) NOT NULL default '0',
  `Name` varchar(200) default NULL,
  `ReleaseDate` date default NULL,
  `RecordLabel` varchar(200) default NULL,
  `Producer` text,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,101,'Ten','1991-08-27','Epic Records','Rick Parashar');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
CREATE TABLE `band` (
  `PKey` int(11) NOT NULL auto_increment,
  `Band_ID` int(8) NOT NULL default '0',
  `Name` varchar(150) NOT NULL default '',
  `PlaceOfFormation` varchar(200) default NULL,
  `YearOfFormation` int(8) default NULL,
  `ExternalWebsiteLink` text,
  `Description` text,
  `Influences` text,
  `Hobbies` text,
  `Genre_ID` int(8) NOT NULL default '0',
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `band`
--

LOCK TABLES `band` WRITE;
/*!40000 ALTER TABLE `band` DISABLE KEYS */;
INSERT INTO `band` VALUES (1,101,'Pearl Jam','Seattle, Washington',1990,'http://pearljam.com/','Pearl Jam is an American rock band that formed in Seattle, Washington, in 1990. Since its inception, the band\'s line-up has included Eddie Vedder (lead vocals, guitar), Jeff Ament (bass guitar), Stone Gossard (rhythm guitar), and Mike McCready (lead guitar). The band\'s current drummer is Matt Cameron, also of Soundgarden, who has been with the band since 1998.\r\nFormed after the demise of Ament and Gossard\'s previous band Mother Love Bone, Pearl Jam broke into the mainstream with its debut album, Ten. One of the key bands of the grunge movement in the early 1990s, Pearl Jam was criticized early on as being a corporate cash-in on the alternative rock explosion. However, over the course of the band\'s career its members became noted for their refusal to adhere to traditional music industry practices, including refusing to make music videos and engaging in a much-publicized boycott of Ticketmaster. In 2006, Rolling Stone described the band as having \"spent much of the past decade deliberately tearing apart their own fame.\"\r\nSince its inception, the band has sold over thirty million records in the U.S., and an estimated sixty million worldwide. Pearl Jam has outlasted many of its contemporaries from the alternative rock breakthrough of the early 1990s, and is considered one of the most influential bands of the decade. Allmusic refers to Pearl Jam as \"the most popular American rock & roll band of the \'90s.\"','The Who, Neil Young, and other gunge bands.',NULL,144);
/*!40000 ALTER TABLE `band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandalbumcontribution`
--

DROP TABLE IF EXISTS `bandalbumcontribution`;
CREATE TABLE `bandalbumcontribution` (
  `PKey` int(11) NOT NULL auto_increment,
  `Album_ID` int(8) NOT NULL default '0',
  `Band_ID` int(8) NOT NULL default '0',
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bandalbumcontribution`
--

LOCK TABLES `bandalbumcontribution` WRITE;
/*!40000 ALTER TABLE `bandalbumcontribution` DISABLE KEYS */;
INSERT INTO `bandalbumcontribution` VALUES (1,101,101);
/*!40000 ALTER TABLE `bandalbumcontribution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bandtrackmapping`
--

DROP TABLE IF EXISTS `bandtrackmapping`;
CREATE TABLE `bandtrackmapping` (
  `PKey` int(11) NOT NULL auto_increment,
  `Track_ID` int(8) NOT NULL default '0',
  `Band_ID` int(8) NOT NULL default '0',
  `BandTrackInvovementType` varchar(200) default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bandtrackmapping`
--

LOCK TABLES `bandtrackmapping` WRITE;
/*!40000 ALTER TABLE `bandtrackmapping` DISABLE KEYS */;
INSERT INTO `bandtrackmapping` VALUES (1,10001,101,'Primary');
/*!40000 ALTER TABLE `bandtrackmapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert`
--

DROP TABLE IF EXISTS `concert`;
CREATE TABLE `concert` (
  `PKey` int(11) NOT NULL auto_increment,
  `Concert_ID` int(8) NOT NULL default '0',
  `EventDate` date default NULL,
  `Venue` varchar(200) default NULL,
  `TourName` varchar(200) default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `concert`
--

LOCK TABLES `concert` WRITE;
/*!40000 ALTER TABLE `concert` DISABLE KEYS */;
/*!40000 ALTER TABLE `concert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre`
--

DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `PKey` int(11) NOT NULL auto_increment,
  `Genre_ID` int(8) NOT NULL default '0',
  `Name` tinytext NOT NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

LOCK TABLES `genre` WRITE;
/*!40000 ALTER TABLE `genre` DISABLE KEYS */;
INSERT INTO `genre` VALUES (127,1001,'Blues'),(128,1002,'Classic Rock'),(129,1003,'Country'),(130,1004,'Dance'),(131,1005,'Disco'),(132,1006,'Funk'),(133,1007,'Grunge'),(134,1008,'Hip-Hop'),(135,1009,'Jazz'),(136,1010,'Metal'),(137,1011,'New Age'),(138,1012,'Oldies'),(139,1013,'Other'),(140,1014,'Pop'),(141,1015,'R&B'),(142,1016,'Rap'),(143,1017,'Reggae'),(144,1018,'Rock'),(145,1019,'Techno'),(146,1020,'Industrial'),(147,1021,'Alternative'),(148,1022,'Ska'),(149,1023,'Death Metal'),(150,1024,'Pranks'),(151,1025,'Soundtrack'),(152,1026,'Euro-Techno'),(153,1027,'Ambient'),(154,1028,'Trip-Hop'),(155,1029,'Vocal'),(156,1030,'Jazz+Funk'),(157,1031,'Fusion'),(158,1032,'Trance'),(159,1033,'Classical'),(160,1034,'Instrumental'),(161,1035,'Acid'),(162,1036,'House'),(163,1037,'Game'),(164,1038,'Sound Clip'),(165,1039,'Gospel'),(166,1040,'Noise'),(167,1041,'AlternRock'),(168,1042,'Bass'),(169,1043,'Soul'),(170,1044,'Punk'),(171,1045,'Space'),(172,1046,'Meditative'),(173,1047,'Instrumental Pop'),(174,1048,'Instrumental Rock'),(175,1049,'Ethnic'),(176,1050,'Gothic'),(177,1051,'Darkwave'),(178,1052,'Techno-Industrial'),(179,1053,'Electronic'),(180,1054,'Pop-Folk'),(181,1055,'Eurodance'),(182,1056,'Dream'),(183,1057,'Southern Rock'),(184,1058,'Comedy'),(185,1059,'Cult'),(186,1060,'Gangsta'),(187,1061,'Top 40'),(188,1062,'Christian Rap'),(189,1063,'Pop/Funk'),(190,1064,'Jungle'),(191,1065,'Native American'),(192,1066,'Cabaret'),(193,1067,'New Wave'),(194,1068,'Psychadelic'),(195,1069,'Rave'),(196,1070,'Showtunes'),(197,1071,'Trailer'),(198,1072,'Lo-Fi'),(199,1073,'Tribal'),(200,1074,'Acid Punk'),(201,1075,'Acid Jazz'),(202,1076,'Polka'),(203,1077,'Retro'),(204,1078,'Musical'),(205,1079,'Rock & Roll'),(206,1080,'Hard Rock'),(207,1081,'Folk'),(208,1082,'Folk-Rock'),(209,1083,'National Folk'),(210,1084,'Swing'),(211,1085,'Fast Fusion'),(212,1086,'Bebob'),(213,1087,'Latin'),(214,1088,'Revival'),(215,1089,'Celtic'),(216,1090,'Bluegrass'),(217,1091,'Avantgarde'),(218,1092,'Gothic Rock'),(219,1093,'Progressive Rock'),(220,1094,'Psychedelic Rock'),(221,1095,'Symphonic Rock'),(222,1096,'Slow Rock'),(223,1097,'Big Band'),(224,1098,'Chorus'),(225,1099,'Easy Listening'),(226,1100,'Acoustic'),(227,1101,'Humour'),(228,1102,'Speech'),(229,1103,'Chanson'),(230,1104,'Opera'),(231,1105,'Chamber Music'),(232,1106,'Sonata'),(233,1107,'Symphony'),(234,1108,'Booty Bass'),(235,1109,'Primus'),(236,1110,'Porn Groove'),(237,1111,'Satire'),(238,1112,'Slow Jam'),(239,1113,'Club'),(240,1114,'Tango'),(241,1115,'Samba'),(242,1116,'Folklore'),(243,1117,'Ballad'),(244,1118,'Power Ballad'),(245,1119,'Rhythmic Soul'),(246,1120,'Freestyle'),(247,1121,'Duet'),(248,1122,'Punk Rock'),(249,1123,'Drum Solo'),(250,1124,'A capella'),(251,1125,'Euro-House'),(252,1126,'Dance Hall');
/*!40000 ALTER TABLE `genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musician`
--

DROP TABLE IF EXISTS `musician`;
CREATE TABLE `musician` (
  `PKey` int(11) NOT NULL auto_increment,
  `Musician_ID` int(8) NOT NULL default '0',
  `Name` varchar(200) NOT NULL default '',
  `PlaceOfBirth` varchar(200) default NULL,
  `DateOfBirth` date default NULL,
  `DateOfDeath` date default NULL,
  `BandAssociantions` text,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `musician`
--

LOCK TABLES `musician` WRITE;
/*!40000 ALTER TABLE `musician` DISABLE KEYS */;
INSERT INTO `musician` VALUES (1,1000001,'Eddie Vedder','Evanston, Illinois, USA','1964-12-23',NULL,'Pearl Jam');
/*!40000 ALTER TABLE `musician` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `musicianbandmembership`
--

DROP TABLE IF EXISTS `musicianbandmembership`;
CREATE TABLE `musicianbandmembership` (
  `PKey` int(11) NOT NULL auto_increment,
  `Musician_ID` int(8) NOT NULL default '0',
  `Band_ID` int(8) NOT NULL default '0',
  `StartDate` date default NULL,
  `EndDate` date default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `musicianbandmembership`
--

LOCK TABLES `musicianbandmembership` WRITE;
/*!40000 ALTER TABLE `musicianbandmembership` DISABLE KEYS */;
INSERT INTO `musicianbandmembership` VALUES (1,1000001,101,'0000-00-00',NULL);
/*!40000 ALTER TABLE `musicianbandmembership` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `PKey` int(11) NOT NULL auto_increment,
  `Song_ID` int(8) NOT NULL default '0',
  `Album_ID` int(8) default NULL COMMENT 'If available',
  `Name` varchar(200) NOT NULL default '',
  `Author` varchar(200) default NULL,
  `Band` varchar(200) default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,10001,101,'Once','Stone Gossard','Pearl Jam');
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `track`
--

DROP TABLE IF EXISTS `track`;
CREATE TABLE `track` (
  `PKey` int(11) NOT NULL auto_increment,
  `Track_ID` int(8) NOT NULL default '0',
  `Song_ID` int(8) NOT NULL default '0',
  `Album_ID` int(8) NOT NULL default '0',
  `OrgerOnAlbum` int(11) default NULL,
  `Length` int(11) default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (1,100001,10001,101,1,231);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `PKey` int(11) NOT NULL auto_increment,
  `User_ID` int(8) NOT NULL default '0',
  `UserName` varchar(50) NOT NULL default '',
  `Password` varchar(50) default NULL,
  `EmailAddress` varchar(200) default NULL,
  `AccessLevel` varchar(50) default NULL,
  PRIMARY KEY  (`PKey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,101,'ddimitrov','999999','dimitar@domain.com','Administrator'),(2,102,'pfreestone','999999','pfreestone@domain.com','Administrator'),(3,103,'gvannoni','999999','gvannoni@domain.com','Administrator'),(4,201,'critic1','999999','critic@domain.com','Contributor'),(5,301,'member1','999999','member1@domain.com','Member');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

