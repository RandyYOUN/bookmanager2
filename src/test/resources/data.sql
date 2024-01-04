-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`create_at`,`update_at`)
values(1,'yhd0626','yhd0626@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`create_at`,`update_at`)
values(2,'y2509g','y2509g@nate.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`create_at`,`update_at`)
values(3,'maisondejhd','maisondejhd@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`create_at`,`update_at`)
values(4,'james','james@gmail.com',now(),now());

-- call next value for hibernate_sequence;
insert into user(`id`,`name`,`email`,`create_at`,`update_at`)
values(5,'y2509g','y2509g@gmail.com',now(),now());

insert into publisher(id,name) values (1,"패스트캠퍼스");

insert into book(`id`, `name`, `publisher_id`,`deleted`) values (1,'JPA 초격차 패키지',1,false);

insert into book(`id`, `name`,`publisher_id` ,`deleted`) values (2,'Spring Security 초격차 패키지',1, false);

insert into book(`id`, `name`,`publisher_id` ,`deleted`) values (3,'Spring Security 초격차 패키지2',1, true);