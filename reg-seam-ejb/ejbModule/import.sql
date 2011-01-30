-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
insert into grupadziekanska (id, nazwa) values (1, 'GID101');
insert into grupadziekanska (id, nazwa) values (2, 'GID201');
insert into grupadziekanska (id, nazwa) values (3, 'GID301');
<<<<<<< HEAD
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (1, TRUE, 'haslo', 'Jaś', 'login', 'Fasola', 'S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (2, TRUE, 'nowak', 'Bonawentura', 'nowak', 'Nowak', 'S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (3,FALSE, 'muc', 'Delfina','muc', 'Muc','S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (4,TRUE, 'robak', 'Emeryk','robak', 'Robak','S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (5,TRUE, 'gazda', 'Filipina', 'gazda', 'Gazda', 'S');
=======
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (1, TRUE, 'pass1234', 'Jaś', 'login', 'Fasola', 'S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (2, TRUE, 'pass1234', 'Bonawentura', 'nowak', 'Nowak', 'S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (3,TRUE, 'pass1234', 'Delfina','muc', 'Muc','S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (4,TRUE, 'pass1234', 'Emeryk','robak', 'Robak','S');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (5,TRUE, 'pass1234', 'Filipina', 'gazda', 'Gazda', 'S');
>>>>>>> Corrected editing and removing Objects.
insert into osoba (id, flaga, imie, nazwisko) values (6, TRUE, 'Gracja', 'Roztocka');
insert into osoba (id, flaga, imie, nazwisko) values (7, TRUE, 'Hildegarda', 'von Stolzenberg');
insert into osoba (id, flaga, imie, nazwisko) values (8, TRUE, 'Idzi', 'Brzęczyszczykiewicz');
insert into osoba (id, flaga, imie, nazwisko) values (9, TRUE, 'Wierzchosława', 'Złotopolska-Aleksandrowicz');
insert into osoba (id, flaga, imie, nazwisko) values (10, TRUE, 'Kunegunda', 'Sobieska');
insert into osoba (id, flaga, imie, nazwisko) values (11, TRUE, 'Leontyna', 'Dzierżyńska');
insert into osoba (id, flaga, imie, nazwisko) values (12, TRUE, 'Leontyna', 'Niesiołowska');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (13, TRUE, 'pass1234','Stanisław','szejko', 'Szejko', 'W');
insert into osoba (id, flaga, imie, nazwisko) values (14, TRUE, 'Jakub', 'Neumann');
insert into osoba (id, flaga, imie, nazwisko) values (15, TRUE, 'Adam', 'Muc');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (18, TRUE, 'pass1234','Pan','wykladowca', 'Wykladowca', 'W');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (16, TRUE, 'pass1234', 'Alina','alina', 'Swebocka', 'W');
insert into osoba (id, flaga, haslo, imie, login, nazwisko, rola) values (17, TRUE, 'pass1234', 'Ewa', 'ewa', 'Cytawa', 'D');
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
insert into wykladowca (id, tytul)values (18, 2);
insert into dziekanat (id) values(17);
insert into grupa (id, dzien, flaga, godzinastart, godzinastop, numergrupy, open, przedmiot, wykladowca_id) values (1, 2, TRUE, '11:45', '14:30', 1, FALSE, 'Angielski', 16);
insert into grupa (id, dzien, flaga, godzinastart, godzinastop, numergrupy, open, przedmiot, wykladowca_id) values (2, 3, TRUE, '10:15', '11:45', 1, FALSE, 'BYT', 13);
insert into grupa (id, dzien, flaga, godzinastart, godzinastop, numergrupy, open, przedmiot, wykladowca_id) values (3, 4, TRUE, '15:30', '17:00', 1, FALSE, 'PRO', 13);
insert into grupa (id, dzien, flaga, godzinastart, godzinastop, numergrupy, open, przedmiot, wykladowca_id) values (4, 2, TRUE, '11:45', '14:30', 2, FALSE, 'Angielski', 16);
insert into grupa_student (studencigrupy_id, studenci_id) values (2, 1);
insert into grupa_student (studencigrupy_id, studenci_id) values (2, 2);
insert into grupa_student (studencigrupy_id, studenci_id) values (1, 1);

