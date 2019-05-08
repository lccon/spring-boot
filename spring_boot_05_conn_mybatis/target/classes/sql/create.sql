create table user(
    id varchar(32) NOT NULL,
    user_name VARCHAR(32) NOT NULL COMMENT '用户名',
    pass_word VARCHAR(32) NOT NULL COMMENT '密码',
    PRIMARY key(id)
)Engine=InnoDB DEFAULT charset=utf8 comment '用户表';