DROP DATABASE IF EXISTS RentABike;
CREATE DATABASE IF NOT EXISTS RentABike;
USE RentABike;

DROP TABLE IF EXISTS Customer;
CREATE TABLE IF NOT EXISTS Customer (
                                        customerId VARCHAR(15) NOT NULL,
                                        name VARCHAR(50),
                                        age INT,
                                        contact VARCHAR(20),
                                        email VARCHAR(50),
                                        address VARCHAR(100),
                                        city VARCHAR(50),
                                        country VARCHAR(50),
                                        zip_code VARCHAR(20),
                                        CONSTRAINT PRIMARY KEY (customerId)
);

DROP TABLE IF EXISTS Booking;
CREATE TABLE IF NOT EXISTS Booking (
                                       bookingId VARCHAR(15) NOT NULL,
                                       chooseBike VARCHAR(50),
                                       PickUpLocation VARCHAR(100),
                                       pickUpDate DATE,
                                       pickUpTime VARCHAR(10),
                                       dropOffLocation VARCHAR(100),
                                       dropOffDate DATE,
                                       dropOffTime VARCHAR(10),
                                      /* cid VARCHAR(15),*/
                                       CONSTRAINT PRIMARY KEY (bookingId)
                                       /*CONSTRAINT FOREIGN KEY(cId) REFERENCES Customer(customerId) on Delete Cascade on Update Cascade*/
);



DROP TABLE IF EXISTS Payment;
CREATE TABLE IF NOT EXISTS Payment (
                                       paymentId VARCHAR(15) NOT NULL,
                                       paymentAmount DOUBLE,
                                       paymentDescription VARCHAR(100),
                                       paymentDate VARCHAR(15),
                                       cId VARCHAR(15),
                                       bId VARCHAR(15),
                                       CONSTRAINT PRIMARY KEY (paymentId),
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
                                       first_aid_kit VARCHAR(50),
                                       transmission VARCHAR(50),
                                       roadside_assistance VARCHAR(50),
                                       available VARCHAR(50),
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
                          CONSTRAINT PRIMARY KEY (employeeId)
);

CREATE TABLE Salaries (
                          salaryId VARCHAR(50),
                          description VARCHAR(100),
                          amount DOUBLE,
                          type VARCHAR(50),
                          month VARCHAR(50),
                          employeeId VARCHAR(50),
                          CONSTRAINT PRIMARY KEY (salaryId)
);

CREATE TABLE Attendance (
                            attendenceId VARCHAR(50),
                            date DATE,
                            holiday VARCHAR(50),
                            signInTime VARCHAR(50),
                            signOutTime VARCHAR(50),
                            employeeId VARCHAR(50),
                            CONSTRAINT PRIMARY KEY (attendenceId)
                            /*CONSTRAINT FOREIGN KEY (employeeId) REFERENCES Employee(employeeId) on Delete Cascade on Update Cascade*/
);


INSERT INTO Customer VALUES('C001', 'John Doe', 28 ,'+94754789723','Danapala@gmail.com','123 Main St', 'New York', 'USA' , '10001');
INSERT INTO Customer VALUES('C002', 'Jane Smith', 35, '+44789562341', 'jane.smith@example.com', '456 Elm St', 'London', 'UK', '8006');
INSERT INTO Customer VALUES('C003', 'Robert Johnson', 42, '+16175551212', 'robert.johnson@example.com', '789 Maple Ave', 'Chicago', 'USA', '60611');
INSERT INTO Customer VALUES('C004', 'Maria Garcia', 29, '+34917654321', 'maria.garcia@example.com', '10 Calle de Alcala', 'Madrid', 'Spain', '28001');
INSERT INTO Customer VALUES('C005', 'Jens Schmidt', 46, '+49123456789', 'jens.schmidt@example.com', '321 Rosenstrasse', 'Berlin', 'Germany', '10115');
INSERT INTO Customer VALUES('C006', 'Yuji Tanaka', 31, '+81345678901', 'yuji.tanaka@example.com', '456 Shibuya Crossing', 'Tokyo', 'Japan', '0002');
INSERT INTO Customer VALUES('C007', 'Sophie Dubois', 25, '+33123456789', 'sophie.dubois@example.com', '789 Rue de Rivoli', 'Paris', 'France', '75001');
INSERT INTO Customer VALUES('C008', 'Miguel Rodriguez', 36, '+5215555555555', 'miguel.rodriguez@example.com', '123 Av. Reforma', 'Mexico City', 'Mexico', '06600');
INSERT INTO Customer VALUES('C009', 'Anastasia Ivanova', 27, '+74951234567', 'anastasia.ivanova@example.com', '456 Nevsky Prospekt', 'St. Petersburg', 'Russia', '191023');
INSERT INTO Customer VALUES('C010', 'Kim Min-Jae', 33, '+8221234567', 'kim.minjae@example.com', '789 Gangnam-gu', 'Seoul', 'South Korea', '06001');
INSERT INTO Customer VALUES('C011', 'Lucas Silva', 30, '+5511999999999', 'lucas.silva@example.com', '123 Avenida Paulista', 'Sao Paulo', 'Brazil', '01310');



