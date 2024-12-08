CREATE TABLE products
(
    price          NUMERIC(38, 2) NOT NULL,
    stock_quantity INTEGER,
    id             UUID           NOT NULL,
    description    VARCHAR(255)   NOT NULL,
    photo          VARCHAR(255),
    title          VARCHAR(255)   NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE orders_products
(
    order_id    UUID NOT NULL,
    products_id UUID NOT NULL
);

CREATE TABLE orders
(
    id      UUID NOT NULL,
    user_id UUID,
    status  VARCHAR(255) CHECK (status IN ('ORDER_NOT_PAID', 'ORDER_PAID', 'ORDER_PROCESSING', 'ORDER_DELIVERED',
                                           'ORDER_COMPLETED')),
    PRIMARY KEY (id)
);


INSERT INTO products (id, price, stock_quantity, description, photo, title)
VALUES (gen_random_uuid (), 19.99, 100, 'A great product for everyday use.', 'photo1.jpg',
        'Product A'),
       ( gen_random_uuid (),29.99, 50, 'An essential item for your kitchen.', 'photo2.jpg',
        'Product B'),
       ( gen_random_uuid (),9.99, 200, 'A must-have gadget for tech lovers.', 'photo3.jpg',
        'Product C'),
       (gen_random_uuid (),49.99, 30, 'Perfect for outdoor adventures.', 'photo4.jpg',
        'Product D'),
       (gen_random_uuid (),15.99, 75, 'Stylish and comfortable.', 'photo5.jpg', 'Product E');

