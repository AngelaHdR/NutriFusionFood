create DATABASE recetas;
use recetas;
create table if not exists usuario(
    id_usuario INT not null,
    nombre VARCHAR(30) not null,
    apellido1 VARCHAR(30) not null,
    apellido2 VARCHAR(30) not null,
    fecha_nacimiento date default null,
    nutricionista BOOLEAN not null,
    primary key (id_usuario)
);

create table if not exists receta (
    id_receta int not null,
    descripcion varchar(100) not null,
    nombre VARCHAR(30) not null,
    tiempo int not null,
    id_usuario int not null,
    PRIMARY key (id_receta)
    Foreign Key (id_usuario) REFERENCES usuario (id_usuario)
);

create Table if not exists ingrediente (
    id_ingrediente int not null,
    gluten BOOLEAN not null,
    lactosa BOOLEAN not null,
    nombre VARCHAR(30) not null,
    temporada date not null,
    id_etiqueta int not null,
    PRIMARY KEY (id_ingrediente)
    Foreign Key (id_tipo) REFERENCES tipo (id_tipo)
);

create table if not exists tipo (
    id_tipo int not null,
    nombre VARCHAR(30) not null,
    PRIMARY KEY (id_tipo)
);
create table if not exists utensilio (
    id_utensilio int not null,
    nombre VARCHAR(30) not null,
    PRIMARY KEY (id_utensilio)
);

CREATE TABLE if not exists compuesto (
    PRIMARY KEY (id_receta, id_ingrediente),
    Foreign Key (id_receta) REFERENCES receta (id_receta),
    Foreign Key (id_ingrediente) REFERENCES ingrediente (id_ingrediente)
);

CREATE TABLE if not exists requiere(
    PRIMARY KEY (id_receta, id_utensilio),
    Foreign Key (id_receta) REFERENCES receta (id_receta),
    Foreign Key (id_utensilio) REFERENCES utensilio (id_utensilio)
);
