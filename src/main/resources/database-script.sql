CREATE TABLE Type (
    id INT PRIMARY KEY IDENTITY,
    naziv VARCHAR(20) NOT NULL UNIQUE
);

GO

CREATE TABLE Hardware
(
    id INt IDENTITY PRIMARY KEY,
    naziv        VARCHAR(50)    NOT NULL,
    sifra        VARCHAR(50)   NOT NULL,
    cijena       DECIMAL(10, 2) NOT NULL,
    tip_id       INT NOT NULL FOREIGN KEY REFERENCES Type(id),
    kolicina     INT NOT NULL
);

GO

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


SELECT * FROM Hardware;
