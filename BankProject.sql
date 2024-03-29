CREATE TABLE if not exists clients (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    manager_id integer,
    status tinyint check(status  between -125 and 125),
    tax_code VARCHAR(20) unique,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(60),
    address VARCHAR(80),
    phone VARCHAR(20),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);


CREATE TABLE if not exists  accounts (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    client_id integer,
    account_name VARCHAR(100),
    type TINYINT CHECK (type BETWEEN - 125 AND 125),
    status TINYINT CHECK (status BETWEEN - 125 AND 125),
    balance NUMERIC(15 , 2 ),
    currency_code smallint,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    foreign key (client_id) references clients ( id)
);

CREATE TABLE if not exists  products (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    manager_id smallint,
    product_name VARCHAR(70),
    status tinyint check(status  between -125 and 125),
    currency_code smallint,
    interest_rate NUMERIC(12 , 4 ),
    limit_credit NUMERIC(15 , 2 ),
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE if not exists  agreements (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    account_id INTEGER,
    product_id INTEGER,
    interest_rate NUMERIC(12 , 4 ),
    status TINYINT CHECK (status BETWEEN - 125 AND 125),
    sum NUMERIC(15 , 2 ),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (account_id)
        REFERENCES accounts (id),
    FOREIGN KEY (product_id)
        REFERENCES products (id)
);

CREATE TABLE if not exists  transactions (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    debit_account INTEGER,
    credit_account INTEGER,
    typ TINYINT CHECK (typ BETWEEN - 125 AND 125),
    amount NUMERIC(15 , 2 ),
    description VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (debit_account)
        REFERENCES accounts (id)
);

CREATE TABLE IF NOT EXISTS managers (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    status TINYINT CHECK (status BETWEEN - 125 AND 125),
    description VARCHAR(255),
    created_at TIMESTAMP
);

