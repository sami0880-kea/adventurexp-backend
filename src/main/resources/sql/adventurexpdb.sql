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
                         bookingId INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         participants INT,
                         email VARCHAR(255),
                         phoneNumber INT,
                         date DATE,
                         time TIME,
                         comment TEXT,
                         activityId INT,
                         total INT,
                         FOREIGN KEY (activityId) REFERENCES Activity(id)
);

CREATE TABLE Employee (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE Equipment (
                           equipmentId INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           amount INT NOT NULL,
                           activityId INT,
                           FOREIGN KEY (activityId) REFERENCES Activity(id)
);