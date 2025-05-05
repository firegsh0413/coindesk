CREATE TABLE currency_info (
    id INT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(10) NOT NULL UNIQUE COMMENT '代碼',
    name VARCHAR(50) NOT NULL COMMENT '中文名稱',
    create_user VARCHAR(10) NOT NULL,
    create_date DATETIME NOT NULL,
    update_user VARCHAR,
    update_date DATETIME
);