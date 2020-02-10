CREATE DATABASE item_system;

CREATE TABLE role 
(
    id SERIAL PRIMARY KEY,
    admin CHAR(1),
    common_user CHAR(1),
    guest CHAR(1)
);

CREATE TABLE users 
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    role_id INT REFERENCES role(id)
);

CREATE TABLE rules 
(
    id SERIAL PRIMARY KEY,
    editing CHAR(1),
    record CHAR(1),
    view CHAR(1),
    delete CHAR(1)
);

CREATE TABLE role_rules 
(
    id SERIAL PRIMARY KEY,
    role_id INT REFERENCES role(id),
    rule_id INT REFERENCES rules(id)
);


CREATE TABLE state 
(
    id SERIAL PRIMARY KEY,
    active CHAR(1)
);

CREATE TABLE category 
(
    id SERIAL PRIMARY KEY,
    important CHAR(1),
    common CHAR(1),
    unimportant CHAR(1)
);

CREATE TABLE items
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(20),
    category_id INT REFERENCES category(id),
    state_id INT REFERENCES state(id),
    user_id INT REFERENCES users(id)
);

CREATE TABLE comments 
(
    id SERIAL PRIMARY KEY,
    comment VARCHAR(20),
    item_id INT REFERENCES items(id)
);

CREATE TABLE attachs 
(
    id SERIAL PRIMARY KEY,
    attach VARCHAR(20),
    item_id INT REFERENCES items(id)
);


INSERT INTO role (id, admin) VALUES (1, 'Y');
INSERT INTO role (id, common_user) VALUES (2, 'Y');
INSERT INTO role (id, guest) VALUES (3, 'Y');

INSERT INTO rules (id, editing) VALUES (1, 'Y');
INSERT INTO rules (id, record) VALUES (2, 'Y');
INSERT INTO rules (id, delete) VALUES (3, 'Y');
INSERT INTO rules (id, view) VALUES (4, 'Y');

INSERT INTO role_rules (role_id, rule_id) VALUES (1, 1);
INSERT INTO role_rules (role_id, rule_id) VALUES (1, 2);
INSERT INTO role_rules (role_id, rule_id) VALUES (1, 3);
INSERT INTO role_rules (role_id, rule_id) VALUES (1, 4);
INSERT INTO role_rules (role_id, rule_id) VALUES (2, 2);
INSERT INTO role_rules (role_id, rule_id) VALUES (2, 4);
INSERT INTO role_rules (role_id, rule_id) VALUES (3, 4);

INSERT INTO users (name, role_id) VALUES ('sergei', 3);
INSERT INTO users (name, role_id) VALUES ('vitaliy', 2);
INSERT INTO users (name, role_id) VALUES ('andrei', 1);

INSERT INTO state (id, active) VALUES (1, 'Y');
INSERT INTO state (id, active) VALUES (2, 'N');

INSERT INTO category (id, important) VALUES (1, 'Y');
INSERT INTO category (id, common) VALUES (2, 'Y');
INSERT INTO category (id, unimportant) VALUES (3, 'Y');

INSERT INTO items (id, title, category_id, state_id, user_id) VALUES (1, 'ItemOne', 2, 1, 1);
INSERT INTO items (id, title, category_id, state_id, user_id) VALUES (2, 'ItemTwo', 1, 2, 2);
INSERT INTO items (id, title, category_id, state_id, user_id) VALUES (3, 'ItemThree', 3, 1, 3);
INSERT INTO items (id, title, category_id, state_id, user_id) VALUES (4, 'ItemFour', 2, 2, 1);
INSERT INTO items (id, title, category_id, state_id, user_id) VALUES (5, 'ItemFive', 3, 2, 1);

INSERT INTO comments (id, comment, item_id) VALUES (1, 'ItemOne sergei', 1);
INSERT INTO comments (id, comment, item_id) VALUES (2, 'ItemTwo vitaliy', 2);
INSERT INTO comments (id, comment, item_id) VALUES (3, 'ItemThree andrei', 3);

INSERT INTO attachs (id, attach, item_id) VALUES (1, 'Anything attach 1', 3);
INSERT INTO attachs (id, attach, item_id) VALUES (2, 'Anything attach 2', 2);
INSERT INTO attachs (id, attach, item_id) VALUES (3, 'Anything attach 3', 1);