INSERT INTO Booking VALUES('b001', 'Mountain Bike', 'Nugegoda', '2023-04-01','11.23', 'Nugegoda', '2023-04-03','20.54' /*'c001'*/);
INSERT INTO Booking VALUES('b002', 'City Bike', 'Colombo 07', '2023-04-06', '09.30', 'Colombo 03', '2023-04-07', '17.45' /*'c002'*/);
INSERT INTO Booking VALUES('b003', 'Mountain Bike', 'Kandy', '2023-04-08', '14.00', 'Kandy', '2023-04-10', '18.30' /*'c003'*/);
INSERT INTO Booking VALUES('b004', 'Electric Bike', 'Negombo', '2023-04-11', '10.15', 'Negombo', '2023-04-13', '19.00' /*'c004'*/);
INSERT INTO Booking VALUES('b005', 'City Bike', 'Galle', '2023-04-15', '11.45', 'Galle', '2023-04-16', '16.30' /*'c005'*/);
INSERT INTO Booking VALUES('b006', 'Mountain Bike', 'Nuwara Eliya', '2023-04-19', '08.00', 'Nuwara Eliya', '2023-04-21', '12.15' /*'c006'*/);
INSERT INTO Booking VALUES('b007', 'Electric Bike', 'Matara', '2023-04-23', '13.30', 'Matara', '2023-04-25', '16.45'/*, 'c007'*/);
INSERT INTO Booking VALUES('b008', 'City Bike', 'Anuradhapura', '2023-04-27', '10.00', 'Anuradhapura', '2023-04-28', '15.15'/*', 'c008'*/);
INSERT INTO Booking VALUES('b009', 'Mountain Bike', 'Polonnaruwa', '2023-05-01', '12.45', 'Polonnaruwa', '2023-05-03', '19.30'/*', 'c009'*/);
INSERT INTO Booking VALUES('b010', 'Electric Bike', 'Trincomalee', '2023-05-05', '09.00', 'Trincomalee', '2023-05-06', '13.45'/*, 'c010'*/);

