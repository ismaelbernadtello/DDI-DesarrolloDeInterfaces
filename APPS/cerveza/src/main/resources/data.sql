
-- BEGIN: Insert into BREWERY_NEW
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva1');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva2');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva3');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva4');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva5');
INSERT INTO BREWERY_NEW (nombre) VALUES ('nueva6');
-- END: Insert into BREWERY_NEW

-- BEGIN: Insert into BREWERY_OLD
INSERT INTO BREWERY_OLD (nombre) VALUES ('old1');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old2');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old3');
INSERT INTO BREWERY_OLD (nombre) VALUES ('old4');
-- END: Insert into BREWERY_OLD

-- BEGIN: Insert into BEER
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES ('cerveza1', '2020-12-31', 1, null);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES ('cerveza2', '2020-12-01', 2, null);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES ('cerveza3', '1999-12-31', null, 1);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES ('cerveza4', '1959-12-31', null, 3);
INSERT INTO BEER (nombre, fechaLanzamiento, brewery_new, brewery_old) VALUES ('cerveza5', '2020-12-31', 1, null);
-- END: Insert into BEER
