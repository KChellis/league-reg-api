package dao;

import models.Player;

import java.util.HashMap;
import java.util.List;

public interface PlayerDao {
    List<Player> getAll();

    //CREATE
    void add (Player player);

    //READ
    Player findById(int id);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllPlayers();
}