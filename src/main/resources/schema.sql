create database if not exists webtech;

create table if not exists tasks (
	id int,
	task_name varchar(200),
    description varchar(2000),
    created_by varchar(255),
    assigned_to varchar(100),
    status varchar(50),
    attachment longblob,
    created_date datetime,
    last_updated_date datetime,
    remark varchar(200)
);

create table comments (
	id int,
    comment varchar(1000),
    attachment longblob,
    created_by varchar(100),
    created_date datetime,
    last_updated_date datetime,
    task_id int,
    updated boolean,
    primary key (id),
    foreign key (task_id) references tasks (id)
);