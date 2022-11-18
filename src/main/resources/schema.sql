DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES (
    id IDENTITY,
    brand_id INT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    price FLOAT,
    curr VARCHAR(10)
);