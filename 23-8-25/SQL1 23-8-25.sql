create database K;
show databases;
use K;
create table employee(
emp_id int Not Null Unique PRIMARY KEY,
emp_fname varchar(30) Not Null,
emp_lname varchar(30) NOT NULL,
emp_age int NOT NULL,
Check(emp_age>=25),
emp_sal int NOT NULL
);
insert into employee values(1,"KA","RE",27,23000),(6,"AR","KE",35,35000);
select * from employee;
desc employee;
alter table employee add emp_email int;
alter table employee modify emp_email varchar(30);
desc employee;
select * from Employee ;

select * from Employee where emp_id = 1;





