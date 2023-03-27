DROP DATABASE IF EXISTS RentABike;
CREATE DATABASE IF NOT EXISTS RentABike;
USE RentABike;

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer (
                                        customerId VARCHAR(15) NOT NULL,
                                        name VARCHAR(50),
                                        address VARCHAR(100),
                                        contact VARCHAR(20),
                                        email VARCHAR(50),
                                        age INT,
                                        dob DATE,
                                        country VARCHAR(50),
                                        city VARCHAR(50),
                                        zip_code VARCHAR(10),
                                        CONSTRAINT PRIMARY KEY (customerId)
);

DROP TABLE IF EXISTS Booking;
CREATE TABLE IF NOT EXISTS Booking (
                                       bookingId VARCHAR(15) NOT NULL,
                                       chooseBike VARCHAR(50),
                                       PickUpLocation VARCHAR(100),
                                       dropOffLocation VARCHAR(100),
                                       pickUpDate DATE,
                                       dropOffDate DATE,
                                       accessories VARCHAR(100),
                                       cid VARCHAR(15),
                                       CONSTRAINT PRIMARY KEY (bookingId),
                                       CONSTRAINT FOREIGN KEY(cId) REFERENCES Customer(customerId) on Delete Cascade on Update Cascade
);

DROP TABLE IF EXISTS Payment;
CREATE TABLE IF NOT EXISTS Payment (
                                       payId VARCHAR(15) NOT NULL,
                                       payAmount DOUBLE,
                                       payDescription VARCHAR(100),
                                       payDate DATE,
                                       cId VARCHAR(15),
                                       bId VARCHAR(15),
                                       CONSTRAINT PRIMARY KEY (payId),
                                       CONSTRAINT FOREIGN KEY(cId) REFERENCES Customer(customerId) on Delete Cascade on Update Cascade,
                                       CONSTRAINT FOREIGN KEY(bId) REFERENCES Booking(bookingId) on Delete Cascade on Update Cascade
);

DROP TABLE IF EXISTS Vehicle;
CREATE TABLE IF NOT EXISTS Vehicle (
                                       vehicleId VARCHAR(15) NOT NULL,
                                       name VARCHAR(50),
                                       type VARCHAR(50),
                                       rent_price DOUBLE,
                                       mileage VARCHAR(50),
                                       first_aid_kit BOOLEAN,
                                       transmission VARCHAR(50),
                                       roadside_assistance BOOLEAN,
                                       available BOOLEAN,
                                       CONSTRAINT PRIMARY KEY (vehicleId)
);

DROP TABLE IF EXISTS BookingDetails;
CREATE TABLE IF NOT EXISTS BookingDetails (
                                              vId VARCHAR(15),
                                              bId VARCHAR(15),
                                              CONSTRAINT PRIMARY KEY (vId, bId),
                                              CONSTRAINT FOREIGN KEY (vId) REFERENCES Vehicle(vehicleId) on Delete Cascade on Update Cascade,
                                              CONSTRAINT FOREIGN KEY (bId) REFERENCES Booking(bookingId) on Delete Cascade on Update Cascade
);

DROP TABLE IF EXISTS VehicleRoute;
CREATE TABLE IF NOT EXISTS VehicleRoute (
                                            routeId VARCHAR(15) NOT NULL,
                                            vId VARCHAR(15),
                                            vehicle_name VARCHAR(50),
                                            date DATE,
                                            time TIME,
                                            CONSTRAINT PRIMARY KEY (routeId),
                                            CONSTRAINT FOREIGN KEY (vId) REFERENCES Vehicle(vehicleId) on Delete Cascade on Update Cascade
);


/*employee table*/

CREATE TABLE User (
                      user_name VARCHAR(50) NOT NULL,
                      employeeTyped VARCHAR(50),
                      password VARCHAR(50) NOT NULL,
                      CONSTRAINT PRIMARY KEY (user_name)
);

CREATE TABLE Employee (
                          employeeId VARCHAR(50),
                          employeeTyped VARCHAR(50),
                          name VARCHAR(50) NOT NULL,
                          nic VARCHAR(20) NOT NULL,
                          address VARCHAR(100),
                          contact VARCHAR(20),
                          email VARCHAR(50),
                          mobileNumber VARCHAR(20),
                          CONSTRAINT PRIMARY KEY (employeeId)
);

