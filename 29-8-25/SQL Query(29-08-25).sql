create database workerlist;
use workerlist;

create table worker (
    worker_id int primary key,
    first_name varchar(50),
    last_name varchar(50),
    department varchar(50),
    salary decimal(10,2)
);
create table department_info (
    department varchar(50) primary key,
    location varchar(50),
    manager varchar(50)
);

insert into worker values
(1, 'ravi', 'kumar', 'it', 92000.00),
(2, 'meera', 'singh', 'finance', 101000.00),
(3, 'arjun', 'nair', 'hr', 87000.00),
(4, 'divya', 'sharma', 'marketing', 99000.00);

insert into department_info values
('it', 'chennai', 'suresh'),
('finance', 'mumbai', 'anita'),
('hr', 'delhi', 'rahul'),
('marketing', 'bangalore', 'deepa');

select worker.first_name, worker.last_name, worker.department, department_info.location, department_info.manager
from worker 
join department_info 
on worker.department = department_info.department;

select worker.first_name, worker.last_name, worker.department, 
       department_info.location, department_info.manager
from worker
inner join department_info
on worker.department = department_info.department;

select worker.first_name, worker.department, department_info.location
from worker
left join department_info
on worker.department = department_info.department;

select department_info.department, department_info.location, worker.first_name
from worker
right join department_info
on worker.department = department_info.department;
