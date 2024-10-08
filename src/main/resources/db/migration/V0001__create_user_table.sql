create table user (
    id          bigint      not null auto_increment,
    username    varchar(10) not null,
    created_at  datetime    not null,
    primary key (id),
    unique index uk_username (username)
) ENGINE = InnoDB DEFAULT CHARSET latin1;
