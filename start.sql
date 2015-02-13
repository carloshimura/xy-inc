start transaction;

CREATE TABLE POI
(
poi_id int not null auto_increment primary key,
name varchar(255),
x_value int unsigned,
y_value int unsigned
);

insert into POI(name, x_value, y_value) values ('Lanchonete', 27, 12);
insert into POI(name, x_value, y_value) values ('Posto', 31, 18);
insert into POI(name, x_value, y_value) values ('Joalheria', 15, 12);
insert into POI(name, x_value, y_value) values ('Floricultura', 19, 21);
insert into POI(name, x_value, y_value) values ('Pub', 12, 8);
insert into POI(name, x_value, y_value) values ('Supermercado', 23, 6);
insert into POI(name, x_value, y_value) values ('Churrascaria', 28, 2);

commit;
