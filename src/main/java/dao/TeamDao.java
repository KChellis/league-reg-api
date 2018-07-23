package dao;

import models.Team;

import java.util.HashMap;
import java.util.List;

public interface TeamDao {
    List<Team> getAll();

    //CREATE
    void add (Team team);

    //READ
    Team findById(int id);
    List<Team> findByLeague(int leagueId);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllTeams();
}