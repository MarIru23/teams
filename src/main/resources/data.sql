INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Barcelona', 'España', '#ff0000');

INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Real Madrid', 'España', '#ffffff');

INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Manchester City', 'Inglaterra', '#6FA8DC');

INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Bayern Munich', 'Alemania', '#DC143C');


INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Lionel Messi', '10', 1); -- Barcelona

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Gerard Piqué', '3', 1); -- Barcelona

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Ansu Fati', '22', 1); -- Barcelona

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Sergio Busquets', '5', 1); -- Barcelona

-- Players for Real Madrid
INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Karim Benzema', '9', 2); -- Real Madrid

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Toni Kroos', '8', 2); -- Real Madrid

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Luka Modric', '10', 2); -- Real Madrid

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Sergio Ramos', '4', 2); -- Real Madrid

-- Players for Manchester City
INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Kevin De Bruyne', '17', 3); -- Manchester City

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Raheem Sterling', '7', 3); -- Manchester City

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Phil Foden', '47', 3); -- Manchester City

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Ruben Dias', '3', 3); -- Manchester City

-- Players for Bayern Munich
INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Robert Lewandowski', '9', 4); -- Bayern Munich

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Thomas Müller', '25', 4); -- Bayern Munich

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Joshua Kimmich', '6', 4); -- Bayern Munich

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Manuel Neuer', '1', 4); -- Bayern Munich




INSERT INTO user_ (email, password)
VALUES ('user', '$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO'); //password - codificado con bcrypt