-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 30/05/2022 às 15:18
-- Versão do servidor: 10.4.24-MariaDB
-- Versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ksa`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `level` int(11) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `skill`
--

INSERT INTO `skill` (`id`, `name`, `level`, `description`) VALUES
(4, 'Remember', 1, 'Retrieve, recall, or recognize relevant knowledge from long-term memory (e.g., recall dates of important events in U.S. history, remember the components of a bacterial cell).'),
(5, 'Understand', 2, 'Demonstrate comprehension through one or more forms of explanation (e.g., classify a mental illness, compare ritual practices in two different religions).'),
(6, 'Apply', 3, 'Use information or a skill in a new situation (e.g., use Newton´s second law to solve a problem for which it is appropriate, carry out a multivariate statistical analysis using a data set not previously encountered).'),
(7, 'Analyze', 4, 'Break material into its constituent parts and determine how the parts relate to one another and/or to an overall structure or purpose (e.g., analyze the relationship between different flora and fauna in an ecological setting; analyze the relationship between different characters in a play; analyze the relationship between different institutions in a society).'),
(8, 'Evaluate', 5, 'Make judgments based on criteria and standards (e.g., detect inconsistencies or fallacies within a process or product, determine whether a scientist´s conclusions follow from observed data, judge which of two methods is the way to solve a given problem, determine the quality of a product based on disciplinary criteria).'),
(9, 'Create', 6, 'Put elements together to form a new coherent or functional whole; reorganize elements into a new pattern or structure (design a new set for a theater production, write a thesis, develop an alternative hypothesis based on criteria, invent a product, compose a piece of music, write a play).');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
