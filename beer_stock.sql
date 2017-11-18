-- phpMyAdmin SQL Dump
-- version 4.7.5
-- https://www.phpmyadmin.net/
--
-- Host: 192.168.2.3
-- Generation Time: Nov 17, 2017 at 11:18 PM
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
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `loyaltycard` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `name`, `address`, `email`, `phone`, `loyaltycard`, `discount`) VALUES
(1, 'Reichel-Heidenreich', '76 Bonner Plaza', 'hbroek0@gmpg.org', '+33-160-251-2852', b'1', 3),
(2, 'King Inc', '151 Tomscot Point', 'emcgrae1@seesaa.net', '+86-504-139-8224', b'1', 14),
(3, 'Gottlieb Group', '7 Dahle Junction', 'dluthwood2@admin.ch', '+53-589-568-1516', b'1', 14),
(4, 'Effertz-Fritsch', '5 Northridge Junction', 'dcomello3@mozilla.org', '+63-400-539-4209', b'1', 4),
(5, 'Kreiger Inc', '763 Loftsgordon Junction', 'lbreem4@is.gd', '+34-418-301-7774', b'0', 0),
(6, 'Miller-Schaden', '0971 Vidon Circle', 'kabrashkov5@fc2.com', '+81-246-880-1881', b'1', 11),
(7, 'Raynor-Bergnaum', '8 Stone Corner Avenue', 'cdoswell6@fastcompany.com', '+1-612-498-8531', b'0', 0),
(8, 'Sanford and Sons', '054 Manufacturers Junction', 'ajoannic7@europa.eu', '+380-302-774-8592', b'1', 1),
(9, 'Watsica Group', '7 Granby Street', 'gferryman8@freewebs.com', '+252-332-872-3187', b'1', 1),
(10, 'Russel Group', '936 Mcguire Point', 'fsleigh9@newyorker.com', '+86-403-833-0527', b'0', 0),
(11, 'Brakus-Koepp', '96285 Artisan Hill', 'ravissa@eventbrite.com', '+359-401-280-5468', b'0', 0),
(12, 'Rosenbaum-Schmeler', '513 Melrose Parkway', 'lmatejab@dyndns.org', '+55-811-394-4621', b'1', 5),
(13, 'Howe, Quitzon and Rempel', '141 Northridge Alley', 'ncaneoc@networkadvertising.org', '+254-559-975-0496', b'1', 9),
(14, 'Kuhlman, Trantow and Brakus', '24967 Old Gate Crossing', 'kpengelleyd@sourceforge.net', '+86-990-961-1974', b'0', 0),
(15, 'Marquardt-Schultz', '4 Hagan Trail', 'jjohle@sakura.ne.jp', '+351-964-532-2610', b'1', 3),
(16, 'Borer-Ebert', '14 Hooker Alley', 'abowryf@symantec.com', '+502-540-742-7186', b'1', 12),
(17, 'Leannon, O\'Conner and Boyle', '2201 Drewry Lane', 'phylandg@aol.com', '+46-876-694-4352', b'1', 9),
(18, 'Monahan, Botsford and Wuckert', '6 Waxwing Park', 'liletth@unicef.org', '+86-328-705-4231', b'0', 0),
(19, 'Kris-Shields', '8797 Harbort Alley', 'acorbyni@amazonaws.com', '+86-831-285-9330', b'1', 15),
(20, 'Berge-Raynor', '1016 Main Point', 'ebaressj@businesswire.com', '+679-909-129-8089', b'1', 9),
(21, 'Stroman Inc', '72136 Vidon Avenue', 'phaddacksk@wikia.com', '+7-953-929-1468', b'1', 14),
(22, 'Emard-Crona', '40 Hayes Trail', 'etendahll@japanpost.jp', '+62-598-545-4433', b'0', 0),
(23, 'Rowe Inc', '2116 Kingsford Crossing', 'gbordism@cam.ac.uk', '+374-835-534-4242', b'0', 0),
(24, 'Dooley-Boehm', '99 Susan Avenue', 'mfilppettin@example.com', '+263-371-456-0525', b'0', 0),
(25, 'Herman-Hudson', '97 East Circle', 'adoodyo@bloglovin.com', '+689-137-643-1946', b'1', 11),
(26, 'Roob, Treutel and Kub', '93527 Emmet Center', 'alanslyp@ca.gov', '+963-739-279-0445', b'0', 0),
(27, 'Goldner, Tromp and Daniel', '15737 Packers Park', 'wbonettq@unc.edu', '+54-570-835-7799', b'0', 0),
(28, 'Ryan-Cormier', '11 Westport Junction', 'sockendonr@freewebs.com', '+66-863-250-9724', b'0', 0),
(29, 'Hagenes-Emard', '8 Cardinal Court', 'tstrovers@miibeian.gov.cn', '+86-871-170-3393', b'1', 8),
(30, 'Herman, Kutch and Feeney', '526 Bellgrove Avenue', 'aangelot@aboutads.info', '+30-481-236-1988', b'1', 11);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoicenumber` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `loyaltycard` bit(1) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`invoicenumber`, `date`, `customer_id`, `name`, `address`, `email`, `phone`, `loyaltycard`, `discount`) VALUES
(1, '2017-11-15 08:40:30', 2, 'Ez mar nem az az ugyfel, csak tesztelunk!', 'Ez mar nem az a cim, csak tesztelunk!', 'salala@trallala.com', 'ez-sem-az-a-szam', b'1', 5);

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
  `uid` varchar(20) CHARACTER SET utf8 COLLATE utf8_hungarian_ci DEFAULT NULL,
  `stock_id` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order1`
--

INSERT INTO `order1` (`ID`, `uid`, `stock_id`, `quantity`) VALUES
(1, 'Akos', 1, 10),
(2, 'Akos', 2, 20),
(3, 'Dani', 3, 30),
(4, 'Dani', 29, 30),
(5, 'Dani', 12, 10),
(6, 'Misi', 10, 50),
(7, 'Misi', 5, 20),
(8, 'Misi', 19, 100);

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
(15, 'Fóti Zwickl', 'Egy erősen komlózott, zamatos, szűretlen világos lager típusú sör.\r\nTavaszváró sörkülönlegességként mutattuk be, de a nagy érdeklődésre való tekintettel állandó termékeink közé került. A csatosüveg külön élmény!!!', 'Lager', 4.5, 0.5, 350, 500, 400),
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
(42, 'Hoegaarden Rosée (Málnás búzasör specialitás)', 'Belga gyümölcs-búzasör.', 'Bűzasör', 3, 0.2, 600, 900, 100);

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
  ADD KEY `stock_id` (`stock_id`);

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoicenumber` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `invoicedproducts`
--
ALTER TABLE `invoicedproducts`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order1`
--
ALTER TABLE `order1`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

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
