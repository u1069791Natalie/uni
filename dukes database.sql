CREATE USER `duke` @`localhost`
   IDENTIFIED BY 'Password1234'
   REQUIRE NONE
   WITH MAX_QUERIES_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT GRANT OPTION ON *.* TO `duke` @`localhost`;
GRANT SELECT ON *.* TO `duke` @`localhost`;
GRANT INSERT ON *.* TO `duke` @`localhost`;
GRANT UPDATE ON *.* TO `duke` @`localhost`;
GRANT DELETE ON *.* TO `duke` @`localhost`;
GRANT EXECUTE ON *.* TO `duke` @`localhost`;
GRANT CREATE ON *.* TO `duke` @`localhost`;
GRANT CREATE ROUTINE ON *.* TO `duke` @`localhost`;
GRANT CREATE TABLESPACE ON *.* TO `duke` @`localhost`;
GRANT CREATE TEMPORARY TABLES ON *.* TO `duke` @`localhost`;
GRANT CREATE USER ON *.* TO `duke` @`localhost`;
GRANT CREATE VIEW ON *.* TO `duke` @`localhost`;
GRANT EVENT ON *.* TO `duke` @`localhost`;
GRANT INDEX ON *.* TO `duke` @`localhost`;
GRANT TRIGGER ON *.* TO `duke` @`localhost`;
GRANT DROP ON *.* TO `duke` @`localhost`;
GRANT ALTER ON *.* TO `duke` @`localhost`;
GRANT ALTER ROUTINE ON *.* TO `duke` @`localhost`;
GRANT REFERENCES ON *.* TO `duke` @`localhost`;
GRANT LOCK TABLES ON *.* TO `duke` @`localhost`;
GRANT PROCESS ON *.* TO `duke` @`localhost`;
GRANT SHOW VIEW ON *.* TO `duke` @`localhost`;
GRANT SHOW DATABASES ON *.* TO `duke` @`localhost`;
GRANT FILE ON *.* TO `duke` @`localhost`;
GRANT RELOAD ON *.* TO `duke` @`localhost`;
GRANT SHUTDOWN ON *.* TO `duke` @`localhost`;
GRANT SUPER ON *.* TO `duke` @`localhost`;
GRANT REPLICATION CLIENT ON *.* TO `duke` @`localhost`;
GRANT REPLICATION SLAVE ON *.* TO `duke` @`localhost`;
GRANT ALL PRIVILEGES ON *.* TO `duke` @`localhost`;
GRANT USAGE ON *.* TO `duke` @`localhost`;
FLUSH PRIVILEGES;


create database dukes;

use dukes;

create table Category (
CategoryId INT AUTO_INCREMENT PRIMARY KEY,/*mariaDb saves names of PKs as 'PRIMARY' so no need to add in constraints statement*/
Description VARCHAR(100)
);

create table SubCategory (
SubCategoryId INT AUTO_INCREMENT PRIMARY KEY,
CategoryId INT,
Description VARCHAR(100),
CONSTRAINT FK_SubCategory_CategoryId FOREIGN KEY (CategoryId) REFERENCES Category (CategoryId)
);

create table Book (
BookId INT AUTO_INCREMENT PRIMARY KEY,
Isbn VARCHAR(100),
Surname VARCHAR(100), 
Firstname VARCHAR(100), 
Title VARCHAR(100) NOT NULL,
Price DOUBLE(10,2), 
Onsale BIT, 
CalendarYear INT,
Description VARCHAR(100), 
Inventory INT,
SubCategoryId INT, 
CONSTRAINT FK_SubCategory_SubCategoryId FOREIGN KEY (SubCategoryId) REFERENCES SubCategory (SubCategoryId)
);

CREATE UNIQUE INDEX IX_Book_Isbn ON Book (Isbn);

create table SaleType (
SaleTypeId INT PRIMARY KEY,
Description VARCHAR(100)
);

create table SaleItem (
SaleItemId INT AUTO_INCREMENT PRIMARY KEY,
Price DOUBLE(10,2), 
BidPrice DOUBLE(10,2), 
TradeAvailable BIT,
ListDate DATE,
BookId INT,
SaleTypeId INT COMMENT 'update sale type to trade when traded (sold)',
CONSTRAINT FK_Book_BookId FOREIGN KEY (BookId) REFERENCES Book (BookId),
CONSTRAINT FK_SaleType_SaleTypeId FOREIGN KEY (SaleTypeId) REFERENCES SaleType (SaleTypeId)
);

create table Users (
UserId INT AUTO_INCREMENT PRIMARY KEY,
FisrtName VARCHAR(100),
LastName VARCHAR(100),
Street VARCHAR(100),
Suburb VARCHAR(100),
City VARCHAR(100),
Country VARCHAR(100),
PostCode VARCHAR(100),
Phone VARCHAR(100),
PhoneMobile VARCHAR(100),
Email VARCHAR(100),
IsAdmin BIT
);

