drop database if exists database_library;

create database database_library;

use database_library;

create table student(
student_id varchar(15) primary key,
student_name varchar(50),
phone varchar(10),
email varchar(45),
image binary
);

create table category(
category_id varchar(15) primary key,
`name` varchar(45)
);

create table borrow_order(
borrow_oder_id varchar(15) primary key,
date_order date,
date_to_pay_back date,
student_id varchar(15),
foreign key (student_id) references student (student_id)
);

create table book(
book_id varchar(15) primary key,
book_name varchar(50),
publisher varchar(50),
author varchar(50),
publising_year year,
num_of_publiscations int,
price int,
img_book binary,
category_id varchar(15),
borrow_oder_id varchar(15),
foreign key (category_id) references category(category_id),
foreign key (borrow_oder_id) references borrow_order (borrow_oder_id)
);