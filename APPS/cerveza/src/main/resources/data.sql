-- Cerveceria Antigua
INSERT INTO CERVECERIA_ANTIGUA (nombre) VALUES ('Old Brew Co. A');
INSERT INTO CERVECERIA_ANTIGUA (nombre) VALUES ('Traditional Beers Ltd.');
INSERT INTO CERVECERIA_ANTIGUA (nombre) VALUES ('Vintage Breweries');
INSERT INTO CERVECERIA_ANTIGUA (nombre) VALUES ('Heritage Ales');
INSERT INTO CERVECERIA_ANTIGUA (nombre) VALUES ('Classic Brews Inc.');

--Cerveceria Nueva
INSERT INTO CERVECERIA_NUEVA (nombre) VALUES ('New Wave Beers');
INSERT INTO CERVECERIA_NUEVA (nombre) VALUES ('Innovative Brews Co.');
INSERT INTO CERVECERIA_NUEVA (nombre) VALUES ('Craft Creations Ltd.');
INSERT INTO CERVECERIA_NUEVA (nombre) VALUES ('Modern Brewmasters');
INSERT INTO CERVECERIA_NUEVA (nombre) VALUES ('Artisanal Drinks Inc.');

--Cerveza
INSERT INTO CERVEZA (nombre, fechaLanzamiento, cerveceria_antigua, cerveceria_nueva) VALUES ('Amber Ale', '2022-01-15', 1, NULL);
INSERT INTO CERVEZA (nombre, fechaLanzamiento, cerveceria_antigua, cerveceria_nueva) VALUES ('Golden Lager', '2022-02-28', NULL, 2);
INSERT INTO CERVEZA (nombre, fechaLanzamiento, cerveceria_antigua, cerveceria_nueva) VALUES ('Red IPA', '2022-03-10', 3, NULL);
INSERT INTO CERVEZA (nombre, fechaLanzamiento, cerveceria_antigua, cerveceria_nueva) VALUES ('Porter Reserve', '2022-04-05', NULL, 4);
INSERT INTO CERVEZA (nombre, fechaLanzamiento, cerveceria_antigua, cerveceria_nueva) VALUES ('Belgian Tripel', '2022-05-20', 5, NULL);
