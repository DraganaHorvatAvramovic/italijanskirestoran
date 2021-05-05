insert into hrana (id, naziv, cena) values (1, 'bez hrane', 0.00);
insert into hrana (id, naziv, cena) values (2, 'Pizza Capriccosa', 300.00);
insert into hrana (id, naziv, cena) values (3, 'Pizza Hawaii', 350.00);
insert into hrana (id, naziv, cena) values (4, 'Pizza Siciliana', 400.00);
insert into hrana (id, naziv, cena) values (5, 'Pizza Margarita', 350.00);
insert into hrana (id, naziv, cena) values (6, 'Pasta Italiana', 450.00);
insert into hrana (id, naziv, cena) values (7, 'Pasta Carbonara', 500.00);
insert into hrana (id, naziv, cena) values (8, 'Pasta Con Tonno', 500.00);
insert into hrana (id, naziv, cena) values (9, 'Pasta Parma', 400.00);
insert into hrana (id, naziv, cena) values (10, 'Pasta Bolognese', 450.00);

insert into prilog (id, naziv, cena) values (1, 'bez priloga', 0.00);
insert into prilog (id, naziv, cena) values (2, 'kecap', 40.00);
insert into prilog (id, naziv, cena) values (3, 'origano', 30.00);
insert into prilog (id, naziv, cena) values (4, 'extra cheese', 100.00);
insert into prilog (id, naziv, cena) values (5, 'pavlaka', 50.00);
insert into prilog (id, naziv, cena) values (6, 'kukuruz', 60.00);

insert into pice (id, naziv, cena, zapremina) values (1, 'bez pica', 0.00, 0.00);
insert into pice (id, naziv, cena, zapremina) values (2, 'Gazirano - Coca-cola', 200.00, 0.33);
insert into pice (id, naziv, cena, zapremina) values (3, 'Negazirano - Jabuka', 200.00, 0.33);
insert into pice (id, naziv, cena, zapremina) values (4, 'Voda - Knjaz Milos', 150.00, 0.33);

insert into sto (id, naziv) values (1, 'sto 1');
insert into sto (id, naziv) values (2, 'sto 2');
insert into sto (id, naziv) values (3, 'sto 3');
insert into sto (id, naziv) values (4, 'sto 4');
insert into sto (id, naziv) values (5, 'sto 5');

insert into porudzbina (id, sto_id, placeno, ukupnacena) values (1, 1, 'nije placeno', 0);
insert into porudzbina (id, sto_id, placeno, ukupnacena) values (2, 2, 'nije placeno', 0);
insert into porudzbina (id, sto_id, placeno, ukupnacena) values (3, 3, 'placeno', 0);
insert into porudzbina (id, sto_id, placeno,ukupnacena) values (4, 4, 'nije placeno',0);

insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (1, 1, 2, 2, 2);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (2, 2, 2, 3, 2);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (3, 1, 3, 2, 3);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (4, 2, 2, 2, 2);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (5, 2, 2, 2, 3);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (6, 2, 2, 2, 4);
insert into stavka (id, porudzbina_id, hrana_id, prilog_id, pice_id) values (7, 3, 2, 2, 2);