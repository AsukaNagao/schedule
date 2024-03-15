CREATE TABLE `allschedule` (
	`id` SERIAL NOT NULL,
	`number` VARCHAR(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`datetime` DATETIME NOT NULL,
	`title` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	`detail` VARCHAR(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;