CREATE TABLE `cliente` (
	`codigo` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(191) NOT NULL DEFAULT 'Consumidor Final' COLLATE 'utf8mb4_unicode_ci',
	`telefone` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`status` CHAR(10) NOT NULL DEFAULT 'ativo',
	`endereco_codigo` BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	`cliente_empresa_codigo` BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`codigo`),
	INDEX `endereco_codigo_foreign` (`endereco_codigo`),
	CONSTRAINT `endereco_codigo_foreign` FOREIGN KEY (`endereco_codigo`) REFERENCES `endereco` (`codigo`),
	FOREIGN KEY (`cliente_empresa_codigo`) REFERENCES `cliente_empresa` (`id`)	
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;
