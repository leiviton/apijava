CREATE TABLE `cliente_empresa` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`razao_social` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`nome_fantasia` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`cnpj` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`inscricao_estadual` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`cep` VARCHAR(20) NULL DEFAULT '37.800-000' COLLATE 'utf8mb4_unicode_ci',
	`endereco` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`numero` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`complemento` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`bairro` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`cidade` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`estado` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`telefone` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`whatsapp` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`site` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`responsavel` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`cpf_responsavel` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;

INSERT INTO `cliente_empresa` (`id`, `razao_social`, `nome_fantasia`, `cnpj`, `inscricao_estadual`, `cep`, `endereco`, `numero`, `complemento`, `bairro`, `cidade`, `estado`, `telefone`, `whatsapp`, `site`, `responsavel`, `cpf_responsavel`, `created_at`, `updated_at`) VALUES (1, 'GUILHERME AUGUSTO CARDOSO', 'Eguis alimentação saudavel', '27.318.729/0001-67', '0029313870037', '37.800-000', 'Avenida Conde Ribeiro do Valle', '681', '', 'Centro', 'Guaxupé', 'MG', '(35) 3551-3770', '+55(35) 9809-0959', 'http://eguis.com.br', 'GUILHERME AUGUSTO CARDOSO', '', NULL, NULL);
