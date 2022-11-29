create database dsuenio;

use dsuenio;

create table usuario(
    idUsuario int not null auto_increment,
    usuario varchar(30) not null, 
    contrasenia varchar(30) not null,
    email varchar(50) not null,
    primary key (usuario)
);

create table sensaciondescanso (
    idSD int not null auto_increment,
    nombre varchar(13) not null,
    primary key (idSD)
);

create table entrada (
    idEntrada int not null auto_increment,
    usuario int not null,
    fechaCreacion varchar(10) not null,
    horasDormidas int not null,
    sensacionDescanso int not null,
    descripcion text(1000) not null,
    aDestacar varchar(120),
    primary key (idEntrada),
    foreign key (sensacionDescanso) references sensaciondescanso(idSD),
    foreign key (usuario) references usuario(usuario)
);