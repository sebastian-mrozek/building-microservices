-- apply changes
create table dtask (
  id                            uuid not null,
  listid                        uuid not null,
  name                          varchar(255),
  status                        integer,
  description                   varchar(255),
  constraint ck_dtask_status check ( status in (0,1,2,3,4)),
  constraint pk_dtask primary key (id)
);

create table dtask_list (
  id                            uuid not null,
  workspaceid                   uuid not null,
  name                          varchar(255),
  constraint pk_dtask_list primary key (id)
);

create table dworkspace (
  id                            uuid not null,
  name                          varchar(255),
  constraint pk_dworkspace primary key (id)
);

create index ix_dtask_listid on dtask (listid);
alter table dtask add constraint fk_dtask_listid foreign key (listid) references dtask_list (id) on delete restrict on update restrict;

create index ix_dtask_list_workspaceid on dtask_list (workspaceid);
alter table dtask_list add constraint fk_dtask_list_workspaceid foreign key (workspaceid) references dworkspace (id) on delete restrict on update restrict;

