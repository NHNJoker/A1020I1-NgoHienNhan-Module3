drop database if exists  cac_ham_thong_dung;

create database cac_ham_thong_dung;

use cac_ham_thong_dung;

create table database_hoc_vien(
id int ,
ten varchar(30),
tuoi int,
khoa_hoc varchar(5),
so_tien int
);

insert into database_hoc_vien
values('1', 'Hoang', '21', 'CNTT', '400000'),
('2','Viet','19','DTVT','320000'),
('3','Thanh','18','KTDN','400000'),
('4','Nhan','19','CK','450000'),
('5','Huong','20','TCNH','500000'),
('5','Huong','20','TCNH','20000');

-- Viết câu lệnh hiện thị tất cả các dòng có tên là Huong
select *
from database_hoc_vien
where database_hoc_vien.ten = 'Huong';

-- Viết câu lệnh lấy ra tổng số tiền của Huong
select  ten,sum(so_tien) as tong_tien
from database_hoc_vien
where database_hoc_vien.ten = 'Huong'
group by database_hoc_vien.id;

-- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp

select *
from database_hoc_vien
group by ten;