SET MODE MYSQL; /* another h2 way to set mode */

CREATE SCHEMA IF NOT EXISTS "public"; /* required due to issue with flyway --> https://stackoverflow.com/a/19115417/1224584*/

create table if not exists users
(
    id             bigint auto_increment
        primary key,
    name           varchar(255)                         not null,
    nickname       varchar(255)                         not null,
    email          varchar(255)                         not null,
    profile_uri    varchar(255)                         not null,
    activated      tinyint(1) default 1                 null,
    age_agreement  bigint                               not null,
    term_agreement bigint                               not null,
    created_at     timestamp  default CURRENT_TIMESTAMP not null,
    updated_at     timestamp                            null,
    deleted_at     timestamp                            null
);
