DROP TABLE IF EXISTS `pessoas`;
CREATE TABLE IF NOT EXISTS `pessoas`
(
    `id`               int(11)                       NOT NULL AUTO_INCREMENT,
    `nome`             varchar(150) COLLATE utf8_bin NOT NULL,
    `nomeMae`          varchar(150) COLLATE utf8_bin NOT NULL,
    `nomePai`          varchar(150) COLLATE utf8_bin NOT NULL,
    `estatoCivil`      varchar(25) COLLATE utf8_bin  NOT NULL,
    `naturalidade`     varchar(50) COLLATE utf8_bin  NOT NULL,
    `numRG`            bigint(15)                    NOT NULL,
    `numCPF`           bigint(11)                    NOT NULL,
    `numTituloEleitor` bigint(15)                    NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;