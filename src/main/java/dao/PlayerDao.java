package dao;

import models.Player;

import java.util.HashMap;
import java.util.List;

public interface PlayerDao {
    List<Player> getAll();

    //CREATE
    void add (Player player);
    void addPlayerToTeam(int playerId, int teamId);

    //READ
    Player findById(int id);
    List<Player> findByTeam(int teamId);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllPlayers();
}