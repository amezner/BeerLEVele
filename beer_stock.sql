-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: 192.168.2.3
-- Generation Time: Nov 19, 2017 at 10:49 PM
-- Server version: 5.6.38
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beer_stock`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `country` varchar(50) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `postalcode` varchar(15) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `loyaltycard` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `name`, `country`, `city`, `address`, `postalcode`, `email`, `phone`, `loyaltycard`, `discount`) VALUES
(1, 'Reichel-Heidenreich', 'Uruguay', 'Pando Canelones', '76 Bonner Plaza', '11600', 'hbroek0@gmpg.org', '+33-160-251-2852', b'1', 3),
(2, 'Waelchi Group', 'France', 'Paris 19', '2 Cascade Crossing', '75954 CEDEX 19', 'aosheils1@jiathis.com', '+33-284-962-2516', b'0', 0),
(3, 'Stracke-Purdy', 'Czech Republic', 'Žebrák', '79 Anniversary Road', '263 01', 'vbaudic2@msu.edu', '+420-949-991-3365', b'1', 12),
(4, 'Padberg-Hettinger', 'United States', 'Saint Joseph', '328 8th Hill', '64504', 'freye3@seesaa.net', '+1-816-334-7124', b'1', 2),
(5, 'Rice, Mann and Cronin', 'United States', 'Tulsa', '25 Lerdahl Place', '74116', 'qdoyley4@businessinsider.com', '+1-918-987-3233', b'1', 6),
(6, 'Bins, Herzog and Roberts', 'Czech Republic', 'Vilémov', '59 Johnson Point', '783 22', 'efoot5@geocities.com', '+420-778-200-2729', b'1', 10),
(7, 'Mante, Roberts and Pfannerstill', 'United States', 'San Francisco', '6 Nova Court', '94154', 'agoulstone6@tinypic.com', '+1-415-312-6637', b'0', 0),
(8, 'Stoltenberg-Dibbert', 'United Kingdom', 'East End', '00 Lakewood Gardens Court', 'BH21', 'gdiggles7@mediafire.com', '+44-835-167-4875', b'1', 12),
(9, 'Dach LLC', 'Czech Republic', 'Třešť', '58901 Gina Trail', '589 01', 'dmughal8@gizmodo.com', '+420-723-493-6264', b'0', 0),
(10, 'Cassin-Von', 'Czech Republic', 'Holoubkov', '4112 Dahle Lane', '338 01', 'cmiddis9@youku.com', '+420-133-944-7049', b'0', 0),
(11, 'Schmitt-Gerlach', 'United States', 'Tallahassee', '80 Annamark Center', '32309', 'rrourkea@archive.org', '+1-850-124-5356', b'0', 0),
(12, 'Fahey, Considine and Hintz', 'United States', 'Huntsville', '088 Ruskin Street', '35805', 'abadamb@craigslist.org', '+1-256-328-5507', b'0', 0),
(13, 'Bernhard, Kovacek and Ratke', 'France', 'Angers', '91345 Kennedy Road', '49010 CEDEX 01', 'tiddendenc@oaic.gov.au', '+33-632-786-8402', b'0', 0),
(14, 'Reynolds, Yost and Harber', 'Czech Republic', 'Zbůch', '38 Marquette Trail', '330 22', 'cstenetd@seesaa.net', '+420-323-320-0666', b'0', 0),
(15, 'Gutmann-Ritchie', 'Czech Republic', 'Dolní Cerekev', '659 Elgar Trail', '588 45', 'lsmye@zdnet.com', '+420-212-533-5301', b'1', 3),
(16, 'Leuschke Group', 'United States', 'Gatesville', '24 Basil Place', '76598', 'mpearlef@amazon.co.uk', '+1-254-468-6972', b'1', 4),
(17, 'Barton, Bartell and Ebert', 'United States', 'North Little Rock', '49960 Jana Road', '72118', 'blockieg@amazon.de', '+1-501-557-3425', b'1', 6),
(18, 'Witting Inc', 'France', 'Eaubonne', '64234 Randy Plaza', '95604 CEDEX', 'mcarnellh@goo.ne.jp', '+33-865-756-3685', b'1', 8),
(19, 'Nienow-Hane', 'Czech Republic', 'Hostomice', '15 Comanche Place', '417 52', 'goliphanti@hostgator.com', '+420-179-227-8578', b'1', 8),
(20, 'Davis LLC', 'France', 'La Gacilly', '88 Lotheville Point', '56209 CEDEX', 'jbatstonej@bing.com', '+33-838-442-3917', b'1', 2),
(21, 'Wehner-Lesch', 'Czech Republic', 'Hodkovice nad Mohelkou', '6 Amoth Circle', '463 42', 'ebinnionk@alexa.com', '+420-986-429-0021', b'0', 0),
(22, 'Daniel, Stamm and Kreiger', 'Czech Republic', 'Prostřední Bečva', '555 Oneill Terrace', '756 56', 'kmccreal@cisco.com', '+420-279-649-2219', b'1', 5),
(23, 'Von, Wehner and Shields', 'France', 'La Rochelle', '256 Amoth Avenue', '17004 CEDEX 1', 'sroscriggm@bing.com', '+33-738-330-6585', b'0', 0),
(24, 'Grimes, Corkery and Graham', 'Czech Republic', 'Červená Voda', '5 Eliot Junction', '561 61', 'sboycen@abc.net.au', '+420-273-507-7677', b'0', 0),
(25, 'Wiegand-Stamm', 'Czech Republic', 'Staré Křečany', '942 Clove Avenue', '407 61', 'agonzaleso@auda.org.au', '+420-296-233-6897', b'1', 2),
(26, 'Borer and Sons', 'United States', 'Waco', '2235 Bowman Way', '76711', 'cthoroldp@naver.com', '+1-254-777-5761', b'1', 3),
(27, 'Crona Group', 'France', 'Marne-la-Vallée', '15441 Johnson Park', '77602 CEDEX 3', 'apetscheltq@slideshare.net', '+33-555-719-8098', b'1', 9),
(28, 'Cormier, Klocko and Runte', 'Czech Republic', 'Sokolnice', '121 Nancy Road', '664 52', 'escuser@sina.com.cn', '+420-180-898-5171', b'1', 5),
(29, 'Weber-Heaney', 'France', 'Digne-les-Bains', '50 Sycamore Circle', '04004 CEDEX', 'celvess@nifty.com', '+33-835-597-4022', b'0', 0),
(30, 'Gutmann and Sons', 'France', 'Metz', '55 Kensington Trail', '57045 CEDEX 01', 'kbengefieldt@microsoft.com', '+33-843-570-8018', b'1', 2),
(31, 'Koepp, Kovacek and Will', 'Czech Republic', 'Višňové', '2006 Pawling Drive', '671 38', 'ehaisellu@live.com', '+420-994-867-0859', b'0', 0),
(32, 'Bergnaum-Schimmel', 'France', 'Palaiseau', '20712 Cambridge Street', '91124 CEDEX', 'hstrathernv@eventbrite.com', '+33-235-494-1137', b'1', 12),
(33, 'Daugherty, Koepp and Ritchie', 'France', 'Creil', '48 Hudson Court', '60109 CEDEX 1', 'mvassallw@eepurl.com', '+33-258-251-4369', b'0', 0),
(34, 'Mayert, Howe and Gulgowski', 'France', 'Poitiers', '779 Delaware Alley', '86042 CEDEX 9', 'rwillsheex@list-manage.com', '+33-876-419-4863', b'1', 6),
(35, 'Hermann, Kertzmann and Cruickshank', 'United States', 'Grand Rapids', '9045 Tomscot Crossing', '49560', 'garmitagey@paginegialle.it', '+1-616-559-6299', b'1', 5),
(36, 'Schmidt, Batz and Pagac', 'Germany', 'München', '99 Ridge Oak Pass', '81373', 'vrundlez@foxnews.com', '+49-651-689-8367', b'1', 10),
(37, 'Hahn and Sons', 'United Kingdom', 'Walton', '14038 Donald Drive', 'CV35', 'ljubert10@privacy.gov.au', '+44-994-576-8190', b'1', 8),
(38, 'Rogahn Inc', 'France', 'Clichy', '8974 Burning Wood Crossing', '92613 CEDEX', 'growaszkiewicz11@yahoo.co.jp', '+33-575-197-1287', b'0', 0),
(39, 'Kreiger LLC', 'Czech Republic', 'Dolní Sloupnice', '64967 Burning Wood Center', '565 53', 'dpoley12@tuttocitta.it', '+420-842-943-2337', b'1', 12),
(40, 'Gutmann-Rodriguez', 'Czech Republic', 'Přimda', '27303 Merchant Plaza', '348 06', 'lculvey13@harvard.edu', '+420-285-476-5557', b'1', 2),
(41, 'Hoppe and Sons', 'United States', 'Wilmington', '96373 Main Drive', '28410', 'oleathart14@vk.com', '+1-910-921-5196', b'1', 14),
(42, 'Crona-Kessler', 'France', 'Massy', '018 Hermina Junction', '91881 CEDEX', 'ptackell15@moonfruit.com', '+33-358-997-4460', b'0', 0),
(43, 'Sawayn-Schuster', 'France', 'Montpellier', '44 Duke Junction', '34032 CEDEX 1', 'ovinten16@paypal.com', '+33-796-410-0420', b'0', 0),
(44, 'Hoeger-Toy', 'France', 'Brive-la-Gaillarde', '5 Sachs Pass', '19318 CEDEX', 'abissatt17@moonfruit.com', '+33-808-426-0019', b'0', 0),
(45, 'Kihn and Sons', 'France', 'Paris 12', '91908 Cottonwood Hill', '75582 CEDEX 12', 'mlist18@hatena.ne.jp', '+33-260-714-3835', b'1', 13),
(46, 'Labadie Group', 'United States', 'Houston', '654 Corben Way', '77260', 'vingrem19@ustream.tv', '+1-713-803-6853', b'1', 1),
(47, 'Shanahan-Feest', 'Czech Republic', 'Kamenné Žehrovice', '4 Granby Place', '273 01', 'nnaulty1a@chronoengine.com', '+420-435-477-4736', b'1', 10),
(48, 'Ryan, Morar and Kshlerin', 'France', 'Istres', '02 Nevada Avenue', '13802 CEDEX', 'arising1b@jigsy.com', '+33-165-617-6689', b'0', 0),
(49, 'Lubowitz, Okuneva and Crooks', 'Netherlands', 'Delft', '47067 Sycamore Point', '2614', 'csmeed1c@vimeo.com', '+31-486-104-8334', b'1', 6),
(50, 'Koch-McCullough', 'France', 'Paris 12', '45 Haas Street', '75567 CEDEX 12', 'lcomizzoli1d@globo.com', '+33-363-609-4962', b'0', 0);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoicenumber` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `country` varchar(50) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `city` varchar(50) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `postalcode` varchar(15) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `loyaltycard` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoicenumber`, `date`, `customer_id`, `name`, `country`, `city`, `address`, `postalcode`, `email`, `phone`, `loyaltycard`, `discount`) VALUES
(1, '2017-11-15 08:40:30', 1, 'Ez mar nem az az ugyfel, csak tesztelunk!', 'Masorszag', 'Rakottfalva', 'Ez mar nem az a cim, csak tesztelunk!', '36000', 'salala@trallala.com', 'ez-sem-az-a-szam', b'1', 5);

-- --------------------------------------------------------

--
-- Table structure for table `invoicedproducts`
--

CREATE TABLE `invoicedproducts` (
  `ID` int(11) NOT NULL,
  `invoicenumber` int(11) DEFAULT NULL,
  `stockid` int(11) DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `alcoholcontent` double NOT NULL,
  `bottlesize` double NOT NULL,
  `purchaseprice` double DEFAULT NULL,
  `soldprice` double DEFAULT NULL,
  `soldquantity` int(11) DEFAULT NULL,
  `soldsubtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoicedproducts`
--

INSERT INTO `invoicedproducts` (`ID`, `invoicenumber`, `stockid`, `name`, `type`, `alcoholcontent`, `bottlesize`, `purchaseprice`, `soldprice`, `soldquantity`, `soldsubtotal`) VALUES
(1, 1, 10, 'Gösser', 'Lager', 5, 0.5, 200, 300, 100, 0),
(2, 1, 41, 'MasikNev', 'CsakTeszt', 3, 0.33, 500, 1000, 1000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order1`
--

