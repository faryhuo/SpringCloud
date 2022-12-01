create table t_following_group(
    id int not null AUTO_INCREMENT,
    user_id int default null,
    name varchar2(255) default null,
    type int default null,
    create_date datetime default null,
    update_date datetime default null
);
