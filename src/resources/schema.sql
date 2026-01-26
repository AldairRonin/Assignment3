CREATE TABLE media {
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration INT NOT NULL CHECK (duration > 0),
    type VARCHAR(50) NOT NULL,
};

CREATE TABLE playlists {
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
};

CREATE TABLE playlist_media (
    playlist_id INT REFERENCES playlist(id) ON DELETE CASCADE,
    media_id INT REFERENCES media(id) ON DELETE CASCADE,
    PRIMARY KEY (playlist_id, media_id)
);

INSERT INTO media (title, duration, type) VALUES
('Feel The Way I Do',183, 'song'),
('Big City Life', 354,'song'),
('OpenAI Podcast',1800,'podcast'),
('Love on me',129,'song'),
('Tuka Donka',150,'song'),
('Anatomy',143,'song'),
('Algabas',221,'song'),
('Moldanazar',188,'song');

INSERT INTO playlists (name) VALUES
('Best ones'),
('Make my day with fire');

INSERT INTO playlist_media (playlist_id, media_id) VALUES
(1, 1),
(1, 2),
(1, 3);
(2, 4),
(2, 5),
(2, 6);
