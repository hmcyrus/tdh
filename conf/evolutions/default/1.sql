# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hospital (
  id                        bigint auto_increment not null,
  email                     varchar(255),
  address                   varchar(255),
  name                      varchar(255),
  latlong                   varchar(255),
  image_location            varchar(255),
  contact_person            varchar(255),
  contact_number            varchar(255),
  webpage                   varchar(255),
  constraint uq_hospital_email unique (email),
  constraint pk_hospital primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  email                     varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  constraint uq_user_email unique (email),
  constraint uq_user_user_name unique (user_name),
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table hospital;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

