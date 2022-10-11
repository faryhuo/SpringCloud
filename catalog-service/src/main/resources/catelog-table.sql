drop table catalog;
create table catalog(
catalog_id int not null primary key,
name varchar(255),
parent_id int,
level int,
show_status char(4)
);

--data--
delete from catalog;
insert into catalog(catalog_id,name,parent_id,level,show_status)
values(1,'Product',0,1,1);
insert into catalog(catalog_id,name,parent_id,level,show_status)
values(2,'Service',0,1,1);
insert into catalog(catalog_id,name,parent_id,level,show_status)
values(3,'Order',0,1,1);
insert into catalog(catalog_id,name,parent_id,level,show_status)
values(4,'Book',1,1,1);