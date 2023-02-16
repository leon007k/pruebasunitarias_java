drop TABLE IF EXISTS movies;
CREATE TABLE IF NOT EXISTS movies(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    minutes INT NOT NULL,
    genre VARCHAR(50) NOT NULL
);

INSERT INTO movies (name, minutes, genre) VALUES
    ('Dark Knight', 152, 'ACTION'),
    ('Memento', 113, 'DRAMA'),
    ('There is Something About Marty',119,'COMEDY'),
    ('Super 8',112,'THRILLER'),
    ('Scream',111,'HORROR'),
    ('Home Alone',103,'COMEDY'),
    ('Matrix', 136, 'ACTION'),
    ('Superman', 126, 'ACTION'),
    ('Spiderman: de regreso a casa', 126, 'ACTION'),
    ('Supercan', 136, 'ACTION'),
    ('Rapidos y furiosos 10', 126, 'ACTION'),
    ('John Wick 2', 146, 'ACTION'),
    ('John Wick 3', 146, 'ACTION'),
    ('John Wick 4', 146, 'ACTION');