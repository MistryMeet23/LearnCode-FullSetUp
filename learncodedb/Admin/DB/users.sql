-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 24, 2023 at 09:03 AM
-- Server version: 10.5.16-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id20613773_learncodedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `email` text NOT NULL,
  `number` text NOT NULL,
  `registerdate` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `number`, `registerdate`) VALUES
(2, 'Meet Mistry', 'mistrymeet6338@gmail.com', '6353918120', '2023-04-20 07:29:17'),
(3, 'niraj visvakarma', 'niraj098@gmail.com', '9586251247', '2023-04-20 07:30:07'),
(4, 'Meet Mistry', 'meet239@email.com', '9725463197', '2023-04-20 07:30:37'),
(5, 'yash mistry ', 'yash1mistry@gmail.com', '8965231478', '2023-04-20 07:31:01'),
(6, 'meet shah', 'meetshah01@gmail.com', '9764312580', '2023-04-20 07:31:20'),
(7, 'jeet shah', 'jeet111@gmail.com', '8765021346', '2023-04-20 07:31:35'),
(8, 'raj patel', 'raj123@gmail.com', '6525643958', '2023-04-20 07:32:12'),
(9, 'nimesh patil', 'patil143@gmail.com', '6352419780', '2023-04-20 07:32:39'),
(10, 'lisha a shah', 'lisha143@gmail.com', '9510631226', '2023-04-20 07:33:01'),
(11, 'brijal patel', 'bri143@gmail.com', '9510631225', '2023-04-20 07:33:22'),
(12, 'jina banum', 'jina786@gmail.com', '8965231470', '2023-04-20 07:34:18'),
(13, 'alia saikh', 'aila777@gmail.com', '9632580741', '2023-04-20 07:34:42'),
(14, 'daji mahomad', 'daji7825@gmail.com', '7854213690', '2023-04-20 07:35:05'),
(15, 'zoya Cristian ', 'zoya143@gmail.com', '8523697104', '2023-04-20 07:35:31'),
(16, 'Patel Aayushi ', 'patelayushi1928@gmail.com', '9664637209', '2023-04-20 08:27:39'),
(19, 'Meet', 'mistrymeetn23@gmail.com', '9925100927', '2023-04-20 08:40:59'),
(20, 'Meet Mistry ', 'mistrymeet2318@gmail.com', '6353918120', '2023-04-20 19:29:56'),
(21, 'Meet Mistry', 'mistrymeet09@gmail.com', '9925100927', '2023-04-21 01:11:27'),
(22, 'Gunjan Mistry ', 'gunjan21@gmail.com', '9925100927', '2023-04-21 16:14:22'),
(23, 'Vidhi Mistry', 'vidhidmistry123@gmail.com', '7043761572', '2023-04-21 16:31:07'),
(24, 'Vishakha ', 'vishakha4802@gmail.com', '7874654058', '2023-04-21 16:34:21'),
(27, 'Meet Panchal', 'meetujp230404@gmail.com', '9998421870', '2023-04-21 16:42:44'),
(28, 'jayendra Master ', 'masterjeet29@gmail.com', '9313747133', '2023-04-21 16:47:25'),
(29, 'Jinal Patel', 'pateljinal23947@gmail.com', '9106173439', '2023-04-21 16:57:22'),
(30, 'Diya Tandel', 'tandeld570@gmail.com', '9979559989', '2023-04-21 17:06:22'),
(31, 'Kenil Patel', 'kenilpatel2593@gmail.com', '7096292593', '2023-04-21 17:25:13'),
(32, 'Brijal Patel', 'brijalpatel7125@gmail.com', '9106808868', '2023-04-21 19:09:30'),
(33, 'Deep Mistry', 'deepmistry342@gmail.com', '9265177430', '2023-04-22 00:38:31'),
(34, 'shukla pooja', 'shuklapooja1509krishna@gmail.com', '8160724272', '2023-04-22 03:02:14'),
(35, 'Jenish Patel', '6718jenishpatel@stjosephbilimora.com', '9727937373', '2023-04-22 04:22:44'),
(40, 'iron ', 'ironwomen1711@gmail.com', '8200870709', '2023-04-22 07:30:19'),
(41, 'MAHEK KEVAT', 'mahekjkevat@gmail.com', '9537803676', '2023-04-22 10:15:12'),
(42, 'Neel Gandhi', 'neelg2231@gmail.com', '6353208391', '2023-04-22 10:33:35'),
(43, 'chhaya', 'gohilchhaya58@gmail.com', '9313595984', '2023-04-23 15:52:40'),
(44, 'darsh motwani', 'darshbruh@gmail.com', '8866257709', '2023-04-23 17:14:13'),
(45, 'ddd', 'ddd@dddd.com', '9565556556', '2023-04-24 02:07:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
