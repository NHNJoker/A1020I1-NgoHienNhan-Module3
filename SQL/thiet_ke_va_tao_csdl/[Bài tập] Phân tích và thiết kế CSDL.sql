drop database if exists database_sales ;

create database database_sales;

use database_sales;
create table products_line(
product_line varchar(50) primary key,
`description` varchar(45)
);

create table offices(
office_id int primary key,
address varchar(45),
phone varchar(15),
`national` varchar(45)
);


create table employees(
employee_id int primary key,
employee_name varchar(45),
email varchar(30),
position varchar(30),
office_id int,
foreign key (office_id) references offices(office_id)
);

create table customers(
customer_number int primary key,
`name` varchar(45),
phone varchar(10),
address varchar(50),
sale_rep_employee_number int,
report_to int,
foreign key (sale_rep_employee_number) references employees(employee_id),
foreign key (report_to) references customers(customer_number)
);


create table orders(
order_id int primary key,
date_purchase date,
date_of_delivery_equest date,
delivery_date date,
amount int,
unit_price int,
customer_number int,
foreign key (customer_number) references customers(customer_number)
);

create table products(
product_id int primary key,
product_name varchar(45),
supplier varchar(45),
stock_number int,
import_price int,
price int,
product_line varchar(50),
foreign key (product_line) references products_line(product_line)
);

create table payments(
pay_id int primary key,
date_of_pay date,
pay_amount int,
customer_number int,
foreign key (customer_number) references customers (customer_number)
);

create table product_order(
product_id int,
order_id int,

primary key(product_id,order_id),
foreign key(product_id) references orders(order_id),
foreign key(order_id) references products(product_id)
);