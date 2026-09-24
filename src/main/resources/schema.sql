CREATE TABLE Hardware
(
    id IDENTITY PRIMARY KEY,
    naziv        VARCHAR(50)    NOT NULL,
    sifra        VARCHAR(50)   NOT NULL,
    cijena       DECIMAL(10, 2) NOT NULL,
    tip          VARCHAR(50),
    kolicina     INT NOT NULL
);