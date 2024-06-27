/*Activity1*/
create table salesman(salesman_id int, salesman_name varchar2(32), salesman_city varchar2(32),commission int);

describe salesman;


/*Activity2*/
insert all
    into salesman values (5001, 'James', 'New york', 15 )
into salesman values (5002, 'Nail Knite', 'Paris', 13 )
into salesman values (5005, 'Pit Alex', 'London', 11 )
into salesman values (5006, 'McLyon', 'Paris', 14 )
into salesman values (5007, 'Paul Adam', 'Rome', 13 )
select 1 from dual;

insert into salesman values(5003,'Lauson Hen','San Jose',12);

select * from salesman;

