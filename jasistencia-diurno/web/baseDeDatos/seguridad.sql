/*http://www.solingest.com/blog/almacenar-contrasenas-en-mysql*/

create database pruebaPass;

use pruebaPass;
/*MD5*/

/*create table usuario(
	id int auto_increment,
	nombre varchar(30),
	pass varchar(32),
	primary key(id)
);

insert into usuario values(null, 'diego', MD5('123456'));

select * from usuario;

select * from usuario where pass = MD5('123456');*/


/*SHA*/
/*drop table usuario;
create table usuario(
	id int auto_increment,
	nombre varchar(30),
	pass varchar(40),
	primary key(id)
);

insert into usuario values(null, 'diego', SHA1('123456'));

select * from usuario;

select * from usuario where pass = SHA1('123456');*/

/*AES*/
drop table usuario;
create table usuario(
	id int auto_increment,
	nombre varchar(30),
	pass blob,
	primary key(id)
);

insert into usuario values(null, 'nacho', 
AES_ENCRYPT('123456', 'eldiego'));

select * from usuario;

select * from usuario where pass 
= AES_ENCRYPT('123456','eldiego');


