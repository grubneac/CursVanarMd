create table if not exists Students(
	ID Serial primary key,
	fullname varchar(30),
	dob date,
	mark numeric
); 
insert into students(fullname,dob,mark) values('Александр Сергеевич Пушкин','2015-01-01', 5.5 );

update students set dob = '1799-06-06' where id =1;