-- QAP 4 - Advanced Java: Patient Table Creation Script

-- CREATE DATABASE qap4_database;
-- \c qap4_database;

CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);

INSERT INTO patients (id, first_name, last_name, dob) VALUES 
(1, 'John', 'Doe', '1985-05-15'),
(2, 'Jane', 'Smith', '1990-08-22'),
(3, 'Mike', 'Johnson', '1978-12-03')
ON CONFLICT (id) DO NOTHING;

SELECT * FROM patients;
