package dao;

import models.Player;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.HashMap;
import java.util.List;

public class Sql2oPlayerDao implements PlayerDao{
    private final Sql2o sql2o;

    public Sql2oPlayerDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Player> getAll() {
        String sql = "SELECT * FROM players";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Player.class);
        }
    }

    @Override
    public void add(Player player) {
        String sql = "INSERT INTO players (firstName, lastName, email, shirtSize, gender) VALUES (:firstName, :lastName, :email, :shirtSize, :gender)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(player)
                    .executeUpdate()
                    .getKey();
            player.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Player findById(int id) {
        String sql = "SELECT * FROM players WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Player.class);
        }
    }

    @Override
    public void update(int id, HashMap<String, Object> updateContent) {
        for(String key : updateContent.keySet()){
            String sql = "UPDATE players SET " + key + " = :" + key + " WHERE id = :id";
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
        String sql = "DELETE FROM players WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllPlayers() {
        String sql = "DELETE FROM players";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

