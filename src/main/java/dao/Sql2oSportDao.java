package dao;

import models.Sport;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.HashMap;
import java.util.List;

public class Sql2oSportDao implements SportDao{
    private final Sql2o sql2o;

    public Sql2oSportDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Sport> getAll() {
        String sql = "SELECT * FROM sports";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Sport.class);
        }
    }

    @Override
    public void add(Sport sport) {
        String sql = "INSERT INTO sports (name, price, maxPlayers, minPlayers, duration, rules) VALUES (:name, :price, :maxPlayers, :minPlayers, :duration, :rules)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(sport)
                    .executeUpdate()
                    .getKey();
            sport.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Sport findById(int id) {
        String sql = "SELECT * FROM sports WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sport.class);
        }
    }

    @Override
    public void update(int id, HashMap<String, Object> updateContent) {
        for(String key : updateContent.keySet()){
            String sql = "UPDATE sports SET " + key + " = :" + key + " WHERE id = :id";
            try (Connection con = sql2o.open()) {
                con.createQuery(sql)
                        .addParameter(key, updateContent.get(key))
                        .addParameter("id", id)
                        .executeUpdate();
            } catch (Sql2oException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM sports WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllSports() {
        String sql = "DELETE FROM sports";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
