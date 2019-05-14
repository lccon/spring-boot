CREATE TABLE employer(
    name VARCHAR(32) not null,
    age INT not null,
)engine=innoDB DEFAULT charset=utf8;

/** 20190513 字典类型 卢聪 */
CREATE TABLE `system_property_domain` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `domain_name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/** 20190513 字典项 卢聪 */
CREATE TABLE `system_property_dict` (
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `property_domain_id` bigint(10) NOT NULL,
  `display_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/** 20190513 策略表 卢聪 */
CREATE TABLE `system_task_ploy` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cname` varchar(100) DEFAULT NULL COMMENT '策略中文名称',
  `ename` varchar(100) DEFAULT NULL COMMENT '策略英文名称',
  `dict_id` bigint(100) DEFAULT NULL COMMENT '策略类型',
  `description` varchar(100) DEFAULT NULL COMMENT '策略描述',
  `code` varchar(500) DEFAULT NULL COMMENT '策略代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='策略表';

/** 20190513 任务表 卢聪 */
CREATE TABLE `system_task` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) NOT NULL COMMENT '任务名称',
  `task_group` varchar(100) DEFAULT NULL COMMENT '任务组',
  `description` varchar(100) DEFAULT NULL COMMENT '任务描述',
  `ploy_id` bigint(10) NOT NULL COMMENT '策略id',
  `config` varchar(100) NOT NULL,
  `closed` varchar(100) DEFAULT NULL COMMENT '任务是否关闭',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='任务表';

CREATE TABLE task_contect(
  name_contect VARCHAR(100) NOT NULL,
  group_contect varchar(100) NOT NULL
)engine=innoDB DEFAULT charset=utf8;