create table Users_SaleItem (
SaleItemId INT,
UserId INT,
CONSTRAINT PK_Users_SaleItem PRIMARY KEY (SaleItemId, UserId),
CONSTRAINT FK_Users_SaleItem_SaleItemId FOREIGN KEY (SaleItemId) REFERENCES SaleItem (SaleItemId),
CONSTRAINT FK_Users_SaleItem_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId)
);

create table Sales (
SaleItemId INT PRIMARY KEY,
SaleDate DATE NOT NULL,
SalePrice DOUBLE(10,2), 
TradedSaleItemId INT COMMENT 'Indexed - ensure all queries for trades hit this first',
CONSTRAINT FK_SaleItem_SaleItemId FOREIGN KEY (SaleItemId) REFERENCES SaleItem (SaleItemId),
CONSTRAINT FK_SaleItem_TradedSaleItemId FOREIGN KEY (TradedSaleItemId) REFERENCES SaleItem (SaleItemId)
);

CREATE UNIQUE INDEX IX_Sales_TradedSaleItemId ON Sales (TradedSaleItemId);/*ensure all queries for trades hit this first*/

create table Images (
ImageId INT AUTO_INCREMENT PRIMARY KEY,
url VARCHAR(250)
);

Create table SaleItem_Images (
SaleItemId INT,
ImageId INT,
CONSTRAINT PK_SaleItem_Images PRIMARY KEY (SaleItemId, ImageId),
CONSTRAINT FK_SaleItem_Images_SaleItemId FOREIGN KEY (SaleItemId) REFERENCES SaleItem (SaleItemId),
CONSTRAINT FK_SaleItem_Images_ImageId FOREIGN KEY (ImageId) REFERENCES Images (ImageId)
);

Create table ServiceCosts (
SaleTypeId INT PRIMARY KEY,
Descrption VARCHAR(200),
FlatFee DOUBLE(10,2),
Percentage DOUBLE(10,2),
AdFee INT,
CONSTRAINT FK_ServiceCosts_SaleTypeId FOREIGN KEY (SaleTypeId) REFERENCES SaleType (SaleTypeId)
);

create table Invoice (/*db scheduled job could populate this*/
InvoiceId INT AUTO_INCREMENT PRIMARY KEY,
UserId INT,
InvAmount DOUBLE(10,2),
Gst DOUBLE(10,2),
InvTotal DOUBLE(10,2),
CreatedDtm DATETIME,
OutstandingAmount DOUBLE(10,2), 
InvoiceSent BIT,
CONSTRAINT FK_Invoice_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId)
);

CREATE UNIQUE INDEX IX_Invoice_UserId ON Invoice (UserId);

create table InvoicedItems (
InvoiceId INT,
SaleItemId INT,
Amount DOUBLE(10,2),
Gst DOUBLE(10,2),
Total DOUBLE(10,2),
CONSTRAINT PK_InvoicedItems PRIMARY KEY (InvoiceId, SaleItemId),
CONSTRAINT FK_InvoicedItems_InvoiceId FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId),
CONSTRAINT FK_Sales_SaleItemId FOREIGN KEY (SaleItemId) REFERENCES Sales (SaleItemId)
);

create table Payments (/*payments recieved go towards first outstanding invoice hence userid*/
PaymentId INT AUTO_INCREMENT PRIMARY KEY,
UserId INT,
PaymentAmount DOUBLE(10,2),
PaymentDtm DATETIME,
CONSTRAINT FK_Payments_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId)
);

CREATE UNIQUE INDEX IX_Payments_UserId ON Payments (UserId);

create table Bids (
SaleItemId INT,
UserId INT,
BidAmount DOUBLE(10,2),
BidDtm DATETIME,
CONSTRAINT PK_Bids PRIMARY KEY (SaleItemId, UserId, BidAmount),
CONSTRAINT FK_Bids_SaleItemId FOREIGN KEY (SaleItemId) REFERENCES SaleItem (SaleItemId),
CONSTRAINT FK_Bids_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId)
);

create table UserNotifications_Category (
UserId INT,
CategoryId INT,
CONSTRAINT PK_UserNotifications_Category PRIMARY KEY (UserId, CategoryId),
CONSTRAINT FK_UserNotifications_Category_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId),
CONSTRAINT FK_UserNotifications_Category_CategoryId FOREIGN KEY (CategoryId) REFERENCES Category (CategoryId)
);

CREATE UNIQUE INDEX IX_Notifications_Category_CategoryId ON UserNotifications_Category (CategoryId);/*because pk index will be huge*/

create table UserNotifications_Book (
UserId INT,
BookId INT,
CONSTRAINT PK_UserNotifications_Book PRIMARY KEY (UserId, BookId),
CONSTRAINT FK_UserNotifications_Book_UserId FOREIGN KEY (UserId) REFERENCES Users (UserId),
CONSTRAINT FK_UserNotifications_Book_BookId FOREIGN KEY (BookId) REFERENCES Book (BookId)
);

create table Fees (
FeeId INT AUTO_INCREMENT PRIMARY KEY,
Descrption VARCHAR(100),
Percent INT,
FlatFee INT
);

