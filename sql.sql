DROP TABLE IF EXISTS `pessoas`;
DROP TABLE IF EXISTS `partidos`;
DROP TABLE IF EXISTS `candidatos`;

CREATE TABLE IF NOT EXISTS `pessoas`
(
    `pe_id`               INT                           NOT NULL AUTO_INCREMENT,
    `pe_nome`             VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `pe_nomeMae`          VARCHAR(150) COLLATE UTF8_BIN,
    `pe_nomePai`          VARCHAR(150) COLLATE UTF8_BIN,
    `pe_estatoCivil`      VARCHAR(25) COLLATE UTF8_BIN,
    `pe_naturalidade`     VARCHAR(50) COLLATE UTF8_BIN,
    `pe_numRG`            VARCHAR(15),
    `pe_numCPF`           VARCHAR(11)                   NOT NULL,
    `pe_numTituloEleitor` VARCHAR(15),
    `pe_senha`            VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    PRIMARY KEY (`pe_id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;

CREATE TABLE IF NOT EXISTS `partidos`
(
    `pa_id`     INT(11)                       NOT NULL AUTO_INCREMENT,
    `pa_nome`   VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `pa_numero` INT(2)                        NOT NULL,
    `pa_sigla`  VARCHAR(5) COLLATE UTF8_BIN   NOT NULL,
    PRIMARY KEY (`pa_id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;

CREATE TABLE IF NOT EXISTS `candidatos`
(
    `ca_id`          INT(11)                       NOT NULL AUTO_INCREMENT,
    `pe_id`          INT(11)                       NOT NULL,
    `pa_id`          INT(11)                       NOT NULL,
    `ca_nome`        VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `ca_cargoAtual`  VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `ca_cargoPleito` VARCHAR(150) COLLATE UTF8_BIN NOT NULL,
    `ca_numero`      INT(5)                        NOT NULL,
    PRIMARY KEY (`ca_id`)
) ENGINE = MYISAM
  AUTO_INCREMENT = 0
  DEFAULT CHARSET = UTF8
  COLLATE = UTF8_BIN;

