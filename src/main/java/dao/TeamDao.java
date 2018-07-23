package dao;

import models.Team;

import java.util.HashMap;
import java.util.List;

public interface TeamDao {
    List<Team> getAll();

    //CREATE
    void add (Team team);
    void addTeamToGame(int teamId, int gameId);

    //READ
    Team findById(int id);
    List<Team> findByLeague(int leagueId);
    List<Team> findByPlayer(int playerId);
    List<Team> findByGame(int gameId);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllTeams();
}