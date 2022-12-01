create table t_user(
    id int not null AUTO_INCREMENT,
    phone varchar2(100),
    email varchar2(100),
    password varchar2(255),
    salt varchar2(50),
    create_date datetime default null,
    update_date datetime default null
);
