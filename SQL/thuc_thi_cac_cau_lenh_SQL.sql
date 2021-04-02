drop database if exists classsic_models;

create database classsic_models;

use classsic_models;

create table customer(
customer_name varchar(50) primary key,
phone int,
city varchar(20),
country varchar(20)
);

insert into customer
values

('nhân', '0916309250', 'đà nẵng','đà nẵng' ),
('duyên','0123456789','quãng ngãi','quảng ngãi'),
('Nhi','012345678','hồ chí minh','hồ chí minh'),
('ánh dương','012345678','hà nội','hà nội'),
('lanh','012345678','đồng hới','quảng bình');

select * from customer;

select customer_name, phone, city, country from customer;

select * from customer where customer_name like '%A%';

select * from customer where city in ('đà nẵng','quảng ngãi');

delete from customer
where customer_name = 'nhân';

update customer
set customer_name = 'dung'
where customer_name = 'duyên';

alter table customer
add column id_national int;
