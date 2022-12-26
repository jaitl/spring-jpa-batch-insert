create table sequence_table
(
    id    integer primary key,
    name  varchar(100)  NOT NULL,
    ts    timestamp    default now()
);

create sequence sequence_id_auto_gen increment 50;
