create type account_status as enum ('ACTIVE', 'CLOSED_BY_CLIENT', 'BLOCKED_BY_LEGAL_ORDER', 'BLOCKED_DUE_SECURITY_RISK');

create table account
(
    number     numeric primary key,
    client     uuid                     not null,
    status     account_status           not null,
    created_at timestamp with time zone not null
);

