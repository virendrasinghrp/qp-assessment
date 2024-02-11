create table USER(
    ID int not null AUTO_INCREMENT,
    NAME varchar(50) not null,
    EMAIL varchar(20) not null,
    PASSWORD varchar(20) not null,
    ENABLED char(1) not null,
    PRIMARY KEY (ID)
);