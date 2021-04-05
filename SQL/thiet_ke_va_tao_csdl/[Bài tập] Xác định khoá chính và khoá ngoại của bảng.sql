drop database if exists database_cus;

create database database_cus;

use database_cus;
create table type_of_acount(
type_of_acount_id int primary key,
`name` varchar(12)
);

create table Customer(
customer_number int primary key,
full_name varchar(50),
address varchar(80),
email varchar(45),
phone char(10)
);

create table Acount(
acount_number int primary key,
customer_number int,
type_of_acount_id int,
`date` date,
balance int,
foreign key (type_of_acount_id) references type_of_acount(type_of_acount_id),
foreign key(customer_number) references Customer(customer_number)
);

create table Trasaction(
tran_number int primary key,
acount_number int,
`date` date,
amount int,
foreign key (acount_number) references Acount(acount_number),
`description` varchar(100)
);

