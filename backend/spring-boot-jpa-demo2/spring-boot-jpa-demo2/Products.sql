Create a table :
CREATE TABLE Product (
	ProductID INT PRIMARY KEY,
    PName VARCHAR(50),
    Price DECIMAL(10, 2),
    Category VARCHAR(50),
    Manufacturer VARCHAR(50)
);

Alter table:
ALTER TABLE Product ADD Expiry DATE;

Insert data:
INSERT INTO Product (ProductId, PName, Price, Category, Manufacturer, Expiry) VALUES 
(1, 'GadgetX', 99.99, 'Gadgets', 'GadgetCo', '2025-12-31'),
(2, 'SmartWatch', 199.99, 'Gadgets', 'TechCorp', '2026-05-15'),
(3, 'WirelessMouse', 29.99, 'Accessories', 'GadgetCo', '2024-11-30'),
(4, 'LaptopBag', 49.99, 'Accessories', 'TechCorp', '2025-03-31'),
(5, 'BluetoothSpeaker', 79.99, 'Gadgets', 'AudioTech', '2026-07-20'),
(6, 'PhoneCase', 15.99, 'Accessories', 'AccessoryWorld', '2024-09-10'),
(7, 'SmartPhone', 499.99, 'Gadgets', 'PhoneMaker', '2025-08-25'),
(8, 'Headphones', 89.99, 'Accessories', 'AudioTech', '2024-12-15');


Select All Data:
SELECT * FROM Product;

Select with Condition:
-- Select products that are not expired (assuming today's date is '2024-07-31')
SELECT * FROM Product WHERE Expiry > '2024-07-31';

Select Specific Columns:
-- Select product name, price, and expiry date for products with price greater than 100
SELECT PName, Price, Expiry FROM Product WHERE Price > 100;

Pattern Matching:
-- Find products with 'Tech' in their manufacturer name
SELECT * FROM Product WHERE Manufacturer LIKE '%Tech%';

Eliminating Duplicates:
-- Get unique categories from the Product table
SELECT DISTINCT Category FROM Product;

Ordering Results:
-- Order products by price in ascending order and then by name
SELECT PName, Price FROM Product ORDER BY Price, PName;

Update Data:
-- Update the expiry date of 'SmartWatch'
UPDATE Product SET Expiry = '2026-12-31' WHERE PName = 'SmartWatch';

Delete Data:
-- Delete the 'WirelessMouse' product
DELETE FROM Product WHERE PName = 'WirelessMouse';

Insert Data
-- Insert a new product into the table with expiry date
INSERT INTO Product (ProductId, PName, Price, Category, Manufacturer, Expiry) 
VALUES (9, '4KMonitor', 299.99, 'Accessories', 'TechVision', '2025-06-30');

Join Example:
-- Join example assuming we have a Company table
-- Creating a sample Company table for illustration
CREATE TABLE Company (
    CName VARCHAR(50) PRIMARY KEY,
    Country VARCHAR(50)
);

INSERT INTO Company (CName, Country) VALUES 
('GadgetCo', 'USA'),
('TechCorp', 'USA'),
('AudioTech', 'USA'),
('AccessoryWorld', 'USA'),
('PhoneMaker', 'China'),
('TechVision', 'USA');

-- Performing the join
SELECT p.PName, p.Price, p.Expiry, c.Country 
FROM Product p 
INNER JOIN Company c 
ON p.Manufacturer = c.CName 
WHERE c.Country = 'USA';

Grouping and Aggregation:
-- Assume we have a Purchase table for aggregation example
CREATE TABLE Purchase (
    Buyer VARCHAR(50),
    ProductId INT,
    Quantity INT,
    Price DECIMAL(10, 2),
    Date DATE
);

-- Insert sample data into Purchase table
INSERT INTO Purchase (Buyer, ProductId, Quantity, Price, Date) VALUES 
('Alice', 1, 2, 99.99, '2024-07-01'),
('Bob', 2, 1, 199.99, '2024-07-02'),
('Charlie', 5, 3, 79.99, '2024-07-03');

-- Group by product and sum the total sales
SELECT p.PName, SUM(p.Price * pu.Quantity) AS TotalSales 
FROM Product p
INNER JOIN Purchase pu ON p.ProductId = pu.ProductId
GROUP BY p.PName;

HAVING Clause:
-- Filter products where total quantity sold is more than 1
SELECT p.PName, SUM(pu.Quantity) AS TotalQuantity 
FROM Product p
INNER JOIN Purchase pu ON p.ProductId = pu.ProductId
GROUP BY p.PName 
HAVING SUM(pu.Quantity) > 1;

Handling NULLs:
-- Check for products with NULL expiry date
SELECT * FROM Product WHERE Expiry IS NULL;