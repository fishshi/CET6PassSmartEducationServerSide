DROP Database IF EXISTS db_smarteducation;
CREATE Database db_smarteducation;
USE db_smarteducation;

DROP TABLE IF EXISTS `tb_download`;
CREATE TABLE `tb_download` (
    `id` int NOT NULL AUTO_INCREMENT,
    `fileName` varchar(12) DEFAULT NULL,
    `fileUrl` varchar(128) DEFAULT NULL,
    `date` date DEFAULT NULL,
    `num` tinyint DEFAULT NULL,
    `coverUrl` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tb_exam`;
CREATE TABLE `tb_exam` (
    `id` int NOT NULL AUTO_INCREMENT,
    `category` tinyint NOT NULL,
    `article` varchar(2048) NOT NULL,
    `title` varchar(256) NOT NULL,
    `options` varchar(512) NOT NULL,
    `answer` char(1) NOT NULL,
    `analysis` varchar(1024) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(16) DEFAULT NULL,
    `password` char(64) DEFAULT NULL,
    `avatarUrl` varchar(100) DEFAULT NULL,
    `email` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tb_user_ability`;
CREATE TABLE `tb_user_ability` (
    `id` int NOT NULL,
    `username` varchar(16) DEFAULT NULL,
    `ability1` tinyint DEFAULT '0',
    `ability2` tinyint DEFAULT '0',
    `ability3` tinyint DEFAULT '0',
    `ability4` tinyint DEFAULT '0',
    `ability5` tinyint DEFAULT '0',
    `ability6` tinyint DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tb_website`;
CREATE TABLE `tb_website` (
    `name` varchar(64) NOT NULL,
    `url` varchar(256) NOT NULL,
    `description` varchar(128) DEFAULT NULL,
    `icon` varchar(256) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;