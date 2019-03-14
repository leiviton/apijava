CREATE TABLE `estado` (
	`codigo` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`estado` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`uf` CHAR(2) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`codigo`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;

CREATE TABLE `cidade` (
	`codigo` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`cidade` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`estado_codigo` BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`codigo`),
	INDEX `cidade_estado_codigo_foreign` (`estado_codigo`),
	CONSTRAINT `cidade_estado_codigo_foreign` FOREIGN KEY (`estado_codigo`) REFERENCES `estado` (`codigo`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;

