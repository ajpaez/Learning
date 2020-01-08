INSERT  INTO COURSE (id, name, created_date, updated_date) VALUES  (10001, 'JPA course 1', sysdate(), sysdate());
INSERT  INTO COURSE (id, name, created_date, updated_date) VALUES  (10002, 'Spring boot course', sysdate(), sysdate());
INSERT  INTO COURSE (id, name, created_date, updated_date) VALUES  (10003, 'Angular course', sysdate(), sysdate());
INSERT  INTO COURSE (id, name, created_date, updated_date) VALUES  (10004, 'Angular 8 course', sysdate(), sysdate());


insert into student(id,name)
values(20001,'Ranga');
insert into student(id,name)
values(20002,'Adam');
insert into student(id,name)
values(20003,'Jane');

insert into passport(id,number)
values(20001,'E123456');
insert into passport(id,number)
values(20002,'N123457');
insert into passport(id,number)
values(20003,'L123890');


insert into review(id,rating,description,course_id)
values(50001,'FIVE', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'FOUR', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'FIVE', 'Awesome Course',10003);

insert into student_course(course, student)
values (10001, 20001);
insert into student_course(course, student)
values (10001, 20002);
insert into student_course(course, student)
values (10002, 20003);
insert into student_course(course, student)
values (10002, 20001);

