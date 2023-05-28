create table if not exists users (
                       id             bigint auto_increment primary key,
                       name           varchar(255)                         not null,
                       nickname       varchar(255)                         not null,
                       email          varchar(255)                         not null,
                       profile_uri    varchar(255)                         not null,
                       activated      tinyint(1) default 1                 not null,
                       age_agreement  bigint                               not null,
                       term_agreement bigint                               not null,
                       created_at     timestamp  default CURRENT_TIMESTAMP not null,
                       updated_at     timestamp  default CURRENT_TIMESTAMP null,
                       deleted_at     timestamp                            default null
);
