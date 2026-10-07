--INSERT INTO Hardware(naziv, sifra, cijena, tip, kolicina)
--VALUES('Intel Core i7-14700K', 'CPU-001', 429.99, 'CPU', 10);
--
--INSERT INTO Hardware(naziv, sifra, cijena, tip, kolicina)
--VALUES('NVIDIA GeForce RTX 4070', 'GPU-001', 599.99, 'GPU', 15);
--
--INSERT INTO Hardware(naziv, sifra, cijena, tip, kolicina)
--VALUES('ASUS ROG STRIX B650', 'MBO-001', 249.99, 'MBO', 2);
--
--INSERT INTO Hardware(naziv, sifra, cijena, tip, kolicina)
--VALUES('Corsair Vengeance 32GB', 'RAM-001', 89.99, 'RAM', 30);


INSERT INTO Type(naziv) VALUES ('CPU');
INSERT INTO Type(naziv) VALUES ('GPU');
INSERT INTO Type(naziv) VALUES ('MBO');
INSERT INTO Type(naziv) VALUES ('RAM');
INSERT INTO Type(naziv) VALUES ('STORAGE');
INSERT INTO Type(naziv) VALUES ('OTHER');



INSERT INTO Hardware(naziv, sifra, cijena, tip_id, kolicina)
VALUES('Intel Core i7-14700K', 'CPU-001', 429.99, 1, 10);

INSERT INTO Hardware(naziv, sifra, cijena,  tip_id, kolicina)
VALUES('NVIDIA GeForce RTX 4070', 'GPU-001', 599.99, 2, 15);

INSERT INTO Hardware(naziv, sifra, cijena,  tip_id, kolicina)
VALUES('ASUS ROG STRIX B650', 'MBO-001', 249.99, 3, 2);

INSERT INTO Hardware(naziv, sifra, cijena,  tip_id, kolicina)
VALUES('Corsair Vengeance 32GB', 'RAM-001', 89.99, 4, 30);

insert into USERS(id, username, password)
values
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

insert into AUTHORITY (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into USERS_AUTHORITY (user_id, authority_id)
values
    (1, 2),
    (2, 1);


