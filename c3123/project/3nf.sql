CREATE TABLE Orders (
    order_id INTEGER PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    vendor_id INTEGER NOT NULL,
    quantity INTEGER,
    order_total DECIMAL,
    order_status VARCHAR(20),
    FOREIGN KEY (customer_id) 
        REFERENCES Customers(customer_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (product_id) 
        REFERENCES Products(product_id)
        ON UPDATE CASCADE,
    FOREIGN KEY (vendor_id) 
        REFERENCES Vendor(vendor_id)
        ON UPDATE CASCADE
);

CREATE TABLE Note (
    note_id INTEGER PRIMARY KEY,
    order_id INTEGER,
    note_content VARCHAR(255),
    FOREIGN KEY (order_id) 
        REFERENCES Orders(order_id)
);

CREATE TABLE Customer (
    customer_id INTEGER PRIMARY KEY,
    customer_name VARCHAR(50),
    customer_email VARCHAR(100),
    customer_phone VARCHAR(20)
);

CREATE TABLE Product (
    product_id INTEGER PRIMARY KEY,
    product_name VARCHAR(100),
    product_price DECIMAL,
    product_stock INTEGER,
    vendor_id INTEGER,
    FOREIGN KEY (vendor_id) REFERENCES Vendors(vendor_id)
);

CREATE TABLE Vendor (
    vendor_id INTEGER PRIMARY KEY,
    vendor_name VARCHAR(100),
    contact_name VARCHAR(50),
    vendor_email VARCHAR(100),
    vendor_phone VARCHAR(20)
);
