SET MODE MySQL;

CREATE TABLE account
(
    id             bigint auto_increment primary key,
    email          varchar(255)                         not null,
    password       varchar(255)                         not null,
    created_at     timestamp  default CURRENT_TIMESTAMP not null,
    updated_at     timestamp                            null,
    deleted_at     timestamp                            null
)
