CREATE TABLE Users (
    email varchar(255) NOT NULL,
    password varchar(64) NOT NULL,
    name varchar(50) NOT NULL,
    tel int NOT NULL,
    cif varchar(15),
    address varchar(255),
    worth float,
    nif varchar(15),
    bdate date,
    PRIMARY KEY (email)
);

CREATE TABLE User_groups (
    groupId serial NOT NULL,
    groupname VARCHAR(32) NOT NULL,
    PRIMARY KEY (groupId)
);

CREATE TABLE Hotel (
    name varchar(255) NOT NULL,
    city varchar(255) NOT NULL,
    rooms int NOT NULL,
    price float NOT NULL,
    services varchar(255),
    PRIMARY KEY (name)
);

CREATE TABLE UserRelation (
    id serial NOT NULL,
    client varchar(255) NOT NULL,
    clgroup int NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_UserReserve FOREIGN KEY (client) REFERENCES Users(email),
    CONSTRAINT FK_HotelReserve FOREIGN KEY (clgroup) REFERENCES User_groups(groupId)
);

CREATE TABLE Reserve (
    id serial NOT NULL,
    customer varchar(50) NOT NULL,
    hotel varchar(255) NOT NULL,
    day date NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_UserReserve FOREIGN KEY (customer) REFERENCES Users(email),
    CONSTRAINT FK_HotelReserve FOREIGN KEY (hotel) REFERENCES Hotel(name)
);