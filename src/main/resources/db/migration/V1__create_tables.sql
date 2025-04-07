CREATE TABLE coaches
(
    id      BIGSERIAL PRIMARY KEY ,
    name    VARCHAR(255) NOT NULL,
    team_id BIGINT UNIQUE
);

CREATE TABLE leagues
(
    id   BIGSERIAL PRIMARY KEY ,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE match_team
(
    match_id BIGINT NOT NULL,
    team_id  BIGINT NOT NULL
);

CREATE TABLE matches
(
    id           BIGSERIAL PRIMARY KEY ,
    home_team_id BIGINT NOT NULL,
    away_team_id BIGINT NOT NULL,
    league_id    BIGINT NOT NULL
);

CREATE TABLE players
(
    id      BIGSERIAL PRIMARY KEY ,
    name    VARCHAR(255) NOT NULL,
    team_id BIGINT,
    kills   INTEGER NOT NULL DEFAULT 0,
    deaths  INTEGER NOT NULL DEFAULT 0,
    assists INTEGER NOT NULL DEFAULT 0,
    wins    INTEGER NOT NULL DEFAULT 0,
    losses  INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE teams
(
    id        BIGSERIAL PRIMARY KEY ,
    name      VARCHAR(255) NOT NULL,
    league_id BIGINT
);

ALTER TABLE coaches
    ADD CONSTRAINT FK_COACHES_ON_TEAM FOREIGN KEY (team_id) REFERENCES teams (id);

ALTER TABLE matches
    ADD CONSTRAINT FK_MATCHES_ON_AWAY_TEAM FOREIGN KEY (away_team_id) REFERENCES teams (id);

ALTER TABLE matches
    ADD CONSTRAINT FK_MATCHES_ON_HOME_TEAM FOREIGN KEY (home_team_id) REFERENCES teams (id);

ALTER TABLE matches
    ADD CONSTRAINT FK_MATCHES_ON_LEAGUE FOREIGN KEY (league_id) REFERENCES leagues (id);

ALTER TABLE players
    ADD CONSTRAINT FK_PLAYERS_ON_TEAM FOREIGN KEY (team_id) REFERENCES teams (id) ON DELETE SET NULL;

ALTER TABLE teams
    ADD CONSTRAINT FK_TEAMS_ON_LEAGUE FOREIGN KEY (league_id) REFERENCES leagues (id) ON DELETE SET NULL;

ALTER TABLE match_team
    ADD CONSTRAINT fk_mattea_on_match FOREIGN KEY (match_id) REFERENCES matches (id);

ALTER TABLE match_team
    ADD CONSTRAINT fk_mattea_on_team FOREIGN KEY (team_id) REFERENCES teams (id);