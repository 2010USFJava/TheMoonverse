drop table if exists users;
create table users(
user_id serial primary key,
email varchar(30) unique not null,
password varchar(20) not null,
first_name varchar (20),
last_name varchar(20),
number_posts int,
birth_date date
);
drop table if exists posts;
create table posts(
post_id serial,
user_id int not null,
count_likes int,
post_text varchar (140),
post_date date,
post_media_url varchar(100),
foreign key (user_id) references users(user_id) on delete cascade
);
drop table if exists profile;
create table profile(
profile_id serial,
user_id int unique not null,
about_me varchar(140),
age int,
city varchar(30),
profession varchar(40),
favorite_planet varchar(30),
profile_picture varchar(100),
foreign key (user_id) references users(user_id) on delete cascade
);
insert into users(birth_date, email,first_name,last_name, number_posts, password)
values (1987-10-10, 'Jason.Knighten@revature.com', 'Matt', 'Knighten', 1, 'password'),
	(1987-10-10, 'revature@revature.net', 'Revature', 'Employee', 1, 'password'),
    (1987-10-10, 'rev@yahoo.com', 'Deja', 'Vu', 1, 'password');