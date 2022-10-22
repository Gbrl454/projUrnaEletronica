DROP TABLE IF EXISTS `pessoas`;
DROP TABLE IF EXISTS `partidos`;

CREATE TABLE IF NOT EXISTS `pessoas`
(
    `id`               INT(11)                       NOT NULL AUTO_INCREMENT,
    `nome`             VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `nomeMae`          VARCHAR(150) COLLATE UTF8_BIN,
    `nomePai`          VARCHAR(150) COLLATE UTF8_BIN,
    `estatoCivil`      VARCHAR(25) COLLATE UTF8_BIN,
    `naturalidade`     VARCHAR(50) COLLATE UTF8_BIN,
    `numRG`            BIGINT(15),
    `numCPF`           BIGINT(11)                    NOT NULL,
    `numTituloEleitor` BIGINT(15),
    PRIMARY KEY (`id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;


CREATE TABLE IF NOT EXISTS `partidos`
(
    `id`     INT(11)                       NOT NULL AUTO_INCREMENT,
    `nome`   VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `numero` INT(2)                        NOT NULL,
    `sigla`  VARCHAR(5) COLLATE UTF8_BIN   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;

CREATE TABLE IF NOT EXISTS `candidatos`
(
    `id`           INT(11)                       NOT NULL AUTO_INCREMENT,
    `nomecompleto` VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `nomecampanha` VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `cargo`        VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `numero`       INT(5)                        NOT NULL,
    `idpartido`    INT(5)                        NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;

