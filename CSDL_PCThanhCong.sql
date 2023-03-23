DROP DATABASE IF EXISTS PCThanhCong;
CREATE DATABASE PCThanhCong;
USE PCThanhCong;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	id 						TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	username				VARCHAR(255) NOT NULL UNIQUE KEY,
	email 					VARCHAR(255) NOT NULL UNIQUE KEY,
	fullname				VARCHAR(255) NOT NULL,
	`password`				VARCHAR(255) NOT NULL,
    phone					VARCHAR(15) NOT NULL UNIQUE KEY,
	address					VARCHAR(500) NOT NULL,
	`role` 					ENUM('CLIENT','ADMIN') DEFAULT 'CLIENT',
	`status`				TINYINT,  -- 0 : not active / 1 : actived
    avatar					VARCHAR(500) NOT NULL
);


DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
	id						TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`name` 					VARCHAR(255) NOT NULL,
	`status`				TINYINT DEFAULT 1
);

DROP TABLE IF EXISTS products;
CREATE TABLE products (
	id 						TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`title` 				varchar(255) NOT NULL UNIQUE,
    `specifications`		varchar(1000) not null,
	`descriptions` 			VARCHAR(1000) NOT NULL,
	originalPrice 			INT UNSIGNED NOT NULL,
	promotionPrice  		INT UNSIGNED,
	`created_Date` 			DATETIME DEFAULT now(),
	categoryId 				TINYINT UNSIGNED NOT NULL,
	amount					SMALLINT NOT NULL,
	`status` 				TINYINT DEFAULT 1,
    FOREIGN KEY(categoryId) REFERENCES categories(id)
);

DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
	id 								TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	user_Id							TINYINT UNSIGNED UNIQUE KEY NOT NULL,
    amount							TINYINT UNSIGNED DEFAULT 0,
	FOREIGN KEY(user_Id) REFERENCES `users`(id)
);



DROP TABLE IF EXISTS `cartItems`;
CREATE TABLE `cartItems` (
	id						TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	cart_Id 							TINYINT UNSIGNED,
	product_Id						TINYINT UNSIGNED,
 	amount 							TINYINT UNSIGNED  NOT NULL,
	FOREIGN KEY(product_Id) REFERENCES products(id),
	FOREIGN KEY(cart_Id) REFERENCES cart(id)
);

DROP TABLE IF EXISTS `PRODUCT_RATES`;
CREATE TABLE `PRODUCT_RATES`(
	id 								TINYINT unsigned PRIMARY KEY AUTO_INCREMENT,
    user_Id 							TINYINT unsigned not null,
    product_Id 						TINYINT unsigned not null,
    `value` 						TINYINT unsigned not null,
    `comment` 						VARCHAR(1000) NOT NULL,
    created_At 						DATETIME DEFAULT NOW(),
    update_At 						DATETIME,
    FOREIGN KEY(user_Id) REFERENCES users(id),
    FOREIGN KEY(product_Id) REFERENCES products(id)
);

DROP TABLE IF EXISTS ProductImages;
CREATE TABLE ProductImages(
	id 								TINYINT unsigned PRIMARY KEY AUTO_INCREMENT,
    image_Url 						VARCHAR(500) NOT NULL,
    created_At 						DATETIME DEFAULT NOW(),
    imagePublicId					VARCHAR(500),
    updated_At						DATETIME,
    product_Id 						TINYINT UNSIGNED,
    FOREIGN KEY(product_Id) REFERENCES Products(id)
);
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
	id 									TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	user_Id 							TINYINT UNSIGNED NOT NULL,
    amount							TINYINT UNSIGNED DEFAULT 0,
	FOREIGN KEY(user_Id) REFERENCES `users`(id)
);

DROP TABLE IF EXISTS `orderItems`;
CREATE TABLE `orderItems` (
	id								TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	order_Id 						TINYINT UNSIGNED NOT NULL,
	product_Id						TINYINT UNSIGNED NOT NULL,
	created_Date 					DATETIME DEFAULT NOW(),
	received_Date 					DATE ,
    amount							INT UNSIGNED NOT NULL,
	`status` 						ENUM('Processing','Processed' ,'Delivering' , 'Complete')  DEFAULT 'Complete',
	FOREIGN KEY(product_Id) REFERENCES products(id),
	FOREIGN KEY(order_Id) REFERENCES orders(id)
);

