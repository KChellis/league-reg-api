package dao;

import models.League;

import java.util.HashMap;
import java.util.List;

public interface LeagueDao {
    List<League> getAll();

    //CREATE
    void add (League league);

    //READ
    League findById(int id);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllLeagues();
}