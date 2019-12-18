CREATE TABLE `city_info`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `name`    varchar(32) DEFAULT NULL,
    `state`   varchar(32) DEFAULT NULL,
    `country` varchar(32) DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `city_info` (`name`, `state`, `country`)
VALUES ('北京', 'BJ0001', 'CH01'),
       ('上海', 'SH0001', 'CH02'),
       ('广州', 'GD0001', 'CH03'),
       ('深圳', 'GD0002', 'CH04'),
       ('天津', 'TJ0001', 'CH05'),
       ('南京', 'JS0001', 'CH06'),
       ('杭州', 'ZJ0001', 'CH07'),
       ('苏州', 'JS0002', 'CH08'),
       ('武汉', 'HB0001', 'CH09'),
       ('成都', 'SC0001', 'CH10');