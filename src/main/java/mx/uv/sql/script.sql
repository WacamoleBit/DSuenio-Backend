create database dsuenio;

use dsuenio;

create table usuario(
    usuario varchar(30) not null, 
    contrasenia varchar(30) not null,
    email varchar(50) not null,
    primary key (usuario)
);

create table sensaciondescanso {
    idSD int not null AUTO_INCREMENT,
    nombre varchar not null,
    primary key (idSD)
};

create table entrada {
    idEntrada int not null AUTO_INCREMENT
    fechaCreacion varchar(10) not null,
    horasDormidas int not null,
    sensacionDescanso int not null,
    descripcion text(1000) not null,
    aDestacar varchar(120)
    primary key (idEntrada),
    foreign key (sensacionDescanso) references sensaciondescanso(idSD)
}