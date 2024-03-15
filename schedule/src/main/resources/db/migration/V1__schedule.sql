CREATE TABLE `users` (
	`id` SERIAL NOT NULL,
	`number` TEXT NOT NULL,
	`name` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`password` VARCHAR(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
	`birthday` DATE,
	`phone` VARCHAR(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;