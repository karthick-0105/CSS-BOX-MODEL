show databases;
drop database It;
create database IT;
use IT;
create table students(
sid int primary key,
sname varchar(30),
smark int
);
insert into students values
(1,"Adib",84),
(2,"Karthick",98),
(3,"Sakthi",67);
show tables;
desc students;
select * from students;
create table aiml(sid int primary key,sname varchar(30),smark int);
insert into aiml values
(4,"Iqhlas",76),
(5,"Gopi",86);
show tables;
desc aiml;
select * from aiml;
alter table students rename to IT;
alter table IT 
add scountry varchar(30);
alter table IT Rename column scountry TO slocations;
update it set slocations ="India";
select * from IT;
update aiml set smark= smark+2;
update it set smark=75 ,slocations ="Africa"
where sid=3;
start transaction;
insert into it values(9,"Eva", 86,'India');
savepoint A;
insert into it values(6,"Kamal",34,"Sri Lanka");
savepoint B;

rollback to A;
select * from it;
rollback to B;
select * from it;
delete from it where sname='sakthi';
delete from it where sname='eva';



 


