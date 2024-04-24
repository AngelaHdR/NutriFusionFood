
drop database if exists nutrifusionfood;
create DATABASE if not exists nutrifusionfood;
use nutrifusionfood;
 create table if not exists category(
 id_category int not null,
 name_es VARCHAR(30) not null,
 name_en VARCHAR(30) not null,
 primary key(id_category)
 );
 
create table if not exists user(
    id_user INT not null,
    name_user VARCHAR(30) not null,
    surname1 VARCHAR(30) not null,
    surname2 VARCHAR(30) not null,
    username VARCHAR(30) not null,
    email VARCHAR(30) not null,
    birth_date date default null,
    nutritionist BOOLEAN not null,
    pwd VARCHAR(20) not null,
    primary key (id_user)
);

create table if not exists recipe (
    id_recipe int not null,
    description_recipe varchar(100) not null,
    name_recipe VARCHAR(30) not null,
    steps VARCHAR(500) not null,
    lang VARCHAR(5) not null,
    time_recipe int not null,
    id_user int not null,
    id_category int not null,
    PRIMARY key (id_recipe),
    Foreign Key (id_user) REFERENCES user (id_user) on delete cascade on update cascade,
    Foreign Key (id_category) REFERENCES category (id_category) on delete cascade on update cascade
);

create table if not exists type (
    id_type int not null,
    name_es VARCHAR(30) not null,
    name_en VARCHAR(30) not null,
    PRIMARY KEY (id_type)
);
create Table if not exists ingredient (
    id_ingredient int not null,
    gluten BOOLEAN not null,
    lactose BOOLEAN not null,
    name_es VARCHAR(30) not null,
    name_en VARCHAR(30) not null,
    start_season int not null,
    end_season int not null,
    id_type int not null,
    PRIMARY KEY (id_ingredient),
    Foreign Key (id_type) REFERENCES type (id_type) on delete cascade on update cascade
);

create table if not exists tool (
    id_tool int not null,
    name_es VARCHAR(30) not null,
    name_en VARCHAR(30) not null,
    PRIMARY KEY (id_tool)
);

CREATE TABLE if not exists composed (
	id_recipe int not null,
	id_ingredient int not null,
    PRIMARY KEY (id_recipe, id_ingredient),
    Foreign Key (id_recipe) REFERENCES recipe (id_recipe) on delete cascade on update cascade,
    Foreign Key (id_ingredient) REFERENCES ingredient (id_ingredient) on delete cascade on update cascade
);

CREATE TABLE if not exists required(
	id_recipe int not null,
	id_tool int not null,
    PRIMARY KEY (id_recipe, id_tool),
    Foreign Key (id_recipe) REFERENCES recipe (id_recipe) on delete cascade on update cascade,
    Foreign Key (id_tool) REFERENCES tool (id_tool) on delete cascade on update cascade
);
