create table AUTHORITY(
    ID int not null AUTO_INCREMENT,
    USER varchar(50) not null,
    ROLE varchar(20) not null,
    PRIMARY KEY ( ID )--, FOREIGN KEY (USER) REFERENCES USER(NAME)
);