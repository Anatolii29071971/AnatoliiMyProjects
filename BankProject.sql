CREATE TABLE client (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    manager_id INTEGER,
    status INT(1),
    tax_code VARCHAR(20) unique,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(60),
    address VARCHAR(80),
    phone VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);


CREATE TABLE account (
    id integer  AUTO_INCREMENT PRIMARY KEY,
    client_tax_code varchar(20),
    name VARCHAR(100),
    type integer(1),
    status integer(1),
    balance numeric(15,2),
    currency_code integer(2),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE product (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    manager_id INTEGER,
    product_name VARCHAR(70),
    status INTEGER(1),
    currency_code INTEGER(2),
    interest_rate NUMERIC(6 , 4 ),
    limit_credit NUMERIC(15 , 2 ),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE agreement (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    account_id INTEGER,
    product_id INTEGER,
    interest_rate NUMERIC(6 , 4 ),
    status INTEGER,
    sum NUMERIC(15 , 2 ),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE transaction (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    debit_account INTEGER,
    credit_account INTEGER,
    typ INTEGER(1),
    amount NUMERIC(15 , 2 ),
    description VARCHAR(255),
    created_at TIMESTAMP
);

CREATE TABLE manager (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    status INTEGER(1),
    description VARCHAR(255),
    created_at TIMESTAMP
);