# --- First database schema

# --- !Ups

create sequence s_inflation_id;

create table INFLATION (
  id    bigint DEFAULT nextval('s_inflation_id'),
  currency  varchar(128),
  year bigint,
  rate long,
);


# --- !Downs

drop table INFLATION;
drop sequence s_inflation_id;