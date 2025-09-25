create table tb_talker_type (
    id bigint not null,
    description character varying not null
);

alter table tb_talker_type
    add constraint pk_tb_talker_type primary key (id);

alter table tb_talker_type
    add constraint uc_tb_talker_type_description unique (description);

create table tb_talker (
    id uuid not null,
    full_name character varying not null,
    birth_date date not null,
    profile_photo character varying,
    about_me text,
    currently_state character varying,
    currently_city character varying,
    talker_type_id bigint not null,
    email character varying not null,
    password character varying not null,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null
);

alter table tb_talker
    add constraint pk_tb_talker primary key (id);

alter table tb_talker
    add constraint uc_tb_talker_email unique (email);

alter table tb_talker
    add constraint uc_tb_talker_profile_photo unique (profile_photo);

alter table tb_talker
    add constraint fk_tb_talker_on_talker_type foreign key (talker_type_id) references tb_talker_type (id);
