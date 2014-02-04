# --- First database schema

# --- !Ups

create sequence s_inflation_id;
create sequence s_fund_id;
create sequence s_investment_id;
create sequence s_investor_id;
create sequence s_rate_id;

create table INFLATION (
  id    	bigint DEFAULT nextval('s_inflation_id'),
  currency  varchar(128),
  year 		bigint,
  rate 		float,
);

create table FUND (
  id    	bigint DEFAULT nextval('s_fund_id'),
  code  	varchar(128),
  name 		varchar(128),
  currency 	varchar(128),
);

create table INVESTMENT (
  id    	bigint DEFAULT nextval('s_investment_id'),
  user 		varchar(128),
  fundId  	bigint,
  investorId bigint,
  date 		date,
  buyinRate float,
  quantity 	float
);

create table INVESTOR (
  id    	bigint DEFAULT nextval('s_investor_id'),
  name 		varchar(128),
  fee 		long,
  chargeperiod varchar(128)
);

create table RATE (
  id    	bigint DEFAULT nextval('s_rate_id'),
  fundId  	bigint,
  date 		date,
  price 	float
);

# --- !Downs

drop table INFLATION;
drop table FUND;
drop table INVESTMENT;
drop table INVESTOR;
drop table RATE;

drop sequence s_inflation_id;
drop sequence s_fund_id;
drop sequence s_investment_id;
drop sequence s_investor_id;
drop sequence s_rate_id;



