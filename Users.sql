drop table if exists students;
drop table if exists classes;
drop table if exists tutor;
drop table if exists question;
drop table if exists answer;

create table students (
    id          integer primary key,
    name        varchar(255) unique not null,
    email       varchar(255),
    class1      varchar(255),
    class2      varchar(255),
    class3      varchar(255),
    class4      varchar(255),
    class5      varchar(255),
    class6      varchar(255),
    tutor    	boolean default false
);

insert into students values (123456789, 'Joe Joeson', 'fakeemail@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 1);
insert into students values (321654987, 'Jane Jodie', 'notfakeemail@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'MATH 2200', null, null, 0);
insert into students values (654987123, 'Don Lemon', 'donlemon@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 0);
insert into students values (456789123, 'Lemon Don', 'lemondon@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 0);
insert into students values (321456789, 'Jodie Jameson', 'jodiejameson@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 0);
insert into students values (123654789, 'Dan Joeson', 'realemail@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 1);
insert into students values (963852741, 'James Donson', 'jamesdonson@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 0);
insert into students values (147258369, 'Mel Hardluck', 'melhardluck@gmail.com', 'CS 1222', 'CS 3337', 'CS 3220', 'PHYS 2200', null, null, 1);

create table classes (
    name        varchar(255) unique not null,
    start       varchar(255),
    end         varchar(255),
    monday      boolean default false,
    tuesday     boolean default false,
    wednesday   boolean default false,
    thursday    boolean default false,
    friday      boolean default false,
    saturday    boolean default false
);

insert into classes (name, start, end, monday, wednesday) values ('CS 1222', '08:00 AM', '10:00 AM', true, true);
insert into classes (name, start, end, saturday) values ('CS 3337'  , '11:30 AM', '02:40 PM', true);
insert into classes (name, start, end, monday, wednesday) values ('CS 3220'  , '06:00 AM', '08:00 PM', true, true);
insert into classes (name, start, end, monday, wednesday, friday) values ('PHYS 2200', '09:00 AM', '10:00 AM', true, true, true);
insert into classes (name, start, end, tuesday, thursday) values ('MATH 2200', '07:25 PM', '08:40 PM', true, true);

create table tutor (
	id             integer primary key,
    name           varchar(255) not null,
    email          varchar(255),
    subjects 	   varchar(255),
    mondaystart    varchar(255),
    mondayend      varchar(255),
    tuesdaystart   varchar(255),
    tuesdayend     varchar(255),
    wednesdaystart varchar(255),
    wednesdayend   varchar(255),
    thursdaystart  varchar(255),
    thursdayend    varchar(255),
    fridaystart    varchar(255),
    fridayend      varchar(255),
    saturdaystart  varchar(255),
    saturdayend    varchar(255)
);

insert into tutor (id, name, email , subjects, mondaystart, mondayend, tuesdaystart, tuesdayend) 
	values (123456789, 'Joe Joeson', 'fakeemail@gmail.com', 'MATH', '09:30 AM', '02:40 PM', '12:00 PM', '04:00 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, tuesdaystart, tuesdayend)
	values (123654789, 'Dan Joeson', 'realemail@gmail.com', 'PHYS', '09:30 AM', '02:40 PM', '12:00 PM', '04:00 PM');
insert into tutor (id, name, email , subjects, wednesdaystart, wednesdayend, fridaystart, fridayend) 
	values (147258369, 'Mel Hardluck', 'melhardluck@gmail.com', 'ENGL', '06:30 PM', '08:40 PM', '12:00 PM', '04:00 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, saturdaystart, saturdayend)
	values (852147963, 'Bruce Green', 'brucegreen@gmail.com', 'MATH PHYS', '09:30 AM', '02:40 PM', '06:30 PM', '08:40 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, fridaystart, fridayend) 
	values (258369147, 'Lawrence Sontag', 'lawrencesontag@gmail.com', 'CHEM CS', '07:30 AM', '02:40 PM', '12:00 PM', '04:00 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, tuesdaystart, tuesdayend)
	values (741852369, 'Adam Montoya', 'adammontoya@gmail.com', 'HIST', '08:30 AM', '12:40 PM', '08:30 AM', '12:40 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, thursdaystart, thursdayend) 
	values (159264873, 'James Willams', 'jameswilliams@gmail.com', 'CS', '09:30 AM', '02:40 PM', '12:00 PM', '04:00 PM');
insert into tutor (id, name, email , subjects, mondaystart, mondayend, wednesdaystart, wednesdayend)
	values (951628473, 'Linsay Jones', 'lindsayjones@gmail.com', 'HIST JAPN', '09:30 AM', '02:40 PM', '12:00 PM', '04:00 PM');

create table question (
    id          integer primary key,
    name        varchar(255) not null,
    message       varchar(255) not null
);

insert into question values (1, 'Joe Joeson', 'Why is the sky blue?');
insert into question values (2, 'Dan Joeson', 'What is 1 x 1 ?');
insert into question values (3, 'Jan Jodie', 'What is 547 x 14763 ?');
insert into question values (4, 'Don Lemon', 'How to do words good');
insert into question values (5, 'Mel Hardluck', 'What is love?');

create table answer (
    id          integer,
    name        varchar(255) not null,
    message     varchar(255) not null
);

insert into answer values (1, 'Dan Joeson', 'Because science');
insert into answer values (1, 'Jan Jodie', 'Because magic');
insert into answer values (2, 'Joe Joeson', '2');
insert into answer values (2, 'Jan Jodie', '1');
insert into answer values (3, 'Joe Joeson', '8075361');
insert into answer values (3, 'Dan Joeson', '47');
insert into answer values (4, 'Joe Joeson', 'Try Harder');
insert into answer values (4, 'Mel Hardluck', 'Dont ya know ol Mel can help with that, just call at 555-614-8975');
insert into answer values (5, 'Dan Joeson', 'Baby Dont Hurt me');
insert into answer values (5, 'Don Lemon', 'Dont Hurt me');
insert into answer values (5, 'Jan Jodie', 'No More');