CREATE TABLE Salaries (
                          salaryId VARCHAR(50),
                          description VARCHAR(100),
                          amount DOUBLE,
                          type VARCHAR(50),
                          employeeId VARCHAR(50),
                          CONSTRAINT PRIMARY KEY (salaryId),
                          CONSTRAINT FOREIGN KEY (employeeId) REFERENCES Employee(employeeId) on Delete Cascade on Update Cascade
);

CREATE TABLE Attendance (
                            attendenceId VARCHAR(50),
                            date DATE,
                            holiday BOOLEAN,
                            signInTime TIME,
                            signOutTime TIME,
                            employeeId VARCHAR(50),
                            CONSTRAINT PRIMARY KEY (attendenceId),
                            CONSTRAINT FOREIGN KEY (employeeId) REFERENCES Employee(employeeId) on Delete Cascade on Update Cascade
);


INSERT INTO Customer VALUES('C001', 'John Doe','123 Main St','+94754789723','Danapala@gmail.com', 30 , '1993-01-01' , 'USA' , 'New York', '10001');
INSERT INTO Customer VALUES('c002', 'Jane Smith', '456 Oak St', '555-5678', 'janesmith@email.com', 25, '1998-05-15', 'USA', 'Los Angeles', '90001');
INSERT INTO Customer VALUES('c003', 'Bob Johnson', '789 Elm St', '555-2468', 'bob@example.com', 41, '1981-02-28', 'Canada', 'Toronto', 'M5H 2N2');
INSERT INTO Customer VALUES('c004', 'Alice Wong', '321 Pine St', '555-1357', 'alice@example.com', 29, '1993-11-22', 'Canada', 'Vancouver', 'V6B 1E1');
INSERT INTO Customer VALUES('c005', 'Tom Wilson', '654 Birch St', '555-3698', 'tom@example.com', 24, '1998-07-03', 'USA', 'Chicago', '60601');
INSERT INTO Customer VALUES('c006', 'Samantha Lee', '987 Cedar St', '555-7890', 'samantha@example.com', 33, '1989-12-18', 'Canada', 'Montreal', 'H2X 1Y9');
INSERT INTO Customer VALUES('c007', 'David Kim', '234 Maple St', '555-2345', 'david@example.com', 30, '1991-08-12', 'USA', 'San Francisco', '94102');
INSERT INTO Customer VALUES('c008', 'Emily Chen', '567 Walnut St', '555-8901', 'emily@example.com', 26, '1996-03-29', 'Canada', 'Calgary', 'T2P 1G1');
INSERT INTO Customer VALUES('c009', 'Michael Brown', '890 Oak St', '555-4815', 'michael@example.com', 38, '1984-10-17', 'USA', 'Houston', '77002');
INSERT INTO Customer VALUES('c010', 'Karen Jones', '432 Elm St', '555-2580', 'karen@example.com', 31, '1990-06-08', 'USA', 'Miami', '33131');


INSERT INTO Booking VALUES('b001', 'Mountain Bike', '123 Main St', '456 Oak Ave', '2023-04-01', '2023-04-03', 'POWER BANK', 'c001');
INSERT INTO Booking VALUES('b002', 'Road Bike', '789 Elm St', '321 Pine Ave', '2023-04-05', '2023-04-07', 'Water Bottle', 'c002');
INSERT INTO Booking VALUES('b003', 'Hybrid Bike', '456 Oak Ave', '123 Main St', '2023-04-12', '2023-04-15', 'POWER BANK', 'c003');
INSERT INTO Booking VALUES('b004', 'Mountain Bike', '321 Pine Ave', '789 Elm St', '2023-04-20', '2023-04-23', 'POCKET WIFI 4G', 'c004');
INSERT INTO Booking VALUES('b005', 'Road Bike', '123 Main St', '456 Oak Ave', '2023-04-27', '2023-04-29', 'POCKET WIFI 4G', 'c005');
INSERT INTO Booking VALUES('b006', 'Hybrid Bike', '789 Elm St', '321 Pine Ave', '2023-05-04', '2023-05-07', 'Lock', 'c006');
INSERT INTO Booking VALUES('b007', 'Mountain Bike', '456 Oak Ave', '123 Main St', '2023-05-11', '2023-05-14', 'Helmet, POWER BANK', 'c007');
INSERT INTO Booking VALUES('b008', 'Road Bike', '321 Pine Ave', '789 Elm St', '2023-05-18', '2023-05-21', 'Helmet', 'c008');
INSERT INTO Booking VALUES('b009', 'Hybrid Bike', '123 Main St', '456 Oak Ave', '2023-05-25', '2023-05-27', 'Water Bottle', 'c009');
INSERT INTO Booking VALUES('b010', 'Mountain Bike', '789 Elm St', '321 Pine Ave', '2023-06-01', '2023-06-03', 'RAINCOAT,  POWER BANK', 'c010');

