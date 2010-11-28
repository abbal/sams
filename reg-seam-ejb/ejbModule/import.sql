-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
insert into grupadziekanska (id, nazwa) values (1, 'GID101');
insert into grupadziekanska (id, nazwa) values (2, 'GID201');
insert into grupadziekanska (id, nazwa) values (3, 'GID301');
insert into osoba (id, haslo, imie, login, nazwisko, rola) values (1, 'haslo', 'Jaś', 'login', 'Fasola', 'S');
insert into osoba (id, haslo, imie, login, nazwisko, rola) values (2, 'nowak', 'Bonawentura', 'nowak', 'Nowak', 'S');
insert into osoba (id, imie, nazwisko) values (3, 'Delfina', 'Muc');
insert into osoba (id, imie, nazwisko) values (4, 'Emeryk', 'Robak');
insert into osoba (id, imie, nazwisko) values (5, 'Filipina', 'Gazda');
insert into osoba (id, imie, nazwisko) values (6, 'Gracja', 'Roztocka');
insert into osoba (id, imie, nazwisko) values (7, 'Hildegarda', 'von Stolzenberg');
insert into osoba (id, imie, nazwisko) values (8, 'Idzi', 'Brzęczyszczykiewicz');
insert into osoba (id, imie, nazwisko) values (9, 'Wierzchosława', 'Złotopolska-Aleksandrowicz');
insert into osoba (id, imie, nazwisko) values (10, 'Kunegunda', 'Sobieska');
insert into osoba (id, imie, nazwisko) values (11, 'Leontyna', 'Dzierżyńska');
insert into osoba (id, imie, nazwisko) values (12, 'Leontyna', 'Niesiołowska');
insert into osoba (id, haslo, imie, login, nazwisko, rola) values (13, 'szejko','Stanisław','szejko', 'Szejko', 'W');
insert into osoba (id, imie, nazwisko) values (14, 'Jakub', 'Neumann');
insert into osoba (id, imie, nazwisko) values (15, 'Adam', 'Muc');
insert into osoba (id, imie, nazwisko) values (16, 'Alina', 'Swebocka');
insert into osoba (id, haslo, imie, login, nazwisko, rola) values (17, 'ewa', 'Ewa', 'ewa', 'Cytawa', 'D');
insert into student (indeks, id, grupadziekanska_id) values ('s1234', 1, 1);
insert into student (indeks, id, grupadziekanska_id) values ('s1235', 2, 2);
insert into student (indeks, id, grupadziekanska_id) values ('s1236', 3, 3);
insert into student (indeks, id, grupadziekanska_id) values ('s1232', 4, 1);
insert into student (indeks, id, grupadziekanska_id) values ('s1134', 5, 2);
insert into student (indeks, id, grupadziekanska_id) values ('s4234', 6, 3);
insert into student (indeks, id, grupadziekanska_id) values ('s5234', 7, 1);
insert into student (indeks, id, grupadziekanska_id) values ('s6234', 8, 2);
insert into student (indeks, id, grupadziekanska_id) values ('s7234', 9, 3);
insert into student (indeks, id, grupadziekanska_id) values ('s8234', 10, 1);
insert into student (indeks, id, grupadziekanska_id) values ('s9234', 11, 2);
insert into student (indeks, id, grupadziekanska_id) values ('s1874', 12, 3);
insert into wykladowca (id, tytul)values (13, 2);
insert into wykladowca (id, tytul)values (14, 2);
insert into wykladowca (id, tytul)values (15, 2);
insert into wykladowca (id, tytul)values (16, 1);
insert into dziekanat (id) values(17);
insert into grupa (id, dzien, godzinastart, godzinastop, numergrupy, open, przedmiot) values (1, 2, '11:45', '14:30', 1, FALSE, 'Angielski');
insert into grupa (id, dzien, godzinastart, godzinastop, numergrupy, open, przedmiot) values (2, 3, '10:15', '11:45', 1, FALSE, 'BYT');
insert into grupa (id, dzien, godzinastart, godzinastop, numergrupy, open, przedmiot) values (3, 4, '15:30', '17:00', 1, FALSE, 'PRO');
insert into grupa (id, dzien, godzinastart, godzinastop, numergrupy, open, przedmiot) values (4, 2, '11:45', '14:30', 2, FALSE, 'Angielski');

