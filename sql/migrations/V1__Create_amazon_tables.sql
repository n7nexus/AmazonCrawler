create table parser (
    id int primary key auto_increment,
    date date not null
);

create table monitoring_parameters (
    id int primary key auto_increment,
    name varchar(50),
	description varchar(100)
);

create table region (
    id int primary key auto_increment,
    value varchar(100)
);

create table collected_parameters (
    id int primary key auto_increment,
    pid int,
	value varchar(100),
	id_parser int,
	id_monitoring_parameters int,
	id_region int,
	foreign key (id_parser) references parser (id),
	foreign key (id_monitoring_parameters) references monitoring_parameters (id),
	foreign key (id_region) references region (id)
);
