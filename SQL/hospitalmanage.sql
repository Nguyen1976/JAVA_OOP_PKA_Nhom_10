create database if not exists quanlybenhvien;
use quanlybenhvien;
create table login(
	userName varchar(50) primary key,
    password varchar(50)
);
insert into login (userName, password) values
('admin', 1);

create table if not exists treatmentRoom(
	roomId int primary key not null auto_increment,
    roomName varchar(255) not null,
    roomType varchar(255) not null,
    capacity int not null,
    patientsList varchar(255)
);
INSERT INTO treatmentRoom (roomName, roomType, capacity) 
VALUES
('Room 40', 'General', 41),
('Room 37', 'Emergency', 34),
('Room 88', 'General', 29),
('Room 50', 'Surgery', 25),
('Room 22', 'ICU', 18),
('Room 13', 'General', 30),
('Room 72', 'Pediatrics', 20),
('Room 15', 'Emergency', 40),
('Room 91', 'Maternity', 35),
('Room 66', 'Radiology', 22);

CREATE TABLE if not exists Patient (
    patientId INT PRIMARY KEY auto_increment not null,
    roomId int,
    name VARCHAR(100) not null,
    age INT not null,
    gender VARCHAR(10) not null,
    diagnose VARCHAR(255) not null,
    city VARCHAR(100) not null,
    district VARCHAR(100) not null,
    phone VARCHAR(15) not null,
    foreign key(roomId) references treatmentroom(roomId)
);
INSERT INTO Patient (patientId, name, age, gender, diagnose, city, district, phone) VALUES
(1, 'Nguyen Van A', 30, 'Male', 'Flu', 'Hanoi', 'Dong Da', '0987654321'),
(2, 'Tran Thi B', 25, 'Female', 'Cold', 'Hanoi', 'Cau Giay', '0981234567'),
(3, 'Le Van C', 45, 'Male', 'Diabetes', 'Da Nang', 'Hai Chau', '0976543210')