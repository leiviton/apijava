CREATE TABLE endereco_fornecedor (
	codigo BIGINT(20) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	cep VARCHAR(10) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	logradouro VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	complemento VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	numero VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	bairro VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	cidade_codigo BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	fornecedor_codigo BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	created_at TIMESTAMP NULL DEFAULT NULL,
	updated_at TIMESTAMP NULL DEFAULT NULL,
	FOREIGN KEY (cidade_codigo) REFERENCES cidade(codigo),
	FOREIGN KEY (fornecedor_codigo) REFERENCES fornecedor(codigo)

)
ENGINE=InnoDB DEFAULT CHARSET=utf8;