INSERT INTO Payment VALUES('p001', 4100.50, 'Deposit payment for booking #1', '2023-03-20', 'c001', 'b001');
INSERT INTO Payment VALUES('p002', 3375.00, 'Full payment for booking #2', '2023-03-21', 'c002', 'b002');
INSERT INTO Payment VALUES('p003', 5520.00, 'Additional charges for accessories', '2023-03-22', 'c003', 'b003');
INSERT INTO Payment VALUES('p004', 6550.00, 'Partial payment for booking #4', '2023-03-22', 'c004', 'b004');
INSERT INTO Payment VALUES('p005', 4200.00, 'Full payment for booking #5', '2023-03-23', 'c005', 'b005');
INSERT INTO Payment VALUES('p006', 2150.00, 'Full payment for booking #6', '2023-03-23', 'c006', 'b006');
INSERT INTO Payment VALUES('p007', 2230.00, 'Additional charges for mileage', '2023-03-24', 'c007', 'b007');
INSERT INTO Payment VALUES('p008', 1250.00, 'Partial payment for booking #8', '2023-03-24', 'c008', 'b008');
INSERT INTO Payment VALUES('p009', 2380.00, 'Full payment for booking #9', '2023-03-25', 'c009', 'b009');
INSERT INTO Payment VALUES('p010', 4100.00, 'Full payment for booking #10', '2023-03-25', 'c010', 'b010');
INSERT INTO Payment VALUES('p011', 3200.00, 'Deposit payment for booking #11', '2023-03-26', 'c011', 'b010');
INSERT INTO Payment VALUES('p012', 4700.00, 'Full payment for booking #12', '2023-03-27', 'C011', 'b010');
INSERT INTO Payment VALUES('p013', 1900.00, 'Additional charges for cleaning', '2023-03-27', 'C011', 'b010');
INSERT INTO Payment VALUES('p014', 2600.00, 'Partial payment for booking #14', '2023-03-28', 'C011', 'b010');
INSERT INTO Payment VALUES('p015', 5400.00, 'Full payment for booking #15', '2023-03-29', 'C011', 'b010');
INSERT INTO Payment VALUES('p016', 3100.00, 'Full payment for booking #16', '2023-03-30', 'C011', 'b010');
INSERT INTO Payment VALUES('p017', 1850.00, 'Additional charges for gas', '2023-03-30', 'C011', 'b010');
INSERT INTO Payment VALUES('p018', 4250.00, 'Partial payment for booking #18', '2023-04-01', 'C011', 'b010');
INSERT INTO Payment VALUES('p019', 4900.00, 'Full payment for booking #19', '2023-04-02', 'C011', 'b010');
INSERT INTO Payment VALUES('p020', 6300.00, 'Full payment for booking #20', '2023-04-03', 'C011', 'b010');
INSERT INTO Payment VALUES('p021', 3700.00, 'Deposit payment for booking #21', '2023-04-04', 'C011', 'b010');
INSERT INTO Payment VALUES('p022', 2800.00, 'Full payment for booking #22', '2023-04-05', 'C011', 'b010');
INSERT INTO Payment VALUES('p023', 2150.00, 'Additional charges for late return', '2023-04-06', 'C011', 'b010');
INSERT INTO Payment VALUES('p024', 4150.00, 'Partial payment for booking #24', '2023-04-07', 'C011', 'b010');
INSERT INTO Payment VALUES('p025', 4200.00, 'Full payment for booking #25', '2023-04-08', 'C011', 'b010');
INSERT INTO Payment VALUES('p026', 1800.00, 'Full payment for booking #26', '2023-04-09', 'C011', 'b010');
INSERT INTO Payment VALUES('p027', 1230.00, 'Additional charges for tolls', '2023-04-10', 'C011', 'b010');
INSERT INTO Payment VALUES('p028', 2980.00, 'Partial payment for booking #28', '2023-04-11', 'C011', 'b010');
INSERT INTO Payment VALUES('p029', 3850.00, 'Full payment for booking #29', '2023-04-12', 'C011', 'b010');
INSERT INTO Payment VALUES('p030', 5100.00, 'Full payment for booking #30', '2023-04-12', 'C011', 'b010');
INSERT INTO Payment VALUES('p031', 3400.00, 'Deposit payment for booking #31', '2023-04-13', 'C011', 'b010');
INSERT INTO Payment VALUES('p032', 2400.00, 'Full payment for booking #32', '2023-04-13', 'C011', 'b010');
INSERT INTO Payment VALUES('p033', 1780.00, 'Additional charges for parking tickets', '2023-04-14', 'C011', 'b010');
INSERT INTO Payment VALUES('p034', 3650.00, 'Partial payment for booking #34', '2023-04-15', 'C011', 'b010');
INSERT INTO Payment VALUES('p035', 4300.00, 'Full payment for booking #35', '2023-04-16', 'C011', 'b010');
INSERT INTO Payment VALUES('p036', 2100.00, 'Full payment for booking #36', '2023-04-16', 'C011', 'b010');
INSERT INTO Payment VALUES('p037', 1430.00, 'Additional charges for cleaning', '2023-04-16', 'C011', 'b010');
INSERT INTO Payment VALUES('p038', 2750.00, 'Partial payment for booking #38', '2023-04-17', 'C011', 'b010');
INSERT INTO Payment VALUES('p039', 4650.00, 'Full payment for booking #39', '2023-04-18', 'C011', 'b010');
INSERT INTO Payment VALUES('p040', 5700.00, 'Full payment for booking #40', '2023-04-19', 'C011', 'b010');



