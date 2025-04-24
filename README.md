# Hospital Management System

## Overview
The **Hospital Management System** is a Java-based application designed to manage various aspects of a healthcare facility, including:
- Patient registration
- Appointment scheduling
- Billing and invoicing
- Inventory management for medical supplies
- Staff management

This system provides an easy-to-use interface to manage these core functionalities, with a menu-driven console application.

## Features
- **Patient Management**: Register new patients and view all patients.
- **Appointment Management**: Book appointments and view scheduled appointments.
- **Billing Management**: Generate bills for patients and view all bills.
- **Inventory Management**: Add new inventory items and view existing inventory.
- **Staff Management**: Add staff members and view the list of all staff.

## Technologies Used
- **Java**: Core programming language used to implement the system.
- **MySQL**: Database to store and manage the data related to patients, appointments, bills, inventory, and staff.
- **JDBC**: Java Database Connectivity for interaction between the application and MySQL database.

## Getting Started

### Prerequisites
1. **JDK 8 or higher**: Install Java Development Kit (JDK) if not already installed.
2. **MySQL Database**: Set up a MySQL database for the project.
3. **IDE**: Eclipse IDE or any other Java IDE to open and run the project.

### Setting up the Database
- Use the provided SQL scripts to create the necessary tables in MySQL.
- The database should have the following tables:
  - `patients`: To store patient information.
  - `appointments`: To store appointment details.
  - `bills`: To store billing information.
  - `inventory`: To manage medical supplies.
  - `staff`: To store staff details.

### MySQL Database Setup Example

```sql
CREATE DATABASE hospital_management;

USE hospital_management;

CREATE TABLE patients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    contact VARCHAR(15)
);

CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    date DATE,
    time TIME,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

CREATE TABLE bills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    amount DECIMAL(10, 2),
    date DATE,
    FOREIGN KEY (patient_id) REFERENCES patients(id)
);

CREATE TABLE inventory (
    id INT AUTO_INCREMENT PRIMARY KEY,
    item_name VARCHAR(100),
    quantity INT,
    price DECIMAL(10, 2)
);

CREATE TABLE staff (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    role VARCHAR(50),
    department VARCHAR(50),
    contact VARCHAR(15)
);
