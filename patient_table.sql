-- QAP 4 - Advanced Java: Patient Table Creation Script
-- This script creates the patients table for storing patient data

-- Create database (run this first if database doesn't exist)
-- CREATE DATABASE qap4_database;

-- Use the database
-- \c qap4_database;

-- Create patients table
CREATE TABLE IF NOT EXISTS patients (
    id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dob DATE NOT NULL
);

-- Add some sample data (optional)
INSERT INTO patients (id, first_name, last_name, dob) VALUES 
(1, 'John', 'Doe', '1985-05-15'),
(2, 'Jane', 'Smith', '1990-08-22'),
(3, 'Mike', 'Johnson', '1978-12-03')
ON CONFLICT (id) DO NOTHING;

-- Verify table creation
SELECT * FROM patients;

-- Additional useful queries:

-- Count total patients
-- SELECT COUNT(*) as total_patients FROM patients;

-- Find patients by name
-- SELECT * FROM patients WHERE first_name = 'John';

-- Find patients born after certain date
-- SELECT * FROM patients WHERE dob > '1980-01-01';

-- Drop table (use carefully!)
-- DROP TABLE IF EXISTS patients;
