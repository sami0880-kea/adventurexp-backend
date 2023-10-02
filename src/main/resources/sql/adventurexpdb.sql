CREATE DATABASE IF NOT EXISTS adventurexp;
use adventurexp;

CREATE TABLE activity (
    activity_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    description TEXT,
    min_age INT
);

CREATE TABLE booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    activity_id INT,
    booked_time DATETIME NOT NULL,
    FOREIGN KEY (activity_id) REFERENCES activity(activity_id)
);