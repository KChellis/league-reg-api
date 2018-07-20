package dao;

import models.League;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.HashMap;
import java.util.List;

public class Sql2oLeagueDao implements LeagueDao{
    private final Sql2o sql2o;

    public Sql2oLeagueDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<League> getAll() {
        String sql = "SELECT * FROM leagues";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(League.class);
        }
    }

    @Override
    public void add(League league) {
        String sql = "INSERT INTO leagues (name, description, weekday, sportId, field, startDate, earlyTime, lateTime, tourneyDay) VALUES (:name, :description, :weekday, :sportId, :field, :startDate, :earlyTime, :lateTime, :tourneyDay)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(league)
                    .executeUpdate()
                    .getKey();
            league.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public League findById(int id) {
        String sql = "SELECT * FROM leagues WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(League.class);
        }
    }

    @Override
    public void update(int id, HashMap<String, Object> updateContent) {
        for(String key : updateContent.keySet()){
            String sql = "UPDATE leagues SET " + key + " = :" + key + " WHERE id = :id";
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
        String sql = "DELETE FROM leagues WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllLeagues() {
        String sql = "DELETE FROM leagues";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
