/* FOR JDBC*/

create table person
(id integer not null ,
name varchar (255) not null,
location varchar (255),
birth_date timestamp,
primary key(id)
);

INSERT into person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10001, 'NAME1', 'LOCAL1', sysdate());
INSERT into person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10002, 'NAME2', 'LOCAL2', sysdate());
INSERT into person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES(10003, 'NAME3', 'LOCAL3', sysdate());


/* FOR JPA*/

INSERT into PERSONJPA (ID, NAME, LOCATION, BIRTH)
VALUES(10001, 'NAME1', 'LOCAL1', sysdate());
INSERT into PERSONJPA (ID, NAME, LOCATION, BIRTH)
VALUES(10002, 'NAME2', 'LOCAL2', sysdate());
INSERT into PERSONJPA (ID, NAME, LOCATION, BIRTH)
VALUES(10003, 'NAME3', 'LOCAL3', sysdate());
