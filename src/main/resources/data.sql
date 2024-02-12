INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Getafe', 'España', '#ff00ff');

INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Liverpool', 'Inglaterra', '#ff00gh');

INSERT INTO Team (uuid, name, country, color)
VALUES(uuid(), 'Juventus', 'Italia', '#ff00gf');

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Borja Mayoral', '10', 1);

INSERT INTO Player (uuid, name, number, Team_id)
VALUES(uuid(), 'Greenwood', '12', 1);


INSERT INTO user_ (email, password)
VALUES ('user', '$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO'); //password - codificado con bcrypt