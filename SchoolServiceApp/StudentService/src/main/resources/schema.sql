-- japp_schoolappdb

create table if not exists students (
	student_no bigint primary key,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	class_name varchar(1) not null,
	gpa real not null
);

create table if not exists teachers (
	teacher_no bigserial primary key,
	first_name varchar(100) not null,
	middle_name varchar(100),
	last_name varchar(100) not null,
	class_name varchar(1) not null,
	register_date date default(current_date) not null
);

create table if not exists teachers_to_students (
	teacher_to_student_id bigserial primary key,
	student_no bigint references students(student_no) not null,
	teacher_no bigint references teachers(teacher_no) not null,
	description text
);

truncate table students restart identity cascade;
truncate table teachers restart identity cascade;
truncate table teachers_to_students restart identity cascade;


