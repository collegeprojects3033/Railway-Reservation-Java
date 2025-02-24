-- Create a database
CREATE DATABASE railway_system;

USE railway_system;

-- Table for storing train information
CREATE TABLE trains (
    train_id INT AUTO_INCREMENT PRIMARY KEY,
    train_name VARCHAR(255),
    source VARCHAR(255),
    destination VARCHAR(255),
    available_seats INT,
    price DECIMAL(10, 2)
);

-- Table for storing user information
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    phone VARCHAR(20)
);

-- Table for storing reservations
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    train_id INT,
    seats INT,
    reservation_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (train_id) REFERENCES trains(train_id)
);
