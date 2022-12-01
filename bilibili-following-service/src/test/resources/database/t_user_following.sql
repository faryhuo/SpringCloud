create table t_user_following(
    id int not null AUTO_INCREMENT,
    user_id int default null,
    following_id int default null,
    group_id int default null,
    create_date datetime default null,
    update_date datetime default null
);

insert into t_user_following(user_id,following_id,group_id) values(1,2,0);
insert into t_user_following(user_id,following_id,group_id) values(1,3,1);
insert into t_user_following(user_id,following_id,group_id) values(1,4,2);