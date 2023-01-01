DROP Database Product_Management

CREATE DATABASE Product_Management

USE Product_Management
Go

DROP TABLE Product
DROP TABLE Category
DROP TABLE Orders
DROP TABLE Product_Category
DROP TABLE Customer
DROP TABLE Users
DROP TABLE Roles

CREATE TABLE Product
(
	ID VARCHAR(5) PRIMARY KEY,
	NameP NVARCHAR(30),
	Price FLOAT,
	SellPrice FLOAT,
	Content NVARCHAR(100),
	Descriptions NVARCHAR(100),
	Qty int,
	Statu NVARCHAR(100)
);

CREATE TABLE Category
(
	ID VARCHAR(5) PRIMARY KEY,
	NameC NVARCHAR(30),
	Descriptions NVARCHAR(100)
);

CREATE TABLE Product_Category
(
	ProductID VARCHAR(5) REFERENCES Product(ID),
	CategoryID VARCHAR(5) REFERENCES Category(ID),
	NameProductCategory NVARCHAR(30)
);

CREATE TABLE Customer
(
	ID VARCHAR(5) PRIMARY KEY,
	LastName NVARCHAR(100),
	FirstName NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Addres NVARCHAR(100),
);

--DROP TABLE Orders
CREATE TABLE Orders
(
	ID VARCHAR(5) PRIMARY KEY,
	productID VARCHAR(5) REFERENCES Product(ID),
	customerID VARCHAR(5) REFERENCES Customer(ID),
	Qty INT,
	Total FLOAT,
	Price FLOAT,
	Discount NVARCHAR(10),
	InvoicePayment FLOAT,
	Note NVARCHAR(100),
);


CREATE TABLE Users
(
	ID VARCHAR(5) PRIMARY KEY,
	LastName NVARCHAR(100),
	FirstName NVARCHAR(100),
	Phone NVARCHAR(10),
	Email NVARCHAR(100),
	Roles NVARCHAR(20),
	UserName NVARCHAR(30),
	Passwords NVARCHAR(100)
);

CREATE TABLE Roles
(
	ID VARCHAR(5) PRIMARY KEY,
	NameR NVARCHAR(100),
	Authority NVARCHAR(30)
);


Insert into Product Values('NN001',N'CocaCola','12','15',N'Hàng mới', N'San pham duoc bao quan o nhiet do 10oC','100',N'Con')
Insert into Product Values('BB001',N'Oshi cua','10','12',N'Hàng mới', N'San pham duoc bao quan o nhiet do 20oC','100',N'Con')
Insert into Product Values('KC001',N'Merino','12','15',N'Hàng mới', N'San pham duoc bao quan o nhiet do 0oC','90',N'Con')
Insert into Product Values('OQ001',N'Merino','12','15',N'Hàng mới', N'San pham duoc bao quan o nhiet do -20oC','70',N'Con')
Insert into Product Values('NN002',N'7Up','12','15',N'Hàng mới', N'San pham duoc bao quan o nhiet do 10oC','80',N'Con')
Insert into Product Values('NE001 ',N'Mirinda','12','15',N'Hàng mới', N'San pham duoc bao quan o nhiet do 10oC','60',N'Con')

SELECT * FROM Product

Insert into Category Values('NN',N'Nước ngọt',N'San pham duoc bao quan o nhiet do 10oC')
Insert into Category Values('BB',N'Bim Bim',N'San pham duoc bao quan o nhiet do 20oC')
Insert into Category Values('KC',N'Kem cây',N'San pham duoc bao quan o nhiet do -1oC')
Insert into Category Values('OQ',N'Ốc quế',N'San pham duoc bao quan o nhiet do 0oC')
Insert into Category Values('NE',N'Nước ép',N'San pham duoc bao quan o nhiet do 10oC')

SELECT * FROM Category


Insert into Product_Category Values('NN001',N'NN',N'Nước ngọt loại 1')
Insert into Product_Category Values('BB001',N'BB',N'Bim Bim loại 1')
Insert into Product_Category Values('KC001',N'KC',N'Kem Cây loại 1')
Insert into Product_Category Values('NE001',N'NE',N'Nước ép loại 1')
Insert into Product_Category Values('NN002',N'NN',N'Nước ngọt loại 2')

SELECT * FROM Product_Category


Insert into Customer Values('KH001',N'Nguyễn Thị',N'Anh','0987654321',N'anh012@gmail.com', N'An Dương Vương, Đà Lạt')
Insert into Customer Values('KH002',N'Nguyễn Minh',N'Tú','0987657321',N'tu412@gmail.com', N'Phù Đổng Thiên Vương, Đà Lạt')
Insert into Customer Values('KH003',N'Nguyễn Văn',N'Minh','0987954321',N'minh512@gmail.com', N'Xô Viết Nghệ Tĩnh, Đà Lạt')
Insert into Customer Values('KH004',N'Hoàng Văn',N'Hưng','0987954323',N'hung846@gmail.com', N'Ngô Quyền, Đà Lạt')

SELECT * FROM Customer


Insert into Orders Values('HH001','NN001','KH001','10','150','15',N'5%','142.5',N'Chuyển khoản, Đã thanh toán')
Insert into Orders Values('HH002','NN002','KH002','10','150','15',N'5%','142.5',N'Tiền mặt, Đã thanh toán')
Insert into Orders Values('HH003','KC001','KH003','5','75','15',N'5%','71.25',N'Chuyển khoản, Chưa thanh toán')
Insert into Orders Values('HH004','BB001','KH004','15','180','12',N'3%','174.6',N'Quẹt thẻ, Đã thanh toán')

SELECT * FROM  Orders


Insert into Users Values('AD001',N'Nguyễn Hồng',N'Thư','0987952321',N'admin1@gmail.com', N'admin', N'admin', 'admin123')
Insert into Users Values('AD002',N'Nguyễn Anh',N'Thảo','0987952361',N'admin2@gmail.com', N'admin', N'admin', 'admin123')
Insert into Users Values('NV001',N'Hoàng Minh',N'Anh','0987952321',N'nhanvien1@gmail.com', N'seller', N'seller', 'sell123')
Insert into Users Values('NV002',N'Võ Bảo',N'Anh','0887952321',N'nhanvien2@gmail.com', N'seller', N'seller', 'sell123')

SELECT * FROM Users


Insert into Roles Values('AD00',N'admin',N'Public')
Insert into Roles Values('NV00',N'seller',N'Private')

SELECT * FROM Roles

