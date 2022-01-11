-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 12 Sty 2022, 00:27
-- Wersja serwera: 10.4.21-MariaDB
-- Wersja PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `parking`
--
CREATE DATABASE IF NOT EXISTS `parking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `parking`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `parking`
--

DROP TABLE IF EXISTS `parking`;
CREATE TABLE `parking` (
  `idParkowania` int(11) NOT NULL,
  `idSamochodu` int(11) NOT NULL,
  `dataParkowania` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `parking`
--

INSERT INTO `parking` (`idParkowania`, `idSamochodu`, `dataParkowania`) VALUES
(1, 1, '2022-01-03'),
(2, 1, '2022-01-20'),
(3, 10, '2021-10-19'),
(4, 8, '2021-09-21'),
(5, 13, '2022-01-02'),
(6, 8, '2021-12-21'),
(7, 8, '2021-12-31'),
(8, 3, '2021-11-07'),
(9, 5, '2021-08-01'),
(10, 7, '2021-06-14'),
(11, 12, '2021-12-14');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `samochody`
--

DROP TABLE IF EXISTS `samochody`;
CREATE TABLE `samochody` (
  `idSamochodu` int(11) NOT NULL,
  `markaSamochodu` varchar(50) NOT NULL,
  `pojemnoscSilnika` double(20,1) NOT NULL,
  `numerRejestracyjny` varchar(12) NOT NULL,
  `nazwiskoWlasciciela` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Zrzut danych tabeli `samochody`
--

INSERT INTO `samochody` (`idSamochodu`, `markaSamochodu`, `pojemnoscSilnika`, `numerRejestracyjny`, `nazwiskoWlasciciela`) VALUES
(1, 'Renault', 1.6, 'LBL12345', 'Kowalski'),
(2, 'Audi', 1.9, 'RZ54321', 'Nowak'),
(3, 'Renault', 1.0, 'LU99923', 'Kowalski'),
(5, 'Alfa Romeo', 2.0, 'DLE06789', 'Szymański'),
(6, 'Mazda', 1.8, 'DLU19832', 'Kapka'),
(7, 'Subaru', 2.0, 'DW1664', 'Jabłońska'),
(8, 'Ford', 5.0, 'LBL7777', 'Suchta'),
(9, 'Subaru', 1.5, 'LU16607', 'Kapica'),
(10, 'Opel', 1.4, 'RZ88888', 'Podolak'),
(11, 'Opel', 2.0, 'RLE97654', 'Pisklak'),
(12, 'BMW', 2.2, 'LHR56789', 'Hrubiesz'),
(13, 'Toyota', 1.6, 'KRK3456', 'Król'),
(14, 'Suzuki', 3.0, 'LBL45678', 'Taktakowski');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `parking`
--
ALTER TABLE `parking`
  ADD PRIMARY KEY (`idParkowania`),
  ADD KEY `idSamochodu` (`idSamochodu`);

--
-- Indeksy dla tabeli `samochody`
--
ALTER TABLE `samochody`
  ADD PRIMARY KEY (`idSamochodu`),
  ADD UNIQUE KEY `numerRejestracyjny` (`numerRejestracyjny`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `parking`
--
ALTER TABLE `parking`
  MODIFY `idParkowania` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT dla tabeli `samochody`
--
ALTER TABLE `samochody`
  MODIFY `idSamochodu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `parking`
--
ALTER TABLE `parking`
  ADD CONSTRAINT `parking_ibfk_1` FOREIGN KEY (`idSamochodu`) REFERENCES `samochody` (`idSamochodu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
