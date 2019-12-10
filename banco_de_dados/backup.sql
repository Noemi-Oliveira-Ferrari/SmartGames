-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: db_smart_games
-- ------------------------------------------------------
-- Server version	5.7.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_console`
--

DROP TABLE IF EXISTS `tbl_console`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_console` (
  `id_console` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_console` varchar(200) NOT NULL,
  PRIMARY KEY (`id_console`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_console`
--

LOCK TABLES `tbl_console` WRITE;
/*!40000 ALTER TABLE `tbl_console` DISABLE KEYS */;
INSERT INTO `tbl_console` VALUES (1,'PlayStation'),(2,'PlayStation 2'),(3,'PlayStation 3'),(4,'PlayStation 4'),(5,'Nintendo Wii U'),(6,'X-Box One'),(7,'X-Box 360'),(8,'Nintendo Switch');
/*!40000 ALTER TABLE `tbl_console` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_coordenadas`
--

DROP TABLE IF EXISTS `tbl_coordenadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_coordenadas` (
  `id_coordenadas` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` varchar(100) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  PRIMARY KEY (`id_coordenadas`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_coordenadas`
--

LOCK TABLES `tbl_coordenadas` WRITE;
/*!40000 ALTER TABLE `tbl_coordenadas` DISABLE KEYS */;
INSERT INTO `tbl_coordenadas` VALUES (1,'-46.700695','-23.621467'),(2,'-46.688168','-23.577067'),(3,'-46.697608','-23.598844'),(4,'-46.698846','-23.623362'),(5,'-46.689753','-23.591491'),(6,'-46.721787','-23.550760');
/*!40000 ALTER TABLE `tbl_coordenadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_desenvolvedor`
--

DROP TABLE IF EXISTS `tbl_desenvolvedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_desenvolvedor` (
  `id_desenvolvedor` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_desenvolvedor` varchar(200) NOT NULL,
  PRIMARY KEY (`id_desenvolvedor`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_desenvolvedor`
--

LOCK TABLES `tbl_desenvolvedor` WRITE;
/*!40000 ALTER TABLE `tbl_desenvolvedor` DISABLE KEYS */;
INSERT INTO `tbl_desenvolvedor` VALUES (1,'Capcom'),(2,'Square Enix'),(3,'Konami'),(4,'Ubisoft'),(5,'Sega'),(6,'Electronic Arts'),(7,'Activision Blizzard'),(8,'Nintendo'),(9,'Sony'),(10,'Microsoft'),(11,'Activision'),(12,'Blizzard'),(13,'Rockstar'),(14,'The Coalition'),(15,'Turn 10'),(16,'CD Projekt'),(17,'TT Games'),(18,'Rocksteady');
/*!40000 ALTER TABLE `tbl_desenvolvedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_endereco`
--

DROP TABLE IF EXISTS `tbl_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(200) NOT NULL,
  `local_mapa` text NOT NULL,
  `id_uf` int(11) NOT NULL,
  `bairro` varchar(200) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `id_coordenadas` int(11) NOT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `fk_uf` (`id_uf`),
  KEY `fk_coordenadas_idx` (`id_coordenadas`),
  CONSTRAINT `fk_uf` FOREIGN KEY (`id_uf`) REFERENCES `tbl_uf` (`id_uf`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_endereco`
--

LOCK TABLES `tbl_endereco` WRITE;
/*!40000 ALTER TABLE `tbl_endereco` DISABLE KEYS */;
INSERT INTO `tbl_endereco` VALUES (1,'Av. Dr. Chucri Zaidan','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3655.519900761912!2d-46.70185288502118!3d-23.62154518465306!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce50db31e29183%3A0xc2dd17d9f2416178!2sAv.%20Dr.%20Chucri%20Zaidan%2C%20902%20-%20Cidade%20Mon%C3%A7%C3%B5es%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2004583-110!5e0!3m2!1spt-BR!2sbr!4v1575422193397!5m2!1spt-BR!2sbr',35,'Vila Cordeiro',902,1),(2,'Av. Brigadeiro Faria Lima','https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3656.774452741091!2d-46.68747509914172!3d-23.57654275236689!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1spt-BR!2sbr!4v1575422412584!5m2!1spt-BR!2sbr',35,'Jd. Paulistano',2232,2),(3,'Avenida Magalhães de Castro','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.1502961598558!2d-46.69980738502158!3d-23.59894218466433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce5730648f80a7%3A0xf89e72eac29f3838!2sCidade%20Jardim!5e0!3m2!1spt-BR!2sbr!4v1575422544222!5m2!1spt-BR!2sbr',35,'São Paulo',12000,3),(4,'Avenida Roque Petroni Júnior','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3655.4716054733017!2d-46.70091618502097!3d-23.623275984652224!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce50c4afed1895%3A0x9bffbe18811d2962!2sAv.%20Roque%20Petroni%20J%C3%BAnior%2C%201089%20-%20Ch%C3%A1cara%20Santo%20Ant%C3%B4nio%20(Zona%20Sul)%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2004707-120!5e0!3m2!1spt-BR!2sbr!4v1575422634258!5m2!1spt-BR!2sbr',35,'São Paulo',1089,4),(5,'Avenida Presidente Juscelino Kubitschek','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3656.361259281251!2d-46.69194688502169!3d-23.591373484668026!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce57444cd02355%3A0x262da889fb88b311!2sAv.%20Pres.%20Juscelino%20Kubitschek%2C%202041%20-%20Itaim%20Bibi%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2004543-011!5e0!3m2!1spt-BR!2sbr!4v1575422797431!5m2!1spt-BR!2sbr',35,'Itaim Bibi',2041,5),(6,'Avenida das Nações Unidas','https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3657.552401271884!2d-46.730710285022376!3d-23.548595984689147!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce561eef9998a1%3A0x6eb3e9051359758c!2sAv.%20das%20Na%C3%A7%C3%B5es%20Unidas%2C%204777%20-%20Vila%20Hamburguesa%2C%20S%C3%A3o%20Paulo%20-%20SP%2C%2004795-100!5e0!3m2!1spt-BR!2sbr!4v1575422948383!5m2!1spt-BR!2sbr',35,'Alto de Pinheiros',4777,6);
/*!40000 ALTER TABLE `tbl_endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_genero`
--

DROP TABLE IF EXISTS `tbl_genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_genero` (
  `id_genero` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_genero` varchar(200) NOT NULL,
  PRIMARY KEY (`id_genero`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_genero`
--

LOCK TABLES `tbl_genero` WRITE;
/*!40000 ALTER TABLE `tbl_genero` DISABLE KEYS */;
INSERT INTO `tbl_genero` VALUES (1,'Ação'),(2,'Aventura'),(3,'Luta'),(4,'Tiro/Shoter'),(5,'RPG'),(6,'Esporte'),(7,'Simulação'),(8,'Terror'),(9,'Estratégia'),(10,'Puzzle'),(11,'Corrida');
/*!40000 ALTER TABLE `tbl_genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_jogo`
--

DROP TABLE IF EXISTS `tbl_jogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_jogo` (
  `id_jogo` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_jogo` varchar(200) NOT NULL,
  `descricao` text NOT NULL,
  `idade` int(11) NOT NULL,
  `ano_lancamento` int(11) NOT NULL,
  `foto_mobile` text NOT NULL,
  `foto_web` text NOT NULL,
  `avaliacao` int(11) NOT NULL,
  `id_genero` int(11) NOT NULL,
  `id_console` int(11) NOT NULL,
  `id_loja` int(11) NOT NULL,
  `id_desenvolvedor` int(11) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id_jogo`),
  KEY `fk_genero` (`id_genero`),
  KEY `fk_console` (`id_console`),
  KEY `fk_loja` (`id_loja`),
  KEY `fk_desenvolvedor` (`id_desenvolvedor`),
  CONSTRAINT `fk_console` FOREIGN KEY (`id_console`) REFERENCES `tbl_console` (`id_console`),
  CONSTRAINT `fk_desenvolvedor` FOREIGN KEY (`id_desenvolvedor`) REFERENCES `tbl_desenvolvedor` (`id_desenvolvedor`),
  CONSTRAINT `fk_genero` FOREIGN KEY (`id_genero`) REFERENCES `tbl_genero` (`id_genero`),
  CONSTRAINT `fk_loja` FOREIGN KEY (`id_loja`) REFERENCES `tbl_loja` (`id_loja`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_jogo`
--

LOCK TABLES `tbl_jogo` WRITE;
/*!40000 ALTER TABLE `tbl_jogo` DISABLE KEYS */;
INSERT INTO `tbl_jogo` VALUES (9,'Call Of Duty','Call of Duty é uma série de videojogos na primeira pessoa. A série começou no PC, mais tarde expandindo-se para os vários tipos de consoles. Também foram lançados vários jogos spin-off. Os primeiros títulos têm como cenário a Segunda Guerra Mundial, incluindo Call of Duty, Call of Duty 2 e Call of Duty 3.',18,2017,'https://steamcdn-a.akamaihd.net/steam/apps/202970/header.jpg?t=1568840988','img/callofduty.jpg',5,4,4,1,11,50),(10,'OverWatch','O jogo enfatiza a jogabilidade cooperativa usando um elenco de vários \\\"heróis\\\", cada um com suas próprias habilidades e funções dentro de uma equipe.',14,2016,'https://img.ibxk.com.br/2018/04/30/30134256692154.jpg?w=300&mode=crop&scale=both','img/overwatch.jpg',2,4,4,2,12,90),(11,'Fifa 2019','O game oferece varios modos de jogo como o modo Carreira, A Jornada e o popular Ultimate Team, sendo que o ultimo recebeu diversas novidades para a ediçao deste ano. Além dos modos de jogo, o game também tem como novidade o licenciamento da principal competiçao de clubes da europa, a UEFA Champions League.',0,2019,'https://s2.glbimg.com/V7249rL9MNWhMckASzn9eXwSDIA=/0x0:1920x1080/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2019/g/h/w1BZ0sTpuURRdlnxBaag/fifa-19-intros.jpg','img/fifa2019.jpg',3,6,6,3,6,120),(12,'Super Smash Bros','Super Smash Bros\',\'Super Smash Bros é um jogo de luta não tradicional em que jogadores usam ataques diferentes para enfraquecer seus oponentes e derrubá-los para fora da arena. Contém a participação do elenco de personagens da Nintendo.',12,2018,'https://observatoriodegames.bol.uol.com.br/wp-content/uploads/2019/10/smash_illo.0.jpg','img/supersmashbros.jpg',4,3,8,4,8,75),(13,'GTA V',' Em Grand Theft Auto V, o jogador controla três personagens que têm as histórias interligadas. Michael é um ex-assaltante de bancos na casa dos quarenta anos que vive com uma família disfuncional, consequência da sua vida passada.',18,2013,'https://rggames.com.br/wp-content/uploads/2015/11/a-historia-de-grand-theft-auto-v.jpg','img/gta5.jpg',5,2,4,1,13,65),(14,'Gears of War 4','Uma nova saga começa para uma das franquias mais aclamadas na história. Depois de escapar de um ataque em sua cidade, JD Fenix e seus amigos, Kait e Del, devem resgatar seus seres queridos e descobrir a origem do novo inimigo monstruoso.',18,2016,'https://store-images.s-microsoft.com/image/apps.6102.13510798887356280.9398b0dd-2ecf-4973-9380-576d1d374a25.92d12017-af9a-41ae-b97a-8213710cdb49?mode=scale&q=90&h=1080&w=1920','img/gearsofwar.jpg',4,4,6,4,14,85),(15,'Forza Motorsport 6','Forza Motorsport 6 é o mais novo episódio da consagrada série de corrida da Microsoft, e o game traz como novidade a presença do novo Ford GT em sua capa. Além disso, também são esperadas melhorias em termos de mecânicas e, claro, adições de algumas opções inéditas.',0,2015,'https://store-images.s-microsoft.com/image/apps.53502.69096714078170659.7fef355f-e88f-453e-b39a-2b798f8c2f32.f3b9fd41-740f-4382-9419-eab3a43fa74f?mode=scale&q=90&h=1080&w=1920','img/forza.jpg',5,11,6,2,15,50),(16,'Assassin\'s Creed IV','Assassins Creed IV: tem como palco a Era Dourada da Pirataria, época repleta de histórias inacreditáveis e lendas que vivem até hoje. Na pele de Edward Kenway, um galês carismático e ganancioso, o jogador irá vivenciar a guerra entre ingleses e espanhóis, descobrindo o que ocorre por debaixo dos panos.',18,2013,'https://store-images.s-microsoft.com/image/apps.22722.67951031792552411.8554efa1-9624-428f-afb8-7b79d5108d5c.8d6c4c33-2dd3-4bad-9cd4-0a8fc86857cb?mode=scale&q=90&h=1080&w=1920&format=jpg','img/assassinscreed.jpg',4,2,6,3,4,120),(17,'Far Cry 4','Far Cry 4 leva você ao Himalaia, mais exatamente a uma região selvagem e perigosa chamada Kyrat. O lugar é reinado por um homem que se auto-proclamou, chamado Pagan Min. Far Cry 4 traz um cenário gigantesco, liberdade para escrever sua história.',18,2014,'https://store-images.s-microsoft.com/image/apps.22845.69582963086497758.e1cff2e3-ddf1-42bf-930d-f380ad63f100.1ef04059-9768-4999-b495-f48a52290ae9?mode=scale&q=90&h=1080&w=1920','img/farcry.jpg',4,4,6,1,4,70),(18,'The Witcher 3','O retorno das memórias de Geralt permitiu que uma história muito mais pessoal e intimista fosse criada. Ele modificou a história de reinos e regiões do mundo, mas pode parar de fazer isso caso você deseje. ',16,2015,'https://store.nintendo.com.br/media/catalog/product/cache/283f8fe3bae97c239dc64bef48686c8d/w/i/witcher3_switch_store_art_1920x1080_en.jpg','img/thewitcher.jpg',5,5,6,1,16,55),(19,'LEGO Marvel','Em Lego Marvel Super heroes você irá poder conhecer e se aventurar em uma história original que se passa nos mais incríveis mundos já criados pela Marvel. Os jogadores assumem o controle do Homem de Ferro, Homem Aranha, Hulk, Capitão América, Wolverine e muitos outros personagens.',10,2013,'https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/wiiu_14/SI_WiiU_LegoMarvelSuperHeroes_image1600w.jpg','img/lego.jpg',3,2,7,2,17,30),(20,'Batman: Arkham','O Coringa se ofereceu pacificamente para ser encarcerado no terrivelmente emblemático e largamente reconhecido Arkham Asylum. É claro, algo não cheira bem nisso.',14,2009,'https://http2.mlstatic.com/batman-arkham-asylum-goty-edition-steam-key-original-D_NQ_NP_719458-MLB26297702039_112017-F.jpg','img/batman.jpg',5,2,7,4,18,60),(21,'The Legend of Zelda','Anos após seu lançamento original para Game Boy, The Legend of Zelda: Link\'s Awakening traz uma nova experiência para o Nintendo Switch. Tudo começa quando Link perde sua embarcação para uma terrível tempestade e é levado a costa da misteriosa ilha Koholint. ',0,2019,'https://store.nintendo.com.br/media/catalog/product/cache/283f8fe3bae97c239dc64bef48686c8d/z/e/zeldabow_hero_2.jpg','img/zelda.jpg',5,2,8,2,1,110);
/*!40000 ALTER TABLE `tbl_jogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_loja`
--

DROP TABLE IF EXISTS `tbl_loja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_loja` (
  `id_loja` int(11) NOT NULL AUTO_INCREMENT,
  `titulo_loja_shopping` varchar(200) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY (`id_loja`),
  KEY `fk_endereco` (`id_endereco`),
  CONSTRAINT `fk_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `tbl_endereco` (`id_endereco`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_loja`
--

LOCK TABLES `tbl_loja` WRITE;
/*!40000 ALTER TABLE `tbl_loja` DISABLE KEYS */;
INSERT INTO `tbl_loja` VALUES (1,'Shopping Market Place',1),(2,'Shopping Iguatemi SP',2),(3,'Shopping Cidade Jardim',3),(4,'Morumbi Shopping',4),(5,'JK Iguatemi',5),(6,'Shopping Villa Lobos',6);
/*!40000 ALTER TABLE `tbl_loja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_uf`
--

DROP TABLE IF EXISTS `tbl_uf`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_uf` (
  `id_uf` int(11) NOT NULL AUTO_INCREMENT,
  `uf` varchar(2) NOT NULL,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_uf`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_uf`
--

LOCK TABLES `tbl_uf` WRITE;
/*!40000 ALTER TABLE `tbl_uf` DISABLE KEYS */;
INSERT INTO `tbl_uf` VALUES (11,'RO','Rondônia'),(12,'AC','Acre'),(13,'AM','Amazonas'),(14,'RR','Roraima'),(15,'PA','Pará'),(16,'AP','Amapá'),(17,'TO','Tocantins'),(21,'MA','Maranhão'),(22,'PI','Piauí'),(23,'CE','Ceará'),(24,'RN','Rio Grande do Norte'),(25,'PB','Paraíba'),(26,'PE','Pernambuco'),(27,'AL','Alagoas'),(28,'SE','Sergipe'),(29,'BA','Bahia'),(31,'MG','Minas Gerais'),(32,'ES','Espírito Santo'),(33,'RJ','Rio de Janeiro'),(35,'SP','São Paulo'),(41,'PR','Paraná'),(42,'SC','Santa Catarina'),(43,'RS','Rio Grande do Sul'),(50,'MS','Mato Grosso do Sul'),(51,'MT','Mato Grosso'),(52,'GO','Goiás'),(53,'DF','Distrito Federal');
/*!40000 ALTER TABLE `tbl_uf` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-09 23:36:14
