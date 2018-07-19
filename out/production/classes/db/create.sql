SET MODE PostgreSql;

CREATE TABLE IF NOT EXISTS leagues (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description,
 weekday VARCHAR,
 sportId INTEGER,
 field VARCHAR,
 startDate DATE,
 earlyTime VARCHAR,
 lateTime VARCHAR,
 tournamentDay DATE
);

CREATE TABLE IF NOT EXISTS sports (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 price INTEGER,
 duration INTEGER,
 maxPlayers INTEGER,
 minPlayers INTEGER,
 rules VARCHAR
);

CREATE TABLE IF NOT EXISTS teams (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 color VARCHAR,
 regCode VARCHAR,
 captainId INTEGER,
 leagueId INTEGER
);

CREATE TABLE IF NOT EXISTS players (
 id int PRIMARY KEY auto_increment,
 firstName VARCHAR,
 lastName VARCHAR,
 email VARCHAR,
 shirtSize VARCHAR,
 gender VARCHAR
);

CREATE TABLE IF NOT EXISTS games (
 id int PRIMARY KEY auto_increment
 date DATE,
 time TIME,
 field VARCHAR,
 leagueId INTEGER,
 headRefId INTEGER,
 otherRefId INTEGER,
 winnerScore INTEGER,
 loserScore INTEGER,
 winnerId INTEGER
);

CREATE TABLE IF NOT EXISTS players_teams (
 id int PRIMARY KEY auto_increment,
 playerId INTEGER,
 teamId INTEGER
);

CREATE TABLE IF NOT EXISTS teams_games (
 id int PRIMARY KEY auto_increment,
 gameId INTEGER,
 teamId INTEGER
)

CREATE TABLE IF NOT EXISTS referees (
 id int PRIMARY KEY auto_increment,
 playerId INTEGER,
 leagueId INTEGER
)

