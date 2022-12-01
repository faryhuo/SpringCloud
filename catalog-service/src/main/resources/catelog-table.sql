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
insert into catalog(catalog_id,name,parent_id,level,show_status,sort,create_date,icon)
values(1,'Product',0,1,1,3,now(),"");
insert into catalog(catalog_id,name,parent_id,level,show_status,sort,create_date,icon)
values(2,'Service',0,1,1,2,now(),"");
insert into catalog(catalog_id,name,parent_id,level,show_status,sort,create_date,icon)
values(3,'Order',0,1,1,1,now(),"");
insert into catalog(catalog_id,name,parent_id,level,show_status,sort,create_date,icon)
values(4,'Book',1,1,1,2,now(),"");
insert into catalog(catalog_id,name,parent_id,level,show_status,sort,create_date,icon)
values(5,'Phone',1,1,1,1,now(),"");