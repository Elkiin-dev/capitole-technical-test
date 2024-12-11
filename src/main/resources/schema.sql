CREATE TABLE Products (
    SKU VARCHAR(20) PRIMARY KEY,
    Price DECIMAL(10, 2),
    Description VARCHAR(255),
    Category VARCHAR(100)
);
CREATE INDEX idx_category ON Products (Category);