INSERT INTO Vehicle VALUES('v001', 'Honda Activa', 'Scooter', 10000, 'unlimited', 'yes', 'Automatic', 'yes', 'yes');
INSERT INTO Vehicle VALUES('v002', 'Royal Enfield Classic', 'Bike', 8500, 'unlimited', 'no', 'Manual', 'yes', 'yes');
INSERT INTO Vehicle VALUES('v003', 'Bajaj Pulsar', 'Bike', 6600, 'unlimited', 'yes', 'Manual', 'yes', 'no');
INSERT INTO Vehicle VALUES('v004', 'TVS Jupiter', 'Scooter', 2550, 'unlimited', 'yes', 'Automatic', 'no', 'yes');
INSERT INTO Vehicle VALUES('v005', 'Hero Splendor Plus', 'Bike', 400, 'unlimited', 'yes', 'Manual', 'yes', 'yes');
INSERT INTO Vehicle VALUES('v006', 'Suzuki Access', 'Scooter', 6680, 'unlimited', 'no', 'Automatic', 'yes', 'no');
INSERT INTO Vehicle VALUES('v007', 'KTM Duke', 'Bike', 16000, 'unlimited', 'yes', 'Manual', 'yes', 'yes');
INSERT INTO Vehicle VALUES('v008', 'Yamaha FZS', 'Bike', 5700, 'unlimited', 'yes', 'Manual', 'no', 'yes');
INSERT INTO Vehicle VALUES('v009', 'Honda CB Unicorn', 'Bike', 4550, 'unlimited', 'no' , 'Manual', 'yes', 'no');
INSERT INTO Vehicle VALUES('v010', 'Harley Davidson Fat Boy', 'Bike', 15500, 'unlimited', 'yes', 'Manual', 'yes', 'yes');

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

INSERT INTO User VALUES('Chathura Bashitha', 'letmeIn');
INSERT INTO User VALUES('hello','1234');
INSERT INTO User VALUES('niko','bye');
INSERT INTO User VALUES('1','1');

INSERT INTO Employee VALUES('ep001','receptionist','Chathura Perera' , '946101273V', 'No. 123, Galle Road, Colombo', '0112345678', 'chathura@gmail.com');
INSERT INTO Employee VALUES('ep002', 'mechanic' ,'Nimasha Silva' , '947691234V', 'No. 456, Kandy Road, Kadawatha', '0113456789', 'nimasha@yahoo.com');

INSERT INTO Salaries VALUES('sl001','Monthly Salary', 75000.00, 'Basic', 'January' , 'ep001');
INSERT INTO Salaries VALUES('sl002','Monthly Salary', 65000.00, 'Basic', 'January' , 'ep002');

INSERT INTO Attendance VALUES('at001','2023-03-01', 'workday', '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at002','2023-03-01', 'workday', '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at003','2023-03-02', 'workday', '08:45:00', '17:15:00', 'ep001');
INSERT INTO Attendance VALUES('at004','2023-03-02', 'workday', '08:45:00', '17:15:00', 'ep002');
INSERT INTO Attendance VALUES('at005','2023-03-03', 'workday', '08:15:00', '17:30:00', 'ep001');
INSERT INTO Attendance VALUES('at006','2023-03-03', 'workday', '08:15:00', '17:30:00', 'ep002');
INSERT INTO Attendance VALUES('at007','2023-03-04', 'workday', '08:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at008','2023-03-04', 'workday', '08:00:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at009','2023-03-05', 'workday', '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at010','2023-03-05', 'workday', '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at011','2023-03-06', 'holiday', NULL, NULL, 'ep001');
INSERT INTO Attendance VALUES('at012','2023-03-06', 'holiday', NULL, NULL, 'ep002');
INSERT INTO Attendance VALUES('at013','2023-03-07', 'workday', '08:15:00', '17:30:00', 'ep001');
INSERT INTO Attendance VALUES('at014','2023-03-07', 'workday', '08:15:00', '17:30:00', 'ep002');
INSERT INTO Attendance VALUES('at015','2023-03-08', 'workday', '09:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at016','2023-03-08', 'workday', '09:00:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at017','2023-03-09', 'workday', '08:30:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at018','2023-03-09', 'workday', '08:30:00', '17:00:00', 'ep002');
INSERT INTO Attendance VALUES('at019','2023-03-10', 'workday', '08:00:00', '17:00:00', 'ep001');
INSERT INTO Attendance VALUES('at020','2023-03-10', 'workday', '08:00:00', '17:00:00', 'ep002');






