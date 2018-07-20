package dao;

import models.Sport;

import java.util.HashMap;
import java.util.List;

public interface SportDao {
    List<Sport> getAll();

    //CREATE
    void add (Sport sport);

    //READ
    Sport findById(int id);

    //UPDATE
    void update(int id, HashMap<String, Object> updateContent);

    //DELETE
    void deleteById(int id);
    void clearAllSports();
}