INSERT INTO Payment VALUES('p001', 4100.50, 'Deposit payment for booking #1', '2023-04-01', 'c001', 'b001');
INSERT INTO Payment VALUES('p002', 3375.00, 'Full payment for booking #2', '2023-05-15', 'c002', 'b002');
INSERT INTO Payment VALUES('p003', 5520.00, 'Additional charges for accessories', '2023-06-05', 'c003', 'b003');
INSERT INTO Payment VALUES('p004', 6550.00, 'Partial payment for booking #4', '2023-07-01', 'c004', 'b004');
INSERT INTO Payment VALUES('p005', 4200.00, 'Full payment for booking #5', '2023-08-15', 'c005', 'b005');
INSERT INTO Payment VALUES('p006', 2150.00, 'Full payment for booking #6', '2023-09-01', 'c006', 'b006');
INSERT INTO Payment VALUES('p007', 2230.00, 'Additional charges for mileage', '2023-10-01', 'c007', 'b007');
INSERT INTO Payment VALUES('p008', 1250.00, 'Partial payment for booking #8', '2023-11-01', 'c008', 'b008');
INSERT INTO Payment VALUES('p009', 2380.00, 'Full payment for booking #9', '2023-12-15', 'c009', 'b009');
INSERT INTO Payment VALUES('p010', 4100.00, 'Full payment for booking #10', '2024-01-01', 'c010', 'b010');

INSERT INTO Vehicle VALUES('v001', 'Honda Activa', 'Scooter', 10000, 'unlimited', true, 'Automatic', true, true);
INSERT INTO Vehicle VALUES('v002', 'Royal Enfield Classic', 'Cruiser', 8500, 'unlimited', false, 'Manual', true, true);
INSERT INTO Vehicle VALUES('v003', 'Bajaj Pulsar', 'Sports Bike', 6600, 'unlimited', true, 'Manual', true, false);
INSERT INTO Vehicle VALUES('v004', 'TVS Jupiter', 'Scooter', 2550, 'unlimited', true, 'Automatic', false, true);
INSERT INTO Vehicle VALUES('v005', 'Hero Splendor Plus', 'Street Bike', 400, 'unlimited', true, 'Manual', true, true);
INSERT INTO Vehicle VALUES('v006', 'Suzuki Access', 'Scooter', 6680, 'unlimited', false, 'Automatic', true, false);
INSERT INTO Vehicle VALUES('v007', 'KTM Duke', 'Sports Bike', 16000, 'unlimited', true, 'Manual', true, true);
INSERT INTO Vehicle VALUES('v008', 'Yamaha FZS', 'Street Bike', 5700, 'unlimited', true, 'Manual', false, true);
INSERT INTO Vehicle VALUES('v009', 'Honda CB Unicorn', 'Street Bike', 4550, 'unlimited', false, 'Manual', true, false);
INSERT INTO Vehicle VALUES('v010', 'Harley Davidson Fat Boy', 'Cruiser', 15500, 'unlimited', true, 'Manual', true, true);

