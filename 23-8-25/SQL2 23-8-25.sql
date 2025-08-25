create database flipkart ;
show databases ;
use flipkart ;
 create table category (
      cid int primary key ,
      cname varchar(50) not null
);

insert into category values (5001,'mobile accessories');
insert into category values (5002,'fashion');
insert into category values (5003,'health and fitness');

select * from category ;

create table product (
       pid int primary key,
       pname varchar(50) not null,
       cid int not null,
       foreign key (cid) references category(cid) 
);

insert into product values (701,'Adapters',5001);
insert into product values (702,'Airpods',5001);
insert into product values (703,'Covers',5001);
insert into product values (401,'Shoes',5002);
insert into product values (601,'Sweat Bands',5003);
insert into product values (602,'Sports Shoes',5003);
insert into product values (603,'Active Wears',5003);

select * from product ;

delete from category where cid=5001;

update category set cid=5003 where cid=5001;


