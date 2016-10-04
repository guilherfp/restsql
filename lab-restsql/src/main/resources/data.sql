insert into path_sql (path, method, script, list) 
	values ('/usuarios', 'GET', 'select * from usuario', true);

insert into path_sql (path, params, method, script, list) 
	values ('/usuarios','id', 'GET', 'select * from usuario where id = :id', false);
	
insert into path_sql (path, params, method, script) 
	values ('/usuarios','nome', 'POST', 'select * from usuario where nome like :nome');

insert into path_sql (path, params, method, script) 
	values ('/usuarios','id,nome', 'GET', 'select * from usuario where id = :id and nome = :nome');

insert into usuario (id, nome, login) values (1, 'usuario1', 'user1');
insert into usuario (id, nome, login) values (2, 'usuario2', 'user2');
insert into usuario (id, nome, login) values (3, 'usuario3', 'user3');
insert into usuario (id, nome, login) values (4, 'usuario4', 'user4');