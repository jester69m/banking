CREATE TABLE customers
(
    id         BIGSERIAL NOT NULL,
    email      VARCHAR(25),
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    phone      VARCHAR(13),
    PRIMARY KEY (id)
);
CREATE TABLE accounts
(
    id          BIGSERIAL NOT NULL,
    balance     FLOAT(53),
    type        VARCHAR(255),
    customer_id BIGSERIAL NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
