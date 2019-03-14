CREATE TABLE categoria(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cliente_empresa_codigo BIGINT(20) UNSIGNED NULL DEFAULT NULL,
	FOREIGN KEY (`cliente_empresa_codigo`) REFERENCES `cliente_empresa` (`id`)	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO categoria values (null,'Lazer',1);
INSERT INTO categoria values (null,'Alimentação',1);
INSERT INTO categoria values (null,'Supermercado',1);
INSERT INTO categoria values (null,'Farmácia',1);
INSERT INTO categoria values (null,'Informatica',1);