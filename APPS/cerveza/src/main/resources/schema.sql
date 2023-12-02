CREATE TABLE IF NOT EXISTS CERVECERIA_ANTIGUA(
    id bigint auto_increment,
    nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS CERVECERIA_NUEVA(
    id bigint auto_increment,
    nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS CERVEZA(
    id bigint auto_increment,
    nombre varchar(50),
    fechaLanzamiento date,
    cerveceria_antigua INT,
    cerveceria_nueva INT,
    FOREIGN KEY (cerveceria_antigua) REFERENCES CERVECERIA_ANTIGUA(id),
    FOREIGN KEY (cerveceria_nueva) REFERENCES CERVECERIA_NUEVA(id)
);