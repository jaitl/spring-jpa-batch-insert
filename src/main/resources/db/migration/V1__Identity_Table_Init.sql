create table identity_table
(
    id    serial primary key,
    name  varchar(100)  NOT NULL,
    ts    timestamp    default now()
);
