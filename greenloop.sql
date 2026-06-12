-- GreenLoop – Eco-Friendly Packaging Management System
-- Database: greenloop
-- Generated for OOP Java Project 2026

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
SET NAMES utf8mb4;

-- Create and use database
CREATE DATABASE IF NOT EXISTS `greenloop` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `greenloop`;

-- --------------------------------------------------------
-- Table: products
-- --------------------------------------------------------

DROP TABLE IF EXISTS `products`;
CREATE TABLE IF NOT EXISTS `products` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `ecoRating` varchar(10) DEFAULT NULL COMMENT 'e.g. A+, A, B, C',
  `stockQuantity` int NOT NULL DEFAULT 0,
  `reorderLevel` int NOT NULL DEFAULT 10,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

INSERT INTO `products` (`name`, `description`, `price`, `ecoRating`, `stockQuantity`, `reorderLevel`) VALUES
('Biodegradable Wrap 1m', 'Compostable food-safe wrap, 1 meter roll', 120.00, 'A+', 250, 30),
('Recycled Box Medium', 'Medium corrugated recycled cardboard box', 85.00, 'A', 180, 20),
('Compostable Bag 5kg', 'Plant-based compostable bag, 5kg capacity', 45.00, 'A+', 8, 15),
('Eco Bubble Wrap 50cm', 'Air-cushion wrap made from recycled plastic', 200.00, 'B', 95, 25),
('Paper Tape Roll', 'Kraft paper adhesive tape, 50m roll', 55.00, 'A', 5, 10);

-- --------------------------------------------------------
-- Table: clients
-- --------------------------------------------------------

DROP TABLE IF EXISTS `clients`;
CREATE TABLE IF NOT EXISTS `clients` (
  `clientId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `businessType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`clientId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

INSERT INTO `clients` (`name`, `email`, `phone`, `address`, `businessType`) VALUES
('Nimal Stores', 'nimalstores@gmail.com', '0771234567', '45 Galle Road, Colombo 03', 'Supermarket'),
('Green Basket PVT', 'greenbasket@outlook.com', '0712345678', '12 High Street, Kandy', 'Organic Grocery'),
('EcoMart Lanka', 'ecomart@gmail.com', '0768765432', '88 Main Street, Negombo', 'Retail Chain'),
('Sanda Organics', 'sanda@organics.lk', '0754321098', '22 Temple Road, Galle', 'Health Food Store');

-- --------------------------------------------------------
-- Table: delivery_agents
-- --------------------------------------------------------

DROP TABLE IF EXISTS `delivery_agents`;
CREATE TABLE IF NOT EXISTS `delivery_agents` (
  `agentId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `vehicleType` varchar(50) DEFAULT NULL,
  `vehicleNumber` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT 'Available',
  PRIMARY KEY (`agentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

INSERT INTO `delivery_agents` (`name`, `email`, `phone`, `vehicleType`, `vehicleNumber`, `status`) VALUES
('Kamal Perera', 'kamal.perera@gmail.com', '0776543210', 'Van', 'WP-CAB-1234', 'Available'),
('Suresh Silva', 'suresh.silva@gmail.com', '0712223334', 'Motorbike', 'WP-9876', 'On Delivery'),
('Nadeeka Fernando', 'nadeeka.f@gmail.com', '0769988776', 'Lorry', 'WP-LOR-5678', 'Available');

-- --------------------------------------------------------
-- Table: orders
-- --------------------------------------------------------

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `clientId` int NOT NULL,
  `orderDate` date NOT NULL,
  `totalAmount` double NOT NULL DEFAULT 0,
  `status` varchar(50) NOT NULL DEFAULT 'Pending',
  `deliveryAddress` varchar(255) DEFAULT NULL,
  `agentId` int DEFAULT 0,
  PRIMARY KEY (`orderId`),
  KEY `fk_order_client` (`clientId`),
  KEY `fk_order_agent` (`agentId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

INSERT INTO `orders` (`clientId`, `orderDate`, `totalAmount`, `status`, `deliveryAddress`, `agentId`) VALUES
(1, '2026-06-01', 1200.00, 'Delivered', '45 Galle Road, Colombo 03', 1),
(2, '2026-06-05', 850.00, 'Dispatched', '12 High Street, Kandy', 2),
(3, '2026-06-10', 2250.00, 'Processing', '88 Main Street, Negombo', 0),
(4, '2026-06-12', 560.00, 'Pending', '22 Temple Road, Galle', 0);

-- --------------------------------------------------------
-- Table: order_items
-- --------------------------------------------------------

DROP TABLE IF EXISTS `order_items`;
CREATE TABLE IF NOT EXISTS `order_items` (
  `itemId` int NOT NULL AUTO_INCREMENT,
  `orderId` int NOT NULL,
  `productId` int NOT NULL,
  `quantity` int NOT NULL,
  `unitPrice` double NOT NULL,
  PRIMARY KEY (`itemId`),
  KEY `fk_item_order` (`orderId`),
  KEY `fk_item_product` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

INSERT INTO `order_items` (`orderId`, `productId`, `quantity`, `unitPrice`) VALUES
(1, 1, 5, 120.00),
(1, 2, 4, 85.00),
(2, 3, 10, 45.00),
(3, 4, 8, 200.00),
(3, 5, 5, 55.00),
(4, 1, 2, 120.00),
(4, 3, 4, 45.00);

COMMIT;
