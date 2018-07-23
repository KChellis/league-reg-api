package dao;

import models.Team;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sql2oTeamDao implements TeamDao{
    private final Sql2o sql2o;

    public Sql2oTeamDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Team> getAll() {
        String sql = "SELECT * FROM teams";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Team.class);
        }
    }

    @Override
    public void add(Team team) {
        String sql = "INSERT INTO teams (name, color, regCode, captainId, leagueId) VALUES (:name, :color, :regCode, :captainId, :leagueId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(team)
                    .executeUpdate()
                    .getKey();
            team.setId(id);
        } catch(Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public Team findById(int id) {
        String sql = "SELECT * FROM teams WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Team.class);
        }
    }

    @Override
    public List<Team> findByLeague(int leagueId) {
        String sql = "SELECT * FROM teams WHERE leagueId=:leagueId";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("leagueId", leagueId)
                    .executeAndFetch(Team.class);
        }
    }

    @Override
    public List<Team> findByPlayer(int playerId) {
        ArrayList<Team> teams = new ArrayList<>();

        String joinQuery = "SELECT teamId from players_teams WHERE playerId = :playerId";


        try (Connection con = sql2o.open()) {
            List<Integer> allTeamIds = con.createQuery(joinQuery)
                    .addParameter("playerId", playerId)
                    .executeAndFetch(Integer.class);
            for(Integer teamId : allTeamIds){
                String teamQuery = "SELECT * FROM teams WHERE teamId=:teamId";
                teams.add(
                        con.createQuery(teamQuery)
                                .addParameter("teamId", teamId)
                                .executeAndFetchFirst(Team.class));
            }

        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return teams;
    }

    @Override
    public void update(int id, HashMap<String, Object> updateContent) {
        for(String key : updateContent.keySet()){
            String sql = "UPDATE teams SET " + key + " = :" + key + " WHERE id = :id";
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
        String sql = "DELETE FROM teams WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllTeams() {
        String sql = "DELETE FROM teams";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