INSERT INTO BookingDetails VALUES('v001','b001');
INSERT INTO BookingDetails VALUES('v002','b002');
INSERT INTO BookingDetails VALUES('v003','b003');
INSERT INTO BookingDetails VALUES('v004','b004');
INSERT INTO BookingDetails VALUES('v005','b005');
INSERT INTO BookingDetails VALUES('v006','b006');
INSERT INTO BookingDetails VALUES('v007','b007');
INSERT INTO BookingDetails VALUES('v008','b008');
INSERT INTO BookingDetails VALUES('v009','b009');
INSERT INTO BookingDetails VALUES('v010','b010');

INSERT INTO VehicleRoute VALUES('VR001', 'V001', 'Honda Activa', '2023-04-01', '09:00:00');
INSERT INTO VehicleRoute VALUES('VR002', 'V002', 'TVS Jupiter', '2023-04-02', '10:30:00');
INSERT INTO VehicleRoute VALUES('VR003', 'V003', 'Suzuki Access', '2023-04-03', '13:45:00');
INSERT INTO VehicleRoute VALUES('VR004', 'V004', 'Bajaj Avenger', '2023-04-04', '11:15:00');
INSERT INTO VehicleRoute VALUES('VR005', 'V005', 'Yamaha FZ', '2023-04-05', '15:00:00');
INSERT INTO VehicleRoute VALUES('VR006', 'V006', 'Hero Passion', '2023-04-06', '12:30:00');
INSERT INTO VehicleRoute VALUES('VR007', 'V007', 'KTM Duke', '2023-04-07', '14:00:00');
INSERT INTO VehicleRoute VALUES('VR008', 'V008', 'Royal Enfield', '2023-04-08', '16:30:00');
INSERT INTO VehicleRoute VALUES('VR009', 'V009', 'Suzuki Hayabusa', '2023-04-09', '18:00:00');
INSERT INTO VehicleRoute VALUES('VR010', 'V010', 'Harley Davidson', '2023-04-10', '17:30:00');

INSERT INTO User VALUES('Chathura Bashitha','receptionist', 'letmeIn');
INSERT INTO User VALUES('Dilshan Fernando','manager' ,'secret123');

INSERT INTO Employee VALUES('ep001','receptionist','Chathura Perera' , '946101273V', 'No. 123, Galle Road, Colombo', '0112345678', 'chathura@gmail.com', '0771234567');
INSERT INTO Employee VALUES('ep002', 'mechanic' ,'Nimasha Silva' , '947691234V', 'No. 456, Kandy Road, Kadawatha', '0113456789', 'nimasha@yahoo.com', '0762345678');

INSERT INTO Salaries VALUES('sl001','Monthly Salary', 75000.00, 'Basic', 'ep001');
INSERT INTO Salaries VALUES('sl002','Monthly Salary', 65000.00, 'Basic', 'ep002');

INSERT INTO Attendance VALUES('at001','2023-03-01', true, '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at002','2023-03-01', true, '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at003','2023-03-02', true, '08:45:00', '17:15:00', 'ep001');
INSERT INTO Attendance VALUES('at004','2023-03-02', true, '08:45:00', '17:15:00', 'ep002');
INSERT INTO Attendance VALUES('at005','2023-03-03', true, '08:15:00', '17:30:00', 'ep001');
INSERT INTO Attendance VALUES('at006','2023-03-03', true, '08:15:00', '17:30:00', 'ep002');
INSERT INTO Attendance VALUES('at007','2023-03-04', true, '08:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at008','2023-03-04', true, '08:00:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at009','2023-03-05', true, '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at010','2023-03-05', true, '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at011','2023-03-06', false, NULL, NULL, 'ep001');
INSERT INTO Attendance VALUES('at012','2023-03-06', false, NULL, NULL, 'ep002');
INSERT INTO Attendance VALUES('at013','2023-03-07', true, '08:15:00', '17:30:00', 'ep001');
INSERT INTO Attendance VALUES('at014','2023-03-07', true, '08:15:00', '17:30:00', 'ep002');
INSERT INTO Attendance VALUES('at015','2023-03-08', true, '09:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at016','2023-03-08', true, '09:00:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at017','2023-03-09', true, '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at018','2023-03-09', true, '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at019','2023-03-10', true, '08:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at020','2023-03-10', true, '08:00:00', '17:00:00', 'ep002');