DROP TABLE IF EXISTS RegistrationUserToken;
CREATE TABLE RegistrationUserToken(
	id 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    token	VARCHAR(500) UNIQUE KEY,
    userId  TINYINT UNSIGNED UNIQUE KEY,
    FOREIGN KEY(userId) REFERENCES users(id)
);

DROP TABLE IF EXISTS ResetPasswordUserToken;
CREATE TABLE ResetPasswordUserToken(
	id 		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    token	VARCHAR(500) UNIQUE KEY,
    userId  TINYINT UNSIGNED UNIQUE KEY,
    FOREIGN KEY(userId) REFERENCES users(id)
);

	
-- ====================================  INSERT DATA ============================================
-- password : 123456
INSERT INTO `users` (`username` , `email`, `fullname`, `password`,`phone`, `role`, `address`, `status` , avatar) VALUES
('adminshop' , 'admin@gmail.com', 'Nghiêm Văn Trường', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','0123456788', 'Admin', 'Ha Noi', 1 ,'123'),
('nvt0710' ,'truongnghiem@gmail.com', 'Nghiêm Văn Trường', '$2a$10$W2neF9.6Agi6kAKVq8q3fec5dHW8KUA.b0VSIGdIZyUravfLpyIFi','0123456789','Client', 'HaTinh', 1 , '123');

insert into Cart (user_Id) values (2);
insert into Orders (user_Id) values (2);

INSERT INTO categories (`name`) VALUES
('Máy Tính - Máy Chủ'),
('Linh Kiện Máy Tính'),
('Màn Hình Máy Tính'),
('Thiết Bị Lưu Trữ, USB, Thẻ Nhớ'),	
('Loa, Tai Nghe, Webcam'),
('Gaming Gear'),
('Cooling Tản Nhiệt'),
('Thiết Bị Mạng');

INSERT INTO `products` (`title`, `originalPrice`, `promotionPrice`,  `categoryId`, `amount`,`specifications`, `descriptions`, `status`) VALUES
('Máy tính để bàn Dell Inspiron AIO 5400 42INAIO540009 (i3-1115G4/8GB/1TB/23.8 FHD/Windows 11 Home + Office Home and Student 2021)', '17990000', '16990000', 1, 5, 'Mã sản phẩm	AIO Dell 5400 42INAIO540009
Chíp xử lý	Intel Core i3-1115G4 up to 4.1GHz
Bộ nhớ Ram	8GB DDR4 2666MHz (x2 slot DDR4 Notebook)
Ổ đĩa cứng	1TB 7200 rpm 2.5" Sata (x1 M2 SSD PICE 2230/2242)
Màn hình	23.8 FHD (1920 x 1080), Anti-Glare Narrow Border
Card đồ họa	Intel UHD Graphics
Ổ đĩa quang (DVD)	Không DVD
Webcam	FHD IR
Keyboard	Wireless
Cổng I/O phía sau	1 x USB 2.0 Type A, 3 USB 3.1 Gen 1 Type A, 1 USB 3.1 Gen 2 Type-C, 1 Microphone/Headset Jack
Cổng xuất hình	1 x HDMI
Wifi	802.11ax
Bluetooth	Có
Kết nối mạng LAN	10/100/1000 Mbps
Phụ kiện kèm theo	Full box
Âm thanh	Có loa
Kích thước	412.9 mm x 539.8 mm x 41.8 mm
Khối lượng	5.2 kg
Bảo hành	12 tháng
Hệ điều hành 	Windows 11 Home 64bit + Office Home and Student 2021',
'Máy bộ Dell Inspiron AIO 5400 giúp tiết kiệm không gian chứa mọi thứ bạn cần trong một thiết bị nhỏ gọn chứa đựng cả máy tính, màn hình và loa tất cả trong một. Với màn hình InfinityEdge FHD và đường viền 8mm, màn hình  Full HD 23,8 inch này trông đáng kinh ngạc từ hầu hết mọi góc độ.
Giải quyết các công việc một cách nhanh chóng với bộ vi xử lý Intel Core thế hệ thứ 11 mới nhất. Bộ nhớ DDR4 nhanh cho phép bạn chạy nhiều ứng dụng và tab liên tục.
Với thanh âm thanh phát ra từ phía trước được trang bị loa được điều chỉnh chuyên nghiệp với Waves MaxxAudio Pro, bạn không chỉ có được vẻ ngoài phong cách mà còn có chất lượng âm thanh tốt hơn
Tận hưởng kết nối Internet đáng tin cậy từ mọi nơi trong nhà mà không cần dây cáp nhờ công nghệ 802.11 ax / WiFi 6. Bluetooth 5.1 khi được ghép nối với các thiết bị ngoại vi , hệ thống này có thể mang lại hiệu suất được cải thiện, phạm vi không dây nhiều hơn và tốc độ truyền dữ liệu cao hơn, đồng thời cung cấp đủ băng thông để hỗ trợ hai thiết bị.', 1),

('Máy tính để bàn All in One Dell 5490 ( Core i5-11500T/8GB/256GB/23.8 inch/Ubuntu Linux 20.04)', '21990000', '19990000', 1, 5, '
Sản phẩmMáy tính All in One
Tên Hãng		DELL
Model			AIO Dell 5490 
Bộ VXL			Intel Core i5-11500T (12 MB Cache, 6 Core, 12 Threads, 1.50 GHz to 3.90 GHz)
Cạc đồ họa		Intel UHD Graphics 
Màn hình		23.8 inch FHD (1920x1080) IPS 
Bộ nhớ			8GB(8GBx1) DDR4 3200Mhz (x2 slot ram laptop)
Ổ cứng			256GB M.2 PCIe NVMe (x1 HDD 2.5" sata)
Kết nối mạng	Intel Wi-Fi 6 AX201, Dual-band 2x2 802.11ax with MU-MIMO + Bluetooth 5.0
Ổ quang			không có
Key & Mouse		Có dây
Loa 			Loa ngoài
Camera			Không có
Cổng giao tiếp	1 USB 3.2 Gen 2 Type-C™ port (side)
				1 USB 3.2 Gen 1 Type-A port with PowerShare (side)
				1 Universal audio jack (side)
				2 USB 2.0 ports with Smart Power On (rear)
				2 USB 3.2 Gen 2 Type-A ports (rear)
				1 Line-out audio port (rear)
				1 DP++ 1.4/HDCP 2.3 port (rear)
Hệ điều hành	Ubuntu Linux 20.04
Kích thước	Height: 344.00 mm Width: 540.20 mm Depth: 52.80 mm
Cân nặng	6.59 kg
Xuất xứ		Malaysia',
'Máy tính để bàn All in One Dell 5490
Giải pháp tối ưu cho văn phòng hiện đại
Máy tính tích hợp All in One đang là xu hướng của văn phòng hiện đại. Gói gọn hiệu năng làm việc mạnh mẽ trong vẻ bề ngoài nhỏ gọn, All in One Dell 5490 sẽ là sự lựa chọn lý tưởng nếu bạn là người yêu thích sự nhỏ gọn, tiện dụng và đang tìm kiếm một mẫu máy tính để làm việc.

Thiết kế tất cả trong một
Như tên gọi, All in One Dell 5490 là mẫu máy tính tích hợp mọi thứ trong một chiếc màn hình. Cả Case máy tính, Loa ngoài,cổng kết nối.. đều được tích hợp lại trong một chiếc màn hình nhỏ gọn…
Kích thước 344x540.20x52.80 cho phép chiếc máy tính này phù hợp với nhiều không gian làm việc, tiết kiệm diện tích chiếm dụng trong không gian làm việc.
Trọng lượng chỉ 6.59Kg cũng rất tiện lợi khi cần di chuyển góc làm việc.
Màn hình tiêu chuẩn
All in One Dell 5490 sở hữu màn hình 23inch FHD tiêu chuẩn. Trên tấm nền IPS, màu sắc và chất lượng hình ảnh hiển thị sẽ cực kỳ chân thực và sống động. Ngoài ra góc nhìn tới màn hình cũng rất rộng, người dùng có thể làm việc ở tư thế thoải mái nhất.
Cấu hình mạnh mẽ
Nhờ con chip Intel i5- 11500T mà mọi công việc trở nên cực kỳ đơn giản với chiếc máy tính AiO này. Chip T là dòng CPU được tối ưu cho những chiếc Laptop hoặc máy tính AiO để mang lại hiệu năng ổn định mà không tỏa ra quá nhiều nhiệt. Hoạt động với 6 nhân 12 luồng và 12Mb Cache, Intel i5- 11500T cho hiệu suất hoạt động ấn tượng khi xung nhịp có thể lên tới tối đa 3.9Ghz.
8GB RAM hỗ trợ khả năng hoạt động đa nhiệm tuyệt vời, cho phép sử dụng nhiều tác vụ mà không lo giật Lag.
Ổ cứng SSD có tốc độ truy xuất dữ liệu siêu nhanh và dung lượng 256GB sẽ là không gian lưu trữ rộng lớn để bạn thoải mái lưu trữ tài liệu làm việc.

Kết nối toàn diện
Máy cũng được trang bị đủ những cổng kết nối thông dụng mà người dùng sẽ cần tới ở thời điểm hiện tại:
1 USB 3.2 Gen 2 Type-C™ port (side)
1 USB 3.2 Gen 1 Type-A port with PowerShare (side)
1 Universal audio jack (side)
2 USB 2.0 ports with Smart Power On (rear)
2 USB 3.2 Gen 2 Type-A ports (rear)
1 Line-out audio port (rear)
1 DP++ 1.4/HDCP 2.3 port (rear)
Về kết nối không dây thì máy được tích hợp sẵn Intel Wi-Fi 6 AX201 cho kết nối mạng ổn định và Bluetooth 5.0 để mở rộng khả năng kết nối với các thiết bị di động khác.', 1)
;




INSERT INTO `ProductImages` (`image_Url`, `product_Id`) VALUES
('maytinh_maychu1.1.jpg' , 1),
('maytinh_maychu1.2.jpg' , 1),
('maytinh_maychu1.3.jpg' , 1),
('maytinh_maychu1.4.jpg' , 1),
('maytinh_maychu1.5.jpg' , 1);


insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (1, 1, 1, 4, 'Thrasher, curve-billed');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (2, 1, 1, 3, 'Turkey vulture');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (3, 1, 1, 1, 'Tiger snake');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (4, 2, 1, 5, 'Bushbuck');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (5, 1, 1, 5, 'Armadillo, seven-banded');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (6, 2, 1, 1, 'Sugar glider');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (7, 1, 1, 4, 'Elephant, african');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (8, 1, 1, 1, 'Cormorant, javanese');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (9, 1, 1, 4, 'Ibis, puna');
insert into PRODUCT_RATES (id, user_Id, product_Id, value, comment) values (10, 1, 1, 5, 'Bee-eater, white-fronted');


-- insert into cartItems (id, cart_Id, product_Id, amount) values (1, 1, 1, 2);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (2, 1, 2, 5);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (3, 1, 3, 3);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (4, 1, 4, 1);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (5, 1, 5, 1);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (6, 1, 6, 5);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (7, 1, 7, 5);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (8, 1,8, 2);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (9, 1, 9, 3);
-- insert into cartItems (id, cart_Id, product_Id, amount) values (10, 1, 10, 1);


insert into orderItems (id, order_Id, product_Id,received_Date ,amount) values (1, 1, 1, '2023-03-19' , 1);
insert into orderItems (id, order_Id, product_Id,received_Date,amount) values (2, 1, 1,'2023-03-19',1);
-- insert into orderItems (id, order_Id, product_Id,amount) values (3, 1, 2,3);
-- insert into orderItems (id, order_Id, product_Id,amount) values (4, 1, 1,2);
-- insert into orderItems (id, order_Id, product_Id,amount) values (5, 1, 1,5);
-- insert into orderItems (id, order_Id, product_Id,amount) values (6, 1, 3,2);
-- insert into orderItems (id, order_Id, product_Id,amount) values (7, 1, 3,6);
-- insert into orderItems (id, order_Id, product_Id,amount) values (8, 1, 2,1);
-- insert into orderItems (id, order_Id, product_Id,amount) values (9, 1, 3,3);
-- insert into orderItems (id, order_Id, product_Id,amount) values (10, 1,3,2);