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

insert into book(`id`, `name`, `publisher_id`,`deleted`, `status`) values (1,'JPA 초격차 패키지',1,false,100);

insert into book(`id`, `name`,`publisher_id` ,`deleted`, `status`) values (2,'Spring Security 초격차 패키지',1, false,200);

insert into book(`id`, `name`,`publisher_id` ,`deleted`, `status`) values (3,'Spring Security 초격차 패키지2',1, true,100);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`)
values (1,'내인생을바꾼책','너무너무 좋았어요',5.0, 1 ,1);

insert into review(`id`,`title`,`content`,`score`,`user_id`,`book_id`)
values (2,'너무 빠른 너','조금별로',3.0, 2, 2);

insert into comment(`id`,`comment`,`review_id`) values (1,'당연히 좋죠',1);

insert into comment(`id`,`comment`,`review_id`) values (2,'당연히 좋죠222',2);

insert into comment(`id`,`comment`,`review_id`) values (3,'별루 아닌갘ㅋ',2);


