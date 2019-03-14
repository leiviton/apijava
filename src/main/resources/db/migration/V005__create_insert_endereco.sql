CREATE TABLE `endereco` (
	`codigo` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`cep` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`logradouro` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`complemento` VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	`numero` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`bairro` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`cidade_codigo` BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`codigo`),
	INDEX `endereco_cidade_codigo_foreign` (`cidade_codigo`),
	CONSTRAINT `endereco_cidade_codigo_foreign` FOREIGN KEY (`cidade_codigo`) REFERENCES `cidade` (`codigo`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
AUTO_INCREMENT=480
;
