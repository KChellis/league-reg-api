package dao;

import models.Game;

import java.util.HashMap;
import java.util.List;

public interface GameDao {
    List<Game> getAll();

    //CREATE
    void add (Game game);

    //READ
    Game findById(int id);
    List<Game> findByLeague(int leagueId);
    List<Game> findByTeam(int teamId);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllGames();
}
