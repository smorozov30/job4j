CREATE DATABASE storage;

CREATE TABLE engine
(
    id SERIAL PRIMARY KEY,
    power INT
);

CREATE TABLE transmission
(
    id SERIAL PRIMARY KEY,
    switching INT
);

CREATE TABLE body
(
    id SERIAL PRIMARY KEY,
    shape VARCHAR(20)
);

CREATE TABLE car
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    engine_id INT REFERENCES engine(id),
    transmission_id INT REFERENCES transmission(id),
    body_id INT REFERENCES body(id)
);

INSERT INTO engine VALUES (1, 110);
INSERT INTO engine VALUES (2, 180);
INSERT INTO engine VALUES (3, 249);

INSERT INTO transmission VALUES(1, 4);
INSERT INTO transmission VALUES(2, 5);
INSERT INTO transmission VALUES(3, 6);

INSERT INTO body VALUES(1, 'sedan');
INSERT INTO body VALUES(2, 'pickup');
INSERT INTO body VALUES(3, 'coupe');

INSERT INTO car VALUES (1, 'vw', 1, 1, 1);
INSERT INTO car VALUES (2, 'audi', 2, 2, 2);
INSERT INTO car VALUES (3, 'mers', 3, 3, 3);
INSERT INTO car (id, name, engine_id, body_id) VALUES (4, 'vaz', 1, 1);
INSERT INTO car (id, name, engine_id, transmission_id) VALUES (5, 'bmw', 2, 2);
INSERT INTO car (id, name, transmission_id, body_id) VALUES (6, 'opel', 3, 3);

SELECT * FROM engine;
SELECT * FROM transmission;
SELECT * FROM body;
SELECT * FROM car;

-- Выборка всех машин с имеющимися в них деталями(двигатель, коробка, кузов).
SELECT c.name, e.power, t.switching, b.shape
FROM car AS c
LEFT OUTER JOIN engine AS e ON c.engine_id = e.id
LEFT OUTER JOIN transmission AS t ON c.transmission_id = t.id
LEFT OUTER JOIN body AS b ON c.body_id = b.id;

-- Выборка машин и неиспользуемых(или отсутствующих) в ней двигателей.
SELECT c.name, e.power FROM engine AS e
LEFT OUTER JOIN car AS c ON c.engine_id IS NULL OR c.engine_id <> e.id
ORDER BY c.name;

-- Выборка машин и неиспользуемых(или отсутствующих) в ней коробок переключения передач.
SELECT c.name, t.switching FROM transmission AS t
LEFT OUTER JOIN car AS c ON c.transmission_id IS NULL OR c.transmission_id <> t.id
ORDER BY c.name;

-- Выборка машин и неиспользуемых(или отсутствующих) в ней кузовов.
SELECT c.name, b.shape FROM body AS b
LEFT OUTER JOIN car AS c ON c.body_id IS NULL OR c.body_id <> b.id
ORDER BY c.name;

-- Выборка вариантов сборки машин, отсутствующих в существующей таблице car(все комбинации).
SELECT c.name, b.shape, e.power, t.switching FROM car AS c
RIGHT OUTER JOIN body AS b ON c.body_id IS NULL OR c.body_id <> b.id
RIGHT OUTER JOIN engine AS e ON c.engine_id IS NULL OR c.engine_id <> e.id
RIGHT OUTER JOIN transmission AS t ON c.transmission_id IS NULL OR c.transmission_id <> t.id
ORDER BY c.name;