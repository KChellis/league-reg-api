SET MODE PostgreSql;

CREATE TABLE IF NOT EXISTS league (
 id int PRIMARY KEY auto_increment
);

CREATE TABLE IF NOT EXISTS team (
 id int PRIMARY KEY auto_increment
);

CREATE TABLE IF NOT EXISTS player (
  id int PRIMARY KEY auto_increment
);