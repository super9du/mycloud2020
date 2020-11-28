create database seata_order;
create database seata_storage;
create database seata_account;


-- ------------------------
-- 订单
-- ------------------------
use seata_order;

CREATE TABLE `t_order`
(
    `id`         bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `user_id`    bigint(20) unsigned NOT NULL,
    `product_id` bigint(20) unsigned NOT NULL,
    `count`      int(11) unsigned zerofill        DEFAULT NULL COMMENT '商品数',
    `money`      decimal(10, 0) unsigned zerofill DEFAULT NULL COMMENT '金额',
    `status`     int(11)                          DEFAULT NULL COMMENT '0 创建中，1已完结',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT(20)   NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(100) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';


-- ------------------------
-- 仓库
-- ------------------------
use seata_storage;

CREATE TABLE `t_storage`
(
    `id`         bigint(20) unsigned       NOT NULL AUTO_INCREMENT,
    `product_id` bigint(20) unsigned       NOT NULL,
    `total`      int(11) unsigned zerofill NOT NULL COMMENT '总库存',
    `used`       int(11) unsigned zerofill NOT NULL COMMENT '已用库存',
    `residue`    int(11) unsigned zerofill NOT NULL COMMENT '剩余库存',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;
insert INTO t_storage
VALUES ('1', '1', '100', '0', '100');

CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT(20)   NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(100) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';


-- ------------------------
-- 账户
-- ------------------------
use seata_account;

CREATE TABLE `t_account`
(
    `id`      bigint(20) unsigned              NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) unsigned              NOT NULL,
    `total`   decimal(10, 0) unsigned zerofill NOT NULL COMMENT '总额度',
    `used`    decimal(10, 0) unsigned zerofill NOT NULL COMMENT '支出',
    `residue` decimal(10, 0) unsigned zerofill NOT NULL COMMENT '余额',
    PRIMARY KEY (`id`, `user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO t_account
VALUES ('1', '1', '1000', '0', '1000');

CREATE TABLE IF NOT EXISTS `undo_log`
(
    `branch_id`     BIGINT(20)   NOT NULL COMMENT 'branch transaction id',
    `xid`           VARCHAR(100) NOT NULL COMMENT 'global transaction id',
    `context`       VARCHAR(128) NOT NULL COMMENT 'undo_log context,such as serialization',
    `rollback_info` LONGBLOB     NOT NULL COMMENT 'rollback info',
    `log_status`    INT(11)      NOT NULL COMMENT '0:normal status,1:defense status',
    `log_created`   DATETIME(6)  NOT NULL COMMENT 'create datetime',
    `log_modified`  DATETIME(6)  NOT NULL COMMENT 'modify datetime',
    UNIQUE KEY `ux_undo_log` (`xid`, `branch_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='AT transaction mode undo table';