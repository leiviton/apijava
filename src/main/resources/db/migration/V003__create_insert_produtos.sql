CREATE TABLE produto (
	codigo BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	categoria_codigo BIGINT(20)  NOT NULL,
	cliente_empresa_codigo BIGINT(20) UNSIGNED NULL,
	nome VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	descricao TEXT NOT NULL COLLATE 'utf8mb4_unicode_ci',
	preco DECIMAL(8,2) NOT NULL,
	bar_code VARCHAR(14) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	created_at TIMESTAMP NULL DEFAULT NULL,
	updated_at TIMESTAMP NULL DEFAULT NULL,
	status SMALLINT(6) NOT NULL DEFAULT '0',
	PRIMARY KEY (codigo),
	INDEX categoria_codigo_foreign (categoria_codigo),
	CONSTRAINT categoria_codigo_foreign FOREIGN KEY (categoria_codigo) REFERENCES categoria (codigo),
	INDEX `cliente_empresa_codigo` (`cliente_empresa_codigo`),
	CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`cliente_empresa_codigo`) REFERENCES `cliente_empresa` (`id`)	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO produto (`codigo`, `categoria_codigo`, `cliente_empresa_codigo`, `nome`, `descricao`, `preco`, `bar_code`, `created_at`, `updated_at`, `status`) VALUES (null, 1,1, 'Eguis 1', 'Super tenro de palmito fatiado e delicioso mix de alface e cenoura.', 34.90, NULL, '2018-01-02 09:38:18', '2018-01-21 16:52:07', 0);

INSERT INTO produto (`codigo`, `categoria_codigo`, `cliente_empresa_codigo`, `nome`, `descricao`, `preco`, `bar_code`, `created_at`, `updated_at`, `status`) VALUES (null, 1,1, 'Eguis 1', 'Super tenro de palmito fatiado e delicioso mix de alface e cenoura.', 34.90, NULL, '2018-01-02 09:38:18', '2018-01-21 16:52:07', 0);

INSERT INTO produto (`codigo`, `categoria_codigo`, `cliente_empresa_codigo`, `nome`, `descricao`, `preco`, `bar_code`, `created_at`, `updated_at`, `status`) VALUES (null, 1,1, 'Eguis 1', 'Super tenro de palmito fatiado e delicioso mix de alface e cenoura.', 34.90, NULL, '2018-01-02 09:38:18', '2018-01-21 16:52:07', 0);

INSERT INTO produto (`codigo`, `categoria_codigo`, `cliente_empresa_codigo`, `nome`, `descricao`, `preco`, `bar_code`, `created_at`, `updated_at`, `status`) VALUES (null, 1,1, 'Eguis 1', 'Super tenro de palmito fatiado e delicioso mix de alface e cenoura.', 34.90, NULL, '2018-01-02 09:38:18', '2018-01-21 16:52:07', 0);
INSERT INTO produto (`codigo`, `categoria_codigo`, `cliente_empresa_codigo`, `nome`, `descricao`, `preco`, `bar_code`, `created_at`, `updated_at`, `status`) VALUES (null, 1,1, 'Eguis 1', 'Super tenro de palmito fatiado e delicioso mix de alface e cenoura.', 34.90, NULL, '2018-01-02 09:38:18', '2018-01-21 16:52:07', 0);