CREATE TABLE `order1` (
  `ID` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `stock_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order1`
--

INSERT INTO `order1` (`ID`, `uid`, `stock_id`, `quantity`) VALUES
(1, 1, 1, 10),
(2, 1, 2, 20),
(3, 2, 3, 30),
(4, 2, 29, 30),
(5, 2, 12, 10),
(6, 3, 10, 50),
(7, 3, 5, 20),
(8, 3, 19, 100),
(18, 1, 20, 200),
(19, 2, 30, 30),
(20, 3, 40, 400),
(21, 1, 40, 40);

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `ID` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `alcoholcontent` double DEFAULT NULL,
  `bottlesize` double DEFAULT NULL,
  `purchaseprice` double DEFAULT NULL,
  `sellingprice` double DEFAULT NULL,
  `onstockquantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`ID`, `name`, `description`, `type`, `alcoholcontent`, `bottlesize`, `purchaseprice`, `sellingprice`, `onstockquantity`) VALUES
(1, 'Távoli Galaxis', 'A Távoli Galaxis egy tipikus amerikai IPA a galaxy komló egyedi ízével, aromájával fűszerezve. A 2013-ban megrendezett 2. Magyar Házisörfőző Verseny abszolút győztese - egyelőre csak csapon. Alkoholtartalma 6,1%. összetevők: víz, árpamaláta, komló, élesztő.', 'IPA', 6.1, 0.33, 400, 750, 100),
(2, 'Amstel', 'A klasszikus...', 'Lager', 5, 0.5, 200, 250, 1000),
(3, 'Amstel Beertender-partyhordó 4l', 'A nagyágyú!', 'Lager', 5, 4, 5500, 8200, 100),
(4, 'Szent András Könnye', 'Igayi áfonyával ízesített bak típusú fekete sör', 'Bak', 9, 0.33, 500, 790, 254),
(5, 'Paulaner Salvator', 'Sötét borostyán színével és krémes bézs habjával a sör előre vetíti a ránk váró élményeket. Illatában gyümölcsös karamell és likörös pörkölt aromák érződnek, alkoholos fennhangok mellett. A sör íze és érzete igen komplex, sűrű. Karamellás, likőrös telítettsége mellett maláta és az alsóerjesztésű élesztőkre csak ilyen erős söröknél jellemző gyümölcsös, szilvás zamat borítja el ízlelőbimbóinkat, mely egy határozott, pörkölt utóízben kiteljesedve bénítja le nyelvünket.', 'Duplabak', 7.9, 0.5, 500, 750, 254),
(6, 'Weihenstephaner Vitus', 'Sürü, szalmasárga sörfolyamként terpeszkedik a weihenstephani fözde búzabakja. Hihetetlenül stabil, egységesen tömött és szivacsos habkoronája felöl egy túlérett gyümölcsökböl, korianderrel és fahéjjal, szerecsendiüval készített, mézzel elkevert kotél karaktere omlik ránk, s telíti szaglühámunkat. Belekortyolva az ízlelöbimbók is az elernyedés útjára lépnek. Sürü ízhalmazként foglalja el nyelvünket a karamell és méz együttese, füszerezve a finom felsörejesztés minden porcikájával. Banános és trópusi gyümölcsöktöl telített képbe keveredik be az intenzíven füszeres, szerecsendiós, mézes és komlós zamathalmaz.', 'Bak búzasör', 7.7, 0.5, 500, 750, 500),
(7, 'Desperados Tequila', 'A bulik itala! A fiatalok egyik kedvenc söre, mely tequila ízesítésű. Alkoholtartalom 5,9%.\r\nA sör legjobban élvezhető 7ºC fokra lehűtve illetve citrom karikával üvegből fogyasztandó.', 'Lager', 5.9, 0.33, 300, 370, 500),
(8, 'Schneider Weisse Aventinus tap.6', 'Klasszikus bajor búzasör illat csapja meg orrunkat. Ananász, élesztős pára, mi a sok maláta miatt párosul egy fruttis édes illatfelhővel és enyhe pörkölt felhangokkal. Ehhez leheletnyi komló társul még. Sötét dióbarna színű, élesztőtől fátyolos italunkat dús tojáshéj szín hab koronázza.\r\nA citrusos frissesség csak kevéssé jellemzi, ízeiben is hozza az ananászt és a barna búzákra oly jellemző banános aromákat. Ebbe vegyül némi kandiscukros élesztősség. Egy kicsit melegedve azonban jobban kibomlik a sör és a következő rétegben egy apátsági tripel élesztős malátásságát mutatja, majd ebből a tiszta elegáns ízből egy egész meglepő ízvilágba csap át. üde, szinte lambicos meggyes aromák után, ahogy az alkohol (8,2%) is kezdi éreztetni a hatását átcsap egy konyakmeggyes, majd konyakos eleganciába. Nagyon sokrétű, nem véletlenül maximális 100 ratebeer pontot érő sörkülönlegesség.', 'Bak búzasör', 8.2, 0.5, 700, 1100, 100),
(9, 'Schneider Weisse Aventinus Eisbock', 'Egy szállítás alkalmával elromlott a temperált eszköz, s megfagyott a híres Aventinus sör..s megszületett az Aventinus Eisbock...\r\nKlasszikus bajor búzasör illat csapja meg orrunkat. Ananász, élesztős pára, mi a sok maláta miatt párosul egy fruttis édes illatfelhővel és enyhe pörkölt felhangokkal. Ehhez leheletnyi komló társul még. Sötét dióbarna színű, élesztőtől fátyolos italunkat dús tojáshéj szín hab koronázza.\r\nA citrusos frissesség csak kevéssé jellemzi, ízeiben is hozza az ananászt és a barna búzákra oly jellemző banános aromákat. Ebbe vegyül némi kandiscukros élesztősség. Egy kicsit melegedve azonban jobban kibomlik a sör és a következő rétegben egy apátsági tripel élesztős malátásságát mutatja, majd ebből a tiszta elegáns ízből egy egész meglepő ízvilágba csap át. üde, szinte lambicos meggyes aromák után, ahogy az alkohol (12%) is kezdi éreztetni a hatását átcsap egy konyakmeggyes, majd konyakos eleganciába.', 'Jégbak', 12, 0.33, 600, 900, 1000),
(10, 'Gösser', 'A Gösser minőségében és megjelenésében egyaránt a prémium sörök egyik legjelesebb képviselője. Több mint 500 éves hagyomány alakította recept szerint, kizárólag válogatott alapanyagokból készül. Kristálytiszta, aranyló színű látványa az érintetlen természet tisztaságát idézi. Aromában gazdag, komlózott, kissé keserű íze a természet elemeinek lenyűgöző erejét juttatja eszünkbe.', 'Lager', 5, 0.5, 200, 300, 1500),
(11, 'Augustiner Edelstoff', 'Az igazi bajor \"export\"-láger, melyből egy sosem elég...', 'Lager', 5.6, 0.5, 450, 600, 1000),
(12, 'Bernard partyhordó (5 liter)', 'A Bernard igazi nagybetűs SöR, egy cseh klasszikus. Színe egészséget, teltséget sugall, egészen mélynek mondanám, és becsukott szemmel rávágnám, hogy ez egy cseh sör!\r\nA cseh sörfesztivál kedvence!', 'Lager', 5, 5, 4800, 6500, 20),
(13, 'Budweiser The king of beers', 'A világ legnépszerűbb lager söre, mely Magyarországon csak nálunk kapható! Egy korty USA...', 'Lager', 5, 0.33, 400, 600, 1000),
(14, 'Guiness Draught', 'A Guinness maga írország. A világ egyik legismertebb sörmárkája. Története 1759-ben indult, amikor Arthur Guinness ír serfőző mester évi 45 fontért 9000 évre bérbe vette a St. James Gate’s sörfőzdét. Itt kezdett spontánerjesztésű porter sörének gyártásába, amit folyamatosan fejlesztett, míg létre nem jött a tökéletes stout, a Guinness. A Guinness Extra Stout szuper prémium minőségű sör, amely sötét, rubinvörös színét az erőteljes pörkölésű malátának, finoman kesernyés ízét a magas komlótartalomnak, híresen tömör, krémszerű habját pedig a nitrogénes dúsításnak köszönheti.', 'Stout', 5, 0.33, 300, 500, 1000),
(15, 'Fóti Zwickl', 'Egy erősen komlózott, zamatos, szűretlen világos lager típusú sör.\r\nTavaszváró sörkülönlegességként mutattuk be, de a nagy érdeklődésre való tekintettel állandó termékeink közé került. A csatosüveg külön élmény!!!', 'Lager', 4.5, 0.5, 350, 500, 400),
(16, 'Katalin Cárnő', 'Elegáns, feltűnő, a világ a lábai előtt hever és lehetetlen nem észrevenni, ha belép a szobába. Szeretők versenyeznek a kegyeiért, figyelmet és hatalmat követel. Ilyen egy született uralkodó. Nagy Katalin regnálását nevezik Oroszország aranykorának. Ez a sör olyan, mintha még nem ért volna véget a birodalmi pompa.', 'Stout', 8.1, 0.33, 500, 940, 300),
(17, 'Keserű Méz', 'Intenzíven komlózott, szűretlen világos sör, a legnépszerűbb Fóti sör. 2012. júliustól palacban is forgalmazzuk. Átmeneti sör a lager, és az IPA között, csatos üvegben.\r\n\r\nA Kisüzemi Sörfőzdék Egyesülete VIII. Nemzetközi Sörversenyén 2012-ben az első helyezést érte el a világos sörök, 11 Balling feletti kategóriában.', 'Lager', 6, 0.5, 450, 600, 1000),
(18, 'Löwenbrau Oktoberfestbier', 'Az igazi müncheni \"helles\", mely könnyed, frissítő ízzel kápráztat el, minden üvegnél. Csak a müncheni az igazi!!!', 'Lager', 6, 0.5, 500, 800, 1000),
(19, 'Puntigamer', 'Osztrák világos sör', 'Lager', 5, 0.5, 300, 350, 1000),
(20, 'Samuel Adams - Boston Lager', 'A világ egyik legnépszerűbb lager söre, mely Magyarországon csak nálunk kapható! Egy korty USA...\r\nNEM HÉLIUMOS, OLYAN NEM LÉTEZIK!!!', 'Lager', 4.8, 0.33, 600, 1100, 400),
(21, 'Zlaty Bazant 1973', 'Ez bizony az eredeti, hamisítatlan Arany Fácán, egyenesen a Felvidéki Ógyalláról. A 12%-os változat az erősebb, komolyabb, emellett találkozhatunk 10%-os sörökkel is.\r\nHabja közepes, nem túl tartós, illata jellegzetes, inkább édes. Ízben pörkölt maláta aromával indul, ami karakteres komlós keserűbe fordul. Azonban a maláta édeskéje végig ott bújkál a háttérben kellemesen. Végíze marad határozott keserű, már-már pils jelleget kölcsönözve. Testességre közepes, nem híg és nem is lágy. Magyarországi licence - sajnos - nyomába sem érhet...\r\nMagyarországon csak nálunk!', 'Lager', 4.5, 0.5, 600, 900, 1200),
(22, 'Starobrno Drak extra chmelený ležák', 'Cseh import, komlós ízvilágú világos sör', 'Lager', 5.3, 0.5, 300, 450, 1100),
(23, 'Barbár Honey', 'ha valamiféle mocskos, és alantas barbár harcost vár, csalódni fog ebben a Barbar mézes belga sörben. ő olyan sör, mint amilyen barbár volt a filmben Arnold Schwarzenegger: sminkesek és jelmeztervezők sora munkálkodott azon, hogy fain legyen. a Barbár-on a sörmester munkálkodott, meg egy csapat méh. kicsi, de igen tartós habja, mély, narancssárgás, borostyán szín jellemzi a Honey-t. illatában méz és édes szőlőmust illata vegyül, enyhén karamellás ízű belga specialitás. az édes alapíz mellett jelentkező mély keserűség ellentéte az intenzív méz zamata. a korty végén csodás, kerek komlóíz marad hátra, narancshéjas fanyar ízzel párosítva. komplex jelleme jól strukturált Barbár Honey sörnek titulálja, hosszú utóízzel. nagyvonalú belga és rendkívül vallon, kifejezetten az ország franciák által lakott részére jellemző. komplexitását az árpamalátán kívül a búza, a 2,5% méztartalom, valamint a belefőzött narancspehely adja össze. emlékeztet egy oxidált, nyers tokaji aszú borra.', 'Ale', 8, 0.33, 700, 1000, 1200),
(24, 'Brew Dog Dead Pony Club', 'Telt aromájú,amerikai stílusú világos sör 3,8% alkoholtartalommal.\r\nIntenzív, komlós, ízvilágában citrusok, némi kesernye és élesztősség, fűszeresség, kellemes lecsengés.', 'IPA', 3.8, 0.33, 600, 900, 1200),
(25, 'Delirium Tremens', 'Az üveg címkéjén látható rózsaszín elefántok mutatják a Delirium Tremens belga sör mivoltát, magas alkoholtartalmú sörnek az ész nélküli fogyasztása után megjelenő látomásokat. A csapolt sör habja nem tartós, ezt kompenzálja a csodás óarany színe. A Delirium Tremens belga sör illata keveredik némi exkluzívitással, különlegességgel.\r\nA jellegzetes sörtest fölött lágy, fűszeres és malátás alapíz uralkodik, amit ezután felvált egy elsősorban alkohol, másodrészt egy harcos, keserű háttéríz, borsos, markáns felhangokkal. Az utolsó kortynál rövid keserű utóíz és hosszabb édesség követ. Ez a háromszor (tartályban, hordóban és palackban) erjesztett belga Delirium Tremens sör a bonyolult előállítási receptjével hihetetlenül összetett és strukturált ízvilágot alkot.', 'Ale', 8.5, 0.33, 600, 1100, 500),
(26, 'Flying Cloud IPA', 'Igazi cseh újhullámos IPA, telt ízzel, sűrű habbal.', 'IPA', 5.5, 0.5, 400, 580, 1000),
(27, 'Primátor English Pale Ale', 'Bár a név szerint világos ale lenne, amit kitöltéskor várnánk, igazából egy félbarna, vöröses sört kapunk, tetején egy vaskos, szivacsosan stabil piszkosfehér habbal. Már az illatból megtudhatjuk, mi is az angol fajta fözetek egyik különbözeti tényezöje. Szép gyantás, kissé citrusos komlóval operál sörünk, enyhe karamellel a háttérben. Zamatában ez a karamell a citrusos komlóval összefogva egy kellemes gyümölcsösséget generál, miközben igen könnyen csúszik sörünk. Igazi jó angol karakterrel megáldott fözet.', 'Ale', 5, 0.5, 300, 500, 1200),
(28, 'Sierra Nevada Pale Ale', 'A pale ale – sápadt sör – a 17-18. század fordulóján született. Olyan sört jelölt, melynek az alapanyagául szolgáló malátát kokszon pörkölték. Azért nevezték sápadtnak, mert az akkoriban ivott porternél sokkal sápadtabb volt. Ma ezek a pale ale-k egészen mély rézszínűek is tudnak lenni. De csak a sörfőzők hívták ezt a fajátát pale ale-nek, mert a közönség az egyszerűbb oldaláról fogta meg a dolgot, és simán bitternek, azaz keserűnek nevezte ezt a fajta sört, ami nemcsak sápadtabb, de tényleg sokkal komlósabb volt a korabeli portereknél, mildoknál', 'Ale', 5.6, 0.33, 800, 1200, 300),
(29, 'Kwak', 'sötét rézszínű belga sör, kicsiny habtartóssággal. alapvetően medikális illata mögé rejtőzik el a muskotályos illat. a Pauwels Kwak belső felépítése kizárólag hosszas kóstolás után válik egyértelművé. alapjában malátaédes jellege mögött diszkrét komlókeserűség bújik meg, mely az utóízében válik fajlagossá a Kwak. az utóízben némi csokoládé és banán íz is felfedezhető. gazdag, komplex, méltán híres belga sör. a társas diskurzusok megbecsült söre.', 'Ale', 8.4, 0.33, 500, 800, 600),
(30, 'O\'Hara\'s Irish Red', 'Ír vörös ale\r\nSzármazási hely: Írország\r\nalkoholtartalom: 4,3%\r\nfõzde:\r\nCarlow O\'Hara\r\nIgazi ír vörös sör, mely minden kortynál felfrissít! Magyarországon csak nálunk!!!', 'Ale', 4.3, 0.5, 900, 1250, 70),
(31, 'Staropramen Granát', 'Félbarna/vörös cseh lager a prágai sörgyárból.\r\nHabja szép krémes, tömött és tartós.\r\nSzí­ne világosbarna, vöröses, illata komlós. Erősen szénsavas, közepesen testes sör.\r\nÍzében a komló dominál végig, erős, határozott keserű jelleget adva. Utóí­ze száraz és komlós, a pilst idézi.', 'Lager', 4.8, 0.5, 300, 450, 500),
(32, 'Aecht Schlenkerla Weizen', 'Származási hely: Németország\r\nbajor bambergi füstölt búzasör\r\nalkoholtartalom: 5,2%\r\nfőzde: Brauerei Heller', 'Bűzasör', 5.2, 0.5, 400, 500, 400),
(33, 'Békésszentandrási Málnás búza', 'A szűretlen Málnás Búza alkoholfokát és gyümölcsösségét tekintve a tökéletes nyári sör. Valódi gyümölcsből készült málnaágyon érleljük a világ egyik legjobb búzaélesztője, a WLP300, búzamaláta, pilseni maláta, melanoidin maláta, valamint hallertau perle és magnum komlók felhasználásával. Friss kecskesajttal vagy cheddarral fogyasztva a tavaszi, nyári lazulás egyik meghatározó szereplője.', 'Bűzasör', 4.9, 0.33, 500, 700, 300),
(34, 'Edelweiss', 'Az EDELWEISS Ausztria vezető búzasöre a prémium kategóriában. Ez kimagasló minőségének és jellegzetes, gyümölcsös aromájának köszönhető, amivel az ujja, vagy inkább az üvege köré csavarja rajongóit. De külföldön is igen népszerű az EDELWEISS utánozhatatlan íze. Kétszer választották „az év legjobb sörének” (World Beer Champion), és számtalan díjat nyert a New York-i Nemzetközi Sörkupán (World Beer Cup)!\r\nAz EDELWEISS készítésénél máig ugyanazt az aprólékos receptet követik, amit annak idején 1475-ben, kristálytiszta alpesi forrásvízzel, megfelelő időt hagyva az erjedéshez. Csak így lehet belőle a lehető legjobb, felsőerjesztésű, frissítő aromájú búzasör! A főzéshez kiváló minőségű búzát és árpából készült malátát használnak fele-fele arányban.', 'Bűzasör', 5, 0.5, 300, 500, 1500),
(35, 'Hoegaarden Grand Cru', 'A Hoegarden Grand Cru tulajdonképpen a Hoegaarden Wit búzasör testvére, viszont annál jóval erősebb kiadásban. Régóta pályáztam erre a sörre, mivel a búza kiadás után úgy véltem, csak jó lehet.. És tényleg: Egy megfelelően telt színű, erősen élesztős (az élesztődarabok ott keringtek az üvegben, amikor kicsit megráztam), citrusos, narancshéjas, banános ízvilágú sör, amely az eltalált szénsavassága révén nagyon itatja magát. Erős alkoholossága egyáltalán nem jön át ezen a kavalkádon, úgy van belerejtve a 8.5%, hogy becsukott szemmel meg sem mondanám róla.', 'Bűzasör', 8.5, 0.33, 700, 990, 6000),
(36, 'Hoegaarden White 0,75l', 'Belga fehér sör. Palackban utóerjesztett, jellegénél fogva élesztőtől opálos. Különleges, frissítő ízében harmonikusan elegyednek a gyümölcsös és fűszeresen egzotikus aromák.\r\nSzervírozási rituálé: A megfelelő minőség és ízhatás érdekében a hatszög alakú poharat jól átöblítve helyezzük jég közé, hogy teljesen lehűljön. Ezután a poharat 45 fokos szögben tartva töltsük bele a sört egészen a pohár kétharmadáig. Ekkor a poharat körbe kell forgatni, hogy sör habja felélénküljön és  a leülepedett élesztő elkeveredjen. A poharat függőlegesen tartva és folyamatosan körbe forgatva töltsük ki a fennmaradó sört, hogy egy vékony, krémszerű habréteg alakuljon ki a tetején.', 'Bűzasör', 5, 0.75, 1800, 2500, 70),
(37, 'Paulaner Hefe-Weissbier Dunkel', 'Opálos barna, sötét karamell színû sör bújik meg a több centi vastag, sûrû tömött hab alatt. Illata is hasonlóan testesen adja magából a búzasörök minden karakterét, elsõ osztályon: karamellás, kissé pörkölt, kissé citrusos és fahéjas aromák, banános fenhangokkal megtûzdelve. A sör megízlelve még inkább meggyõz mindenkit arról, hogy a Paulaner fõzde igen régóta gyûjti, halmozza és alkalmazza a búzasör készítés körüli tapasztalatokat is. Kerek teste van a sörnek, nagyon szépen eltalált, kiegyensúlyozott hatások érik ízlelésünket: gyümölcsös, szinte harapható banán, hozzákeveredve némi csokoládé és enyhe pörköltségû kávé zamata vegyül szánkban némi fahéj és szegfû karakterrel. Utóízében kellemesen pörkölt és citrusos nyomokat hagy. Bajorország közepébõl azt kapja a sörkedvelõ ember, amit vár...', 'Bűzasör', 5.3, 0.5, 300, 500, 1200),
(38, 'Primátor Weizen világos búzasör', 'Ez a búza hozza a fajta klasszikus jegyeit. Szöke, enyhén karamellás színü opálos gomolygásával egy krémes habot fejleszt, mely fehér paplanként mindvégig ottmarad a felszínen. Illata citrusos, enyhén élesztös és fanyar, mind e melett gyümölcsös és füszeres. Mind illatában, mind zamatában érezhetö a banános karakter, egy enyhe fanyar zöldalmás jelleg, a füszeres szerecsendió és fahéj. Remek szomjoltó!\r\nA világ legjobb búzasöre, 2013-ban!!!', 'Bűzasör', 5, 0.5, 400, 650, 1000),
(39, 'Franziskaner Hefe Weissbier', 'A pohárba kitöltve rögtön látszódik rajta, hogy szűretlen, ugyanis a fény csak átszűrődni tud rajta, kimondottan \"búzasörösen zavaros\". Habja szép kemény, a pohár síkjából is kilépett a kitöltés során. (Ehhez a művelethez az üveg hátulján segédlet is található: Először a sör nagy részét óvatosan ki kell tölteni a korsóba, majd pedig az üveg alján kicsit hagyni, ezt jól felkeverni és egy határozott mozdulattal rátölteni a korsóban lévő sörre. Ettől belekerül az üveg aljára esetlegesen lerakódott sörélesztő, és így lesz teljes a megálmodott összkép). Illatát és ízét tekintve felsőkategóriás búzasörnek mondom, amely kellemetlen utóíztől teljesen mentes, és rendkívül jól csúszik.', 'Bűzasör', 5, 0.5, 300, 500, 100),
(40, 'Weihenstephaner Hefeweissbier', 'Klasszikus bajor, szűretlen búzasör', 'Bűzasör', 5.4, 0.5, 400, 600, 1000),
(41, 'Delirium Red', 'Kedvenc rózsaszín elefántunk leette a meggyfa teljes termését, ezért a Delirium sör már meggyes változatban is megtalálható, ami Red névre hallgat. Szerencsére igazi különleges meglepetésben lesz részünk. A Delirium Red készítése során az első osztályú Delirium Tremens friss főztjét természetes meggylével keverik össze, azután hónapokon át érlelik meggyágyon. Ennek hozománya a Delirium Red gyümölcsös sör eredeti, karakteres ízvilága, továbbá a csodás gyümölcsíz egyedi, üdítő harmóniájának egyvelege. Markáns és erőteljes gyümölcssör, mélyvörös színben pompázva. A Delirium Red belga sör csapolt változatban is fogyasztható!', 'Ale', 8.5, 0.33, 700, 1200, 8000),
(42, 'Hoegaarden Rosée (Málnás búzasör specialitás)', 'Belga gyümölcs-búzasör.', 'Bűzasör', 3, 0.2, 600, 900, 100),
(43, 'Primátor 24 fekete sör', 'Sörünkröl nem csak a 24%-os jelzés árulhat el sokat...Már amikor kitöltjük, az üvegböl való elökerülés is sokat sejtető. Olajosan, nehezen hömpölyögve terjed bele poharába, nem hatalmasra növö, de finom bézs habot fejlesztve. Illatából ez eröt sugárzó gyümölcsös melaszosság egyböl kitünik, mely az idö tovahaldtával egyre csak fejlödik. Szilva és karamel, pörkölt gabonás jegyek bukkannak fel, nehezen oldódó, vaskos illatként hömpölyögve. A korty érzékelése az illat megtestesült folytatása. Itt is tapasztaljuk a sürü, olajos testet, a melaszosan édes erősséget. Ehhez társul a megatonnányi pörkölt zamat, az enyhe rumos karakter,a szilvás gyümölcsösség. Desszertekhez kiváló igazi nagyformátumú sör, aki viszont az édesebb söröket nem kedvelei, kerülje el!\r\nA cseh sörfesztivál kedvence!', 'Stout', 10.4, 0.5, 420, 539, 300),
(44, 'Sötét Bunkó IPA', 'Az üvegből tiszta, koromfekete sör bújik elő, pöffeszkedő, tömör, bézs habot fejlesztve. A pohárból csak úgy árad a Citra komló jellegzetes gyantás aromája, az embernek olyan érzése van, mintha egy kiadós eső után baktatna egy ösvényen a végtelen fenyőerdőben, ha pedig ez nem adná meg kellően az alaphangot, előbújik még a Simcoe és a Cascade szárazabb, zöldfüves, korianderzöldes, citrusos illata is. Amúgy az aroma nagyon hasonló a Legenda Black Light IPA-jához, csak vadítóbb, orrbavágóbb, a szó legjobb értelmében. A kortyérzet szerethetően virtuóz, egy jól kivehető test mellett fel-feltűnik egy gyenge csokoládé és édeskés karamellíz, majd viharszerűen törnek be az amerikai komlók, egymás után tűnik fel a citrus, a gyanta, a vágott fű, ahogy az egy jó fekete IPA-tól várható is. A szájban erőteljesebb keserűséget hagy hátra, élesebb, nyelvháti dominanciával, a fenyőgyantás karakter pedig hosszú percekre kellemesen befesti a szájpadot.', 'IPA', 6.5, 0.33, 400, 650, 600),
(45, 'Pardubicky Porter', 'Sürü, mélyvörös-rubin sörünk egy drapp bézs habszivacs felöl osztja ránk porteres jellegét. Már illatában is olajosság érezhetö, pörkölt maláták és étcsokoládék aromája igéz. A sör teste sürü és szerteágazó, teljesen betelíti szánkat, ízeivel beteríti ízlelöbimbóinkat. Édeskésen gyümölcsös, szilvás és fügés, ami mellett egy igen érdekes fermentált tealeveles vonulat fejlödik ki. A pörkölt gabonás alapokon finoman eloszlatott csokoládés és kávés zamatok vonulnak, némi vaniliás lekerekítéssel gömbölyüvé téve a sör markáns utóízét.', 'Stout', 8, 0.5, 450, 650, 150),
(46, 'Crew Roundhouse Kick (Imperial Stout)', 'Bajor, újhullámos kézműves imperial stout. Magyarországon csak nálunk kapható!!!', 'Stout', 9.2, 0.33, 790, 1200, 500),
(47, 'Stone Americano Stout', 'coffee imperial stout\r\nSzármazási hely:  USA', 'Stout', 8.7, 0.355, 970, 1300, 150),
(48, 'Brewdog Nanny State', 'Származási hely: Skócia\r\nAlkoholmentes-alacsony alkoholtartalmú ale', 'Ale', 0.5, 0.33, 500, 810, 70),
(49, 'Büble Urbayrisch Dunkel', 'Az Allgäuer Büble Bier Barna változata az Urbayrisch Dunkel nevet viseli, és egy 5.3%-os, bajor sört jelöl. A csatos üveges ital dús habbal került ki a palackól, ám ez pár perccel a napvilágra kerülése után eltűnt. A sör íze leginkább semleges, nyoma sincs az oly\' sok barna sörre jellemző kávés-édes vonalnak, helyette szolid visszafogottságú malátásságot lehet felfedezni a kortyok végén.', 'Bak', 5.3, 0.5, 500, 700, 560),
(50, 'Wychwood Black Wych', 'Nemes anyagokból készült, mert hiába száraz és keserű, élvezet inni. A grapefruittól kezdve, csoki, kávé és az erdei bogyókig bezárólag mindenféle íz jelen van benne. Lesznek akik hiányolni fogják belőle a nagy testet, de szerintem ez így jó, ahogy van, hiba lenne változtatni rajta. ', 'Bak', 5, 0.5, 400, 670, 80);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `name`, `role`, `password`) VALUES
(1, 'Akos', 'admin', '12345'),
(2, 'Dani', 'admin', '12345'),
(3, 'Misi', 'admin', '12345'),
(11, 'Piroska', 'operator', '12345'),
(21, 'Mancika', 'finance', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoicenumber`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `invoicedproducts`
--
ALTER TABLE `invoicedproducts`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `stockid` (`stockid`),
  ADD KEY `invoicenumber` (`invoicenumber`);

--
-- Indexes for table `order1`
--
ALTER TABLE `order1`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `stock_id` (`stock_id`),
  ADD KEY `uid` (`uid`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoicenumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `invoicedproducts`
--
ALTER TABLE `invoicedproducts`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order1`
--
ALTER TABLE `order1`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`ID`);

--
-- Constraints for table `invoicedproducts`
--
ALTER TABLE `invoicedproducts`
  ADD CONSTRAINT `invoicedproducts_ibfk_1` FOREIGN KEY (`stockid`) REFERENCES `stock` (`ID`),
  ADD CONSTRAINT `invoicedproducts_ibfk_2` FOREIGN KEY (`invoicenumber`) REFERENCES `invoice` (`invoicenumber`);

--
-- Constraints for table `order1`
--
ALTER TABLE `order1`
  ADD CONSTRAINT `order1_ibfk_1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
