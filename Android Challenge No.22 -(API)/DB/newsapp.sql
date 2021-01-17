-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2021 at 07:21 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newsapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cat_id` int(3) NOT NULL,
  `cat_title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_title`) VALUES
(1, 'political'),
(2, 'sport'),
(3, 'odds');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(3) NOT NULL,
  `news_title` varchar(255) NOT NULL,
  `news_details` text NOT NULL,
  `news_images` text NOT NULL,
  `news_date` date NOT NULL,
  `cat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`id`, `news_title`, `news_details`, `news_images`, `news_date`, `cat_id`) VALUES
(6, '\r\nUS takes back its assertion that Capitol rioters wanted to \'capture and assassinate\' officials', 'Washington Post: Capitol Police intelligence report warned of violence targeting \'Congress itself\' three days before attack\r\nPentagon authorizes 25,000 National Guard members for inauguration', 'https://cdn.cnn.com/cnnnext/dam/assets/210109181944-jacob-anthony-chansley-large-tease.jpg', '2021-01-30', 1),
(7, 'Trump\'s been impeached again. What\'s next?', 'The question now is whether he\'ll become the first President to be convicted by the Senate and removed from office.\r\nWhat\'s next? Impeachment in a two-part process. The House introduces and passes the articles of impeachment, but the Senate is where the person being impeached faces a trial -- and potential punishment.', 'https://cdn.cnn.com/cnnnext/dam/assets/210108101156-22-us-capitol-riots-0106-medium-plus-169.jpg', '2021-01-22', 1),
(8, '\r\nUS takes back its assertion that Capitol rioters wanted to \'capture and assassinate\' officials', 'Washington Post: Capitol Police intelligence report warned of violence targeting \'Congress itself\' three days before attack\r\nPentagon authorizes 25,000 National Guard members for inauguration', 'https://cdn.cnn.com/cnnnext/dam/assets/210109181944-jacob-anthony-chansley-large-tease.jpg', '2021-01-30', 1),
(9, 'Trump\'s been impeached again. What\'s next?', 'The question now is whether he\'ll become the first President to be convicted by the Senate and removed from office.\r\nWhat\'s next? Impeachment in a two-part process. The House introduces and passes the articles of impeachment, but the Senate is where the person being impeached faces a trial -- and potential punishment.', 'https://cdn.cnn.com/cnnnext/dam/assets/210108101156-22-us-capitol-riots-0106-medium-plus-169.jpg', '2021-01-22', 1),
(10, 'Liverpool v Manchester United: Jurgen Klopp says \'I have no skills for mind games\'', 'Liverpool boss Jurgen Klopp said he is not like Sir Alex Ferguson and has \"no skills for mind games\" as he faced questions about Sunday\'s match against league leaders Manchester United.\r\nThe bitter rivals find themselves first and second in the table, with United leading the champions by three points.', 'https://cdn.images.express.co.uk/img/dynamic/galleries/590x350/388759.jpg', '2021-01-04', 2),
(11, 'Lucas Piazon: Chelsea\'s longest-serving player finally departs Stamford Bridge permanently', 'The 26-year-old Brazilian, remarkably, was the longest-serving player in their current squad, having joined in 2011 and, in theory at least, worked under eight different managers.\r\nIn reality, though, that work usually amounted to a bit of pre-season training followed by the news he was being shipped off elsewhere for the season.\r\nThe attacking midfielder\'s transfer to Braga means that, at 26, he finally has a permanent home, having played in Spain, the Netherlands, Germany, Italy and Portugal while on Chelsea\'s books, not to mention spells in the Championship with Reading and Fulham.', 'https://ichef.bbci.co.uk/onesport/cps/800/cpsprodpb/FD04/production/_116527746_gettyimages-1012875530.jpg', '2021-01-05', 2),
(12, 'Liverpool v Manchester United: Jurgen Klopp says \'I have no skills for mind games\'', 'Liverpool boss Jurgen Klopp said he is not like Sir Alex Ferguson and has \"no skills for mind games\" as he faced questions about Sunday\'s match against league leaders Manchester United.\r\nThe bitter rivals find themselves first and second in the table, with United leading the champions by three points.', 'https://cdn.images.express.co.uk/img/dynamic/galleries/590x350/388759.jpg', '2021-01-04', 2),
(13, 'Lucas Piazon: Chelsea\'s longest-serving player finally departs Stamford Bridge permanently', 'The 26-year-old Brazilian, remarkably, was the longest-serving player in their current squad, having joined in 2011 and, in theory at least, worked under eight different managers.\r\nIn reality, though, that work usually amounted to a bit of pre-season training followed by the news he was being shipped off elsewhere for the season.\r\nThe attacking midfielder\'s transfer to Braga means that, at 26, he finally has a permanent home, having played in Spain, the Netherlands, Germany, Italy and Portugal while on Chelsea\'s books, not to mention spells in the Championship with Reading and Fulham.', 'https://ichef.bbci.co.uk/onesport/cps/800/cpsprodpb/FD04/production/_116527746_gettyimages-1012875530.jpg', '2021-01-05', 2),
(14, 'What are stony forests?', 'Stone forests are one of the amazing geological formations in nature, and they are common in certain areas of China and Madagascar, and according to scientists, these pointed rock formations, such as the famous stone forest in Yunnan Province of China, are the result of the melting of solids in liquids with the presence of gravity, which It produces natural convection flows.', 'https://images.alarab.com/data/news/2020/11/28/iStock-1169820768.jpg', '2021-01-12', 3),
(15, 'Because of a \"bite\" ... the death of a French man with rabies', 'Analyzes of a French hospital revealed that a man died of rabies, after being bitten or scratched by a bat, which is \"unexpected\" news that comes at a time when the country and the whole world are busy with the outbreak of the new Corona virus.\r\n\r\nA man died with rabies in central France, after being bitten or scratched by a bat that was in the attic of his house, according to what was reported Wednesday by the Pasteur Institute, which explained that this case is the first of its kind in France.\r\n\r\nAnd the man in his sixties passed away from life in Limoges, due to his infection of encephalitis, the cause of which was not known at the time in August 2019, but new tests showed that he had rabies.\r\nA genetic analysis of samples taken from the man\'s body was carried out after his death, as part of a partnership between the Parisian Necker Hospital and the Institut Pasteur aimed at identifying the causes of undocumented encephalitis.', 'https://images.alarab.com/data/news//2021/01/07//150x81/20210107142136.jpg', '2021-01-16', 3),
(16, 'What are stony forests?', 'Stone forests are one of the amazing geological formations in nature, and they are common in certain areas of China and Madagascar, and according to scientists, these pointed rock formations, such as the famous stone forest in Yunnan Province of China, are the result of the melting of solids in liquids with the presence of gravity, which It produces natural convection flows.', 'https://images.alarab.com/data/news/2020/11/28/iStock-1169820768.jpg', '2021-01-12', 3),
(17, 'Because of a \"bite\" ... the death of a French man with rabies', 'Analyzes of a French hospital revealed that a man died of rabies, after being bitten or scratched by a bat, which is \"unexpected\" news that comes at a time when the country and the whole world are busy with the outbreak of the new Corona virus.\r\n\r\nA man died with rabies in central France, after being bitten or scratched by a bat that was in the attic of his house, according to what was reported Wednesday by the Pasteur Institute, which explained that this case is the first of its kind in France.\r\n\r\nAnd the man in his sixties passed away from life in Limoges, due to his infection of encephalitis, the cause of which was not known at the time in August 2019, but new tests showed that he had rabies.\r\nA genetic analysis of samples taken from the man\'s body was carried out after his death, as part of a partnership between the Parisian Necker Hospital and the Institut Pasteur aimed at identifying the causes of undocumented encephalitis.', 'https://images.alarab.com/data/news//2021/01/07//150x81/20210107142136.jpg', '2021-01-16', 3),
(18, 'Lucas Piazon: Chelsea\'s longest-serving player finally departs Stamford Bridge permanently', 'The 26-year-old Brazilian, remarkably, was the longest-serving player in their current squad, having joined in 2011 and, in theory at least, worked under eight different managers.\r\nIn reality, though, that work usually amounted to a bit of pre-season training followed by the news he was being shipped off elsewhere for the season.\r\nThe attacking midfielder\'s transfer to Braga means that, at 26, he finally has a permanent home, having played in Spain, the Netherlands, Germany, Italy and Portugal while on Chelsea\'s books, not to mention spells in the Championship with Reading and Fulham.', 'https://ichef.bbci.co.uk/onesport/cps/800/cpsprodpb/FD04/production/_116527746_gettyimages-1012875530.jpg', '2021-01-05', 2),
(19, 'Liverpool v Manchester United: Jurgen Klopp says \'I have no skills for mind games\'', 'Liverpool boss Jurgen Klopp said he is not like Sir Alex Ferguson and has \"no skills for mind games\" as he faced questions about Sunday\'s match against league leaders Manchester United.\r\nThe bitter rivals find themselves first and second in the table, with United leading the champions by three points.', 'https://cdn.images.express.co.uk/img/dynamic/galleries/590x350/388759.jpg', '2021-01-04', 2),
(20, 'Lucas Piazon: Chelsea\'s longest-serving player finally departs Stamford Bridge permanently', 'The 26-year-old Brazilian, remarkably, was the longest-serving player in their current squad, having joined in 2011 and, in theory at least, worked under eight different managers.\r\nIn reality, though, that work usually amounted to a bit of pre-season training followed by the news he was being shipped off elsewhere for the season.\r\nThe attacking midfielder\'s transfer to Braga means that, at 26, he finally has a permanent home, having played in Spain, the Netherlands, Germany, Italy and Portugal while on Chelsea\'s books, not to mention spells in the Championship with Reading and Fulham.', 'https://ichef.bbci.co.uk/onesport/cps/800/cpsprodpb/FD04/production/_116527746_gettyimages-1012875530.jpg', '2021-01-05', 2),
(21, 'What are stony forests?', 'Stone forests are one of the amazing geological formations in nature, and they are common in certain areas of China and Madagascar, and according to scientists, these pointed rock formations, such as the famous stone forest in Yunnan Province of China, are the result of the melting of solids in liquids with the presence of gravity, which It produces natural convection flows.', 'https://images.alarab.com/data/news/2020/11/28/iStock-1169820768.jpg', '2021-01-12', 3),
(22, 'Because of a \"bite\" ... the death of a French man with rabies', 'Analyzes of a French hospital revealed that a man died of rabies, after being bitten or scratched by a bat, which is \"unexpected\" news that comes at a time when the country and the whole world are busy with the outbreak of the new Corona virus.\r\n\r\nA man died with rabies in central France, after being bitten or scratched by a bat that was in the attic of his house, according to what was reported Wednesday by the Pasteur Institute, which explained that this case is the first of its kind in France.\r\n\r\nAnd the man in his sixties passed away from life in Limoges, due to his infection of encephalitis, the cause of which was not known at the time in August 2019, but new tests showed that he had rabies.\r\nA genetic analysis of samples taken from the man\'s body was carried out after his death, as part of a partnership between the Parisian Necker Hospital and the Institut Pasteur aimed at identifying the causes of undocumented encephalitis.', 'https://images.alarab.com/data/news//2021/01/07//150x81/20210107142136.jpg', '2021-01-16', 3),
(23, '\r\nUS takes back its assertion that Capitol rioters wanted to \'capture and assassinate\' officials', 'Washington Post: Capitol Police intelligence report warned of violence targeting \'Congress itself\' three days before attack\r\nPentagon authorizes 25,000 National Guard members for inauguration', 'https://cdn.cnn.com/cnnnext/dam/assets/210109181944-jacob-anthony-chansley-large-tease.jpg', '2021-01-30', 1),
(24, 'Trump\'s been impeached again. What\'s next?', 'The question now is whether he\'ll become the first President to be convicted by the Senate and removed from office.\r\nWhat\'s next? Impeachment in a two-part process. The House introduces and passes the articles of impeachment, but the Senate is where the person being impeached faces a trial -- and potential punishment.', 'https://cdn.cnn.com/cnnnext/dam/assets/210108101156-22-us-capitol-riots-0106-medium-plus-169.jpg', '2021-01-22', 1),
(25, '\r\nUS takes back its assertion that Capitol rioters wanted to \'capture and assassinate\' officials', 'Washington Post: Capitol Police intelligence report warned of violence targeting \'Congress itself\' three days before attack\r\nPentagon authorizes 25,000 National Guard members for inauguration', 'https://cdn.cnn.com/cnnnext/dam/assets/210109181944-jacob-anthony-chansley-large-tease.jpg', '2021-01-30', 1),
(26, 'Trump\'s been impeached again. What\'s next?', 'The question now is whether he\'ll become the first President to be convicted by the Senate and removed from office.\r\nWhat\'s next? Impeachment in a two-part process. The House introduces and passes the articles of impeachment, but the Senate is where the person being impeached faces a trial -- and potential punishment.', 'https://cdn.cnn.com/cnnnext/dam/assets/210108101156-22-us-capitol-riots-0106-medium-plus-169.jpg', '2021-01-22', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cat_id` (`cat_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cat_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `news_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
