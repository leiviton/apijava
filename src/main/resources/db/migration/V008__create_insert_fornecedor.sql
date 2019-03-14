CREATE TABLE fornecedor (
	codigo BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	razao_social VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	nome_fantasia VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	nome VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	cnpj VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	cpf VARCHAR(20) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	telefone VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	status CHAR(10) NOT NULL DEFAULT 'ativo' COLLATE 'utf8mb4_unicode_ci',
	created_at TIMESTAMP NULL DEFAULT NULL,
	updated_at TIMESTAMP NULL DEFAULT NULL,
	cliente_empresa_codigo BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	FOREIGN KEY (`cliente_empresa_codigo`) REFERENCES `cliente_empresa` (`id`)	,
	PRIMARY KEY (codigo)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;