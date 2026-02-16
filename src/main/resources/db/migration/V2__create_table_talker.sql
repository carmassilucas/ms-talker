create table tb_talker
(
    id         uuid                        not null,
    full_name  varchar(255)                not null,
    birth_date date                        not null,
    about_me   text,
    photo_url  varchar(255),
    profile_id bigint                      not null,
    email      varchar(255)                not null,
    password   varchar(255)                not null,
    active     boolean                     not null,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null
);

alter table tb_talker
    add constraint pk_tb_talker primary key (id);

alter table tb_talker
    add constraint uc_tb_talker_email unique (email);

alter table tb_talker
    add constraint fk_tb_talker_on_profile foreign key (profile_id) references tb_profile (id);
