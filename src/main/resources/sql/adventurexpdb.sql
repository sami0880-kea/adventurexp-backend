DROP DATABASE IF EXISTS adventurexp;
CREATE DATABASE IF NOT EXISTS adventurexp;
use adventurexp;

CREATE TABLE Activity (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          image VARCHAR(255),
                          description TEXT,
                          min_age INT,
                          price INT
);

CREATE TABLE Booking (
                         booking_id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         participants INT,
                         email VARCHAR(255),
                         phone_number INT,
                         date DATE,
                         time TIME,
                         comment TEXT,
                         activity_id INT,
                         total INT,
                         FOREIGN KEY (activity_id) REFERENCES Activity(id)
);

CREATE TABLE Employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE Equipment (
                           equipment_id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           amount INT NOT NULL,
                           activity_id INT,
                           FOREIGN KEY (activity_id) REFERENCES Activity(id)
);