CREATE TABLE IF NOT EXISTS patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    contact VARCHAR(15) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE,
    address VARCHAR(255),
    blood_group VARCHAR(10)
);
