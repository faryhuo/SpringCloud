create table t_user(
    id int not null AUTO_INCREMENT,
    phone varchar(100),
    email varchar(100),
    password varchar(255),
    salt varchar(50),
    create_date datetime default null,
    update_date datetime default null,
    primary key (id)
);
