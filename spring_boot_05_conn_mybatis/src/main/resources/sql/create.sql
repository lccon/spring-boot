create table user(
    id varchar(32) NOT NULL,
    user_name VARCHAR(32) NOT NULL COMMENT '\u7528\u6237\u540D',
    pass_word VARCHAR(32) NOT NULL COMMENT '\u5BC6\u7801',
    PRIMARY key(id)
)Engine=InnoDB DEFAULT charset=utf8mb4 comment '\u7528\u6237\u8868';