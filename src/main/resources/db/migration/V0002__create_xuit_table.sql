create table xuit (
    id          bigint      not null auto_increment,
    content     varchar(42) not null,
    type        enum('ORIGINAL', 'REXUIT', 'QUOTE'),
    author_id   bigint      not null,
    original_xuit_id    bigint,
    created_at  datetime    not null,
    primary key (id),
    constraint fk_xuit_user foreign key (author_id) references user (id),
    constraint fk_original_xuit foreign key (original_xuit_id) references xuit(id)
)  ENGINE = InnoDB DEFAULT CHARSET latin1;
