CREATE TABLE IF NOT EXISTS BREWERY_OLD(
    id bigint auto_increment PRIMARY KEY,
    nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS BREWERY_NEW(
    id bigint auto_increment PRIMARY KEY,
    nombre varchar(25)
);

CREATE TABLE IF NOT EXISTS BEER(
    id bigint auto_increment PRIMARY KEY,
    nombre varchar(50),
    fechaLanzamiento date,
    brewery_old bigint,
    brewery_new bigint,
    FOREIGN KEY (brewery_old) REFERENCES BREWERY_OLD(id) ON DELETE CASCADE,
    FOREIGN KEY (brewery_new) REFERENCES BREWERY_NEW(id) ON DELETE CASCADE
);
