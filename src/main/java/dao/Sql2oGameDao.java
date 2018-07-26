package dao;

import models.Game;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sql2oGameDao implements GameDao{
    private final Sql2o sql2o;

    public Sql2oGameDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Game> getAll() {
        String sql = "SELECT * FROM games";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Game.class);
        }
    }

    @Override
    public void add(Game game) {
        String sql = "INSERT INTO games (gameDay, field, leagueId, headRefId, otherRefId) VALUES (:gameDay, :field, :leagueId, :headRefId, :otherRefId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(game)
                    .executeUpdate()
                    .getKey();
            game.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Game findById(int id) {
        String sql = "SELECT * FROM games WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Game.class);
        }
    }

    @Override
    public List<Game> findByLeague(int leagueId) {
        String sql = "SELECT * FROM games WHERE leagueId = :leagueId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("leagueId", leagueId)
                    .executeAndFetch(Game.class);
        }
    }

    @Override
    public List<Game> findByTeam(int teamId) {
        ArrayList<Game> games = new ArrayList<>();

        String joinQuery = "SELECT gameId FROM teams_games WHERE teamId = :teamId";

        try (Connection con = sql2o.open()) {
            List<Integer> allGameIds = con.createQuery(joinQuery)
                    .addParameter("teamId", teamId)
                    .executeAndFetch(Integer.class);
            for (Integer gameId : allGameIds){
                String gameQuery = "SELECT * FROM games WHERE id = :gameId";
                games.add(
                        con.createQuery(gameQuery)
                                .addParameter("gameId", gameId)
                                .executeAndFetchFirst(Game.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return games;
    }

    @Override
    public void update(int id, HashMap<String, Object> updateContent) {
        for(String key : updateContent.keySet()){
            String sql = "UPDATE games SET " + key + " = :" + key + " WHERE id = :id";
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
        String sql = "DELETE FROM games WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllGames() {
        String sql = "DELETE FROM games";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
