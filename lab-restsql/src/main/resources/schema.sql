create table path_sql (
	path varchar(255) not null,
	method varchar(20) not null,
	script longvarchar not null,
	params varchar(255),
	list boolean default true
);

create table usuario (
	id int not null,
	nome varchar(100) not null,
	login varchar(50) not null
);