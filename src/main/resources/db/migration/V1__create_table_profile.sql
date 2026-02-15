create table tb_profile
(
    id   bigint      not null,
    name varchar(16) not null
);

alter table tb_profile
    add constraint pk_tb_profile primary key (id);

alter table tb_profile
    add constraint uc_tb_profile_name unique (name);
