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
    tenNguoiMua varchar(255),
    thoiGianDatHang datetime,
    soLuongSanPham int, 
	danhSachSanPham varchar(255),
    tongTien double
);
insert into sorder(tenNguoiMua,thoiGianDatHang,soLuongSanPham,danhSachSanPham,tongTien)
values("huy",'2023-05-28',3,"MSI,DELL",10000);
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
		(1,"ASUS TUF FX506LHB-HN188W","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/1/26/637787904727727554_asus-tuf-gaming-fx506lh-den-2022-dd.jpg", 1200,"Best Seller Product","Laptop Asus TUF Gaming FX506LHB-HN188W i5 10300H/8GB/512GB/15.6 FHD/GeForce GTX 1650 4GB/Win11",5,3),
		(2,"Lenovo Ideapad 15ARH7","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/8/15/637961542143431053_lenovo-ideapad-gaming-3-15arh7-r7-xam-dd.jpg", 1200,"VIP Product","Laptop Lenovo Ideapad Gaming 3 15ARH7 R7 6800H/8GB/512GB/15.6 FHD/GeForce RTX 3050 4GB/ Win 11",3,3),
        (6,"Gigabyte GD-51VN123SO","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/6/638006467071200088_gigabyte-gaming-g5-dd-bh.jpg",3000,"New Product","Laptop Gigabyte Gaming G5 GD-51VN123SO i5 11400H/16GB/512GB/15.6 FHD/GeForce RTX 3050 4GB/Win 11",2,4),
        (4,"Lenovo 15IAH7H","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/3/23/638151643297943497_lenovo-gaming-legion-5-15iah7h-xam-dam-dd.jpg",2000,"Good Laptop","Laptop Lenovo Gaming Legion 5 15IAH7H i5 12500H/16G/512G/15.62K/GeForce RTX 3060 6GB/Win11",3,3),
        (5,"Acer Nitro AN515-57-54MV","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/3/10/638140613270669684_acer-nitro-gaming-an515-57-den-rtx3050-dd.jpg",1500,"Best For Gaming","Laptop Acer Nitro Gaming AN515-57-54MV i5 11400H/8GB/512GB/15.6 FHD/NVIDIA GeForce RTX 3050 4GB/Win10",4,4),
        (3,"MSI 15 B5EEK-203VN","https://images.fpt.shop/unsafe/fit-in/240x215/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2023/3/10/638140612136202106_acer-nitro-gaming-an515-58-dd.jpg",1000,"Cheapest Laptop","Laptop MSI Gaming Alpha 15 B5EEK-203VN R5 5600H/8GB/512GB/15.6 FHD/RX6600M 8GB/Win 11_Balo",1,3);
INSERT INTO category (cid, cname)
values
		(1,"MSI"),
        (2,"GIGA"),
        (3,"LENOVO"),
        (4,"ACER"),
        (5,"ASUS");
INSERT INTO account (username,password, isSell, isAdmin)
values("admin","123456",0,1),
("huy","123456",0,0),
("seller","123456",1,0),
("seller2","123456",1,0);

Select * from shoppingweb.product
where cateID =1;
Select * from category;

select * from product
where name like '%msi%';
select * from Sorder;

select * from product
where sellID =3;

select* from sorder;
select * from product;
select * from voucher where id=3;
update  voucher 
set status =1
where id =3;
select * from voucher;
