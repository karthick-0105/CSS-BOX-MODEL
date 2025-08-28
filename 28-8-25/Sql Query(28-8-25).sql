CREATE DATABASE KC;
SHOW DATABASES;
USE KC;


CREATE TABLE Worker (
    WORKER_ID INT PRIMARY KEY,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    DEPARTMENT VARCHAR(50) NOT NULL,
    SALARY DECIMAL(10,2) NOT NULL
);

INSERT INTO Worker VALUES
(1, 'Anu', 'Pallavi', 'HR', 95000.00),
(2, 'Shreyas', 'Rahul', 'Finance', 105000.00),
(3, 'Aniket', 'Verma', 'IT', 97000.00),
(4, 'Sundar', 'Pichai', 'Marketing', 102000.00),
(5, 'Lakshmi', 'Rai', 'HR', 79000.00),
(6, 'Leo', 'Das', 'IT', 108000.00),
(7, 'Vignesh', 'Kanna', 'Admin', 88000.00),
(8, 'Gopi', 'Krishna', 'Finance', 110000.00);

select * from worker;

select * from worker 
where department='hr' 
order by salary asc;

select count(*) as employee_count from worker 
where department not in('Hr','admin');

select department,max(salary) as highest_salary from worker 
group by department;

SELECT * FROM Worker 
ORDER BY WORKER_ID 
Limit 2 ;

SELECT * FROM Worker 
ORDER BY WORKER_ID 
Limit 2 offset 4;

SELECT * FROM ( 
SELECT *, ROW_NUMBER() OVER (ORDER BY WORKER_ID) AS rn 
FROM Worker 
) AS temp 
WHERE rn > 5;  

SELECT upper(First_name) FROM worker;

UPDATE worker
SET first_name = UPPER(first_name),
    last_name = UPPER(last_name);

select department,count(department) as employee_count from worker
group by department
having count(department)>=2;

select department,sum(salary) as total from worker
group by department
having sum(salary)>200000;

select department,avg(salary) as average from worker
group by department
having avg(salary)>100000;

select department,max(salary) as max_salary from worker
group by department
having max(salary)=110000;

select department,count(department) as emp_count,sum(salary) as total_salary from worker
group by department
having count(department)>1 and sum(salary)>100000;

select department,avg(salary) as Avg_salary from worker
group by department
having avg(salary) between 50000 and 200000;

create table award_winners(
id int,
name varchar(25),
award_name varchar(30));

insert into award_winners values(001,'Karthick','Volleyball winners'),(002,'Gopi','Basketball Runners'),(003,'Adib','Oscar winners'),
(004,'Harij','English SpellBee 2nd Runner-up'),(005,'Loki','Volleyball winners'),(006,'Sakthi','Badminton Nationals runners'),
(007,'Iqhlas','Debug winners'),(008,'AK','Basketball runners'),(009,'Kamal','Hackathon runners'),
(010,'Barath','Hackathon winners');

select * from award_winners;

create table students(
id int,
name varchar(25));

insert into students values(005,'Loki'),(1001,'Srihari'),(1003,'Dinesh'),(001,'Karthick'),(1005,'Tharun'),
(1006,'Vamsi'),(1007,'Monish'),(1008,'Rohith'),(1009,'Alwyn'),(1010,'Akash');

select * from students;

select * from students 
where id=(select id from award_winners where id=5);

select * from students 
where id=(select id from award_winners where name="karthick");

select * from award_winners
where id=(select id from students where id=1);

select * from award_winners
where id=(select id from students where name="Loki");
