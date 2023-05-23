use shoppingweb;
DROP TABLE shoppingweb.product;
DROP TABLE shoppingweb.category;
DROP TABLE shoppingweb.account;
DROP TABLE shoppingweb.sorder;
Drop table shoppingweb.voucher;
create table product(
	id int auto_increment primary key,
    name longtext,
    image longtext,
    price long,
    title varchar(255),
    description longtext,
    cateID INT,
    sellID INT
);
create table category(
	cid int primary key,
    cname longtext
);
create table account(
	uid int auto_increment primary key,
    username varchar(255),
    password varchar(255),
    isSell int,
    isAdmin int
);

create table Sorder(
	oid int auto_increment primary key,
    thoiGianDatHang datetime,
    soLuongSanPham int, 
	danhSachSanPham varchar(255)
);
create table voucher(
	id int auto_increment primary key,
    reducedMoney int,
    conditionMoney int,
    status int,
    name varchar(255),
    idUser int
);

insert into voucher(reducedMoney, conditionMoney, status, name, idUser)
values (100, 1000, 0,"Voucher giam 100k cho đơn từ 1000", 1),
	(250,2000,0,"Voucher giam 250k cho đơn từ 2000",2),
    (375,3000,0,"Voucher giam 375k cho đơn từ 3000",3),
    (250,2000,0,"Voucher giam 250k cho đơn từ 2000",3);
INSERT INTO product (id, name, image, price, title,description,cateID,sellID)
values
		(1,"MSI Modern 15 A11MU-1022VN","https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/4/637663479322536079_msi-modern-15-xam-dd.jpg", 1200,"Laptop MSI Modern 15 A11MU-1022VN i5 1155G7/8GB/512GB/15.6--FHD/Win 11_Xám","Sản phẩm...",1,3),
		(2,"Dell Vostro V3510","https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/15/637673115503991603_dell-vostro-v3510-den-dd.jpg", 1200,"Laptop Dell Vostro V3510 i5 1135G7","Sản phẩm...",2,3),
        (3,"Dell Vostro V3510","https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/15/637673115503991603_dell-vostro-v3510-den-dd.jpg", 1200,"Laptop Dell Vostro V3510 i5 1135G7","Sản phẩm...",2,3);
INSERT INTO category (cid, cname)
values
		(1,"MSI"),
		(2,"DELL");
INSERT INTO account (username,password, isSell, isAdmin)
values("admin","123456",0,1),
("huy","123456",0,0),
("seller","123456",1,0);

Select * from shoppingweb.product
where cateID =1;
Select * from category;

select * from product
where name like '%msi%';
select * from Sorder;

select * from product
where sellID =3;


select * from product;
select * from voucher where id=3;
update  voucher 
set status =1
where id =3;
select * from voucher;