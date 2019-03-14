CREATE TABLE `mesas` (
	`codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
	`nome` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_unicode_ci',
	`descricao` VARCHAR(191) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	`status` VARCHAR(10) NULL DEFAULT 'ativo',
	`created_at` TIMESTAMP NULL DEFAULT NULL,
	`updated_at` TIMESTAMP NULL DEFAULT NULL,
	cliente_empresa_codigo BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	FOREIGN KEY (`cliente_empresa_codigo`) REFERENCES `cliente_empresa` (`id`),
	PRIMARY KEY (`codigo`)
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB;

insert into mesas values(1,'Mesa 1','Mesa 1','ativo',null,null,1);
insert into mesas values(2,'Mesa 2','Mesa 2','ativo',null,null,1);
insert into mesas values(3,'Mesa 3','Mesa 3','ativo',null,null,1);
insert into mesas values(4,'Mesa 4','Mesa 4','ativo',null,null,1);