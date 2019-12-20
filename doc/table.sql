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


CREATE TABLE `user_info`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_name`    varchar(32) DEFAULT NULL,
    `address`   varchar(32) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `user_info` (`user_name`, `address`)
VALUES ('唐三藏', '长安'),
       ('孙悟空', '花果山'),
	   ('猪八戒', '高老庄'),
	   ('沙悟净', '流沙河'),
	   ('观音', '南海'),
	   ('如来', '灵山'),
	   ('玉帝', '云霄殿'),
	   ('菩提祖师', '三星洞'),
	   ('镇元子', '五庄观'),
	   ('太上老君', '兜率宫')
       ;
create unique index ui_user_info_user_name ON user_info(
	user_name asc
);