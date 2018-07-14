SET MODE PostgreSql;

CREATE TABLE IF NOT EXISTS league (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description,
 weekday VARCHAR,
 sport VARCHAR,
 field VARCHAR,
 startDate DATE,
 earlyTime TIME,
 lateTime TIME,
 tournamentDay DATE,
 price INTEGER,
 maxPlayers INTEGER,
 minPlayers INTEGER,
 rules VARCHAR
);

CREATE TABLE IF NOT EXISTS team (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 color VARCHAR,
 regCode VARCHAR,
 captainId INTEGER,
 leagueId INTEGER
);

CREATE TABLE IF NOT EXISTS player (
 id int PRIMARY KEY auto_increment,
 firstName VARCHAR,
 lastName VARCHAR,
 email VARCHAR,
 street VARCHAR,
 city VARCHAR,
 state VARCHAR,
 zip INTEGER,
 ref BOOLEAN,
 shirtSize VARCHAR,
 gender VARCHAR
);

CREATE TABLE IF NOT EXISTS players_teams (
 id int PRIMARY KEY auto_increment,
 playerId INTEGER,
 teamId INTEGER
);