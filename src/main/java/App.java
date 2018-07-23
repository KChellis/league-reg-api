import com.google.gson.Gson;
import dao.Sql2oLeagueDao;
import dao.Sql2oPlayerDao;
import dao.Sql2oSportDao;
import dao.Sql2oTeamDao;
import models.League;
import models.Player;
import models.Sport;
import models.Team;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oLeagueDao leagueDao;
        Sql2oPlayerDao playerDao;
        Sql2oSportDao sportDao;
        Sql2oTeamDao teamDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/league.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        leagueDao = new Sql2oLeagueDao(sql2o);
        playerDao = new Sql2oPlayerDao(sql2o);
        sportDao = new Sql2oSportDao(sql2o);
        teamDao = new Sql2oTeamDao(sql2o);
        conn = sql2o.open();

        get("/leagues", "application/json", (req, res) -> {
            return gson.toJson(leagueDao.getAll());
        });

        post("/leagues/new", "application/json", (req, res) -> {
            League league = gson.fromJson(req.body(), League.class);
            leagueDao.add(league);
            res.status(201);
            return gson.toJson(league);
        });

        get("/league/:leagueId", "application/json", (req, res) -> {
            int leagueId = Integer.parseInt(req.params("leagueId"));
            return gson.toJson(leagueDao.findById(leagueId));
        });

        get("/league/:leagueId/delete", "application/json", (req, res) -> {
            int leagueId = Integer.parseInt(req.params("leagueId"));
            leagueDao.deleteById(leagueId);
            return "{\"message\":\"League Deleted\"}";
        });

        post("/league/:leagueId/update", "application/json", (req, res) -> {
            int leagueId = Integer.parseInt(req.params("leagueId"));
            HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
            res.status(201);
            leagueDao.update(leagueId, updateContent);
            return gson.toJson(leagueDao.findById(leagueId));
        });

        get("/players", "application/json", (req, res) -> {
            return gson.toJson(playerDao.getAll());
        });

        post("/players/new", "application/json", (req, res) -> {
            Player player = gson.fromJson(req.body(), Player.class);
            playerDao.add(player);
            res.status(201);
            return gson.toJson(player);
        });

        get("/player/:playerId", "application/json", (req, res) -> {
            int playerId = Integer.parseInt(req.params("playerId"));
            return gson.toJson(playerDao.findById(playerId));
        });

        get("/player/:playerId/delete", "application/json", (req, res) -> {
            int playerId = Integer.parseInt(req.params("playerId"));
            playerDao.deleteById(playerId);
            return "{\"message\":\"Player Deleted\"}";
        });

        post("/player/:playerId/update", "application/json", (req, res) -> {
            int playerId = Integer.parseInt(req.params("playerId"));
            HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
            res.status(201);
            playerDao.update(playerId, updateContent);
            return gson.toJson(playerDao.findById(playerId));
        });

        get("/sports", "application/json", (req, res) -> {
            return gson.toJson(sportDao.getAll());
        });

        post("/sports/new", "application/json", (req, res) -> {
            Sport sport = gson.fromJson(req.body(), Sport.class);
            sportDao.add(sport);
            res.status(201);
            return gson.toJson(sport);
        });

        get("/sport/:sportId", "application/json", (req, res) -> {
            int sportId = Integer.parseInt(req.params("sportId"));
            return gson.toJson(sportDao.findById(sportId));
        });

        get("/sport/:sportId/delete", "application/json", (req, res) -> {
            int sportId = Integer.parseInt(req.params("sportId"));
            sportDao.deleteById(sportId);
            return "{\"message\":\"Sport Deleted\"}";
        });

        post("/sport/:sportId/update", "application/json", (req, res) -> {
            int sportId = Integer.parseInt(req.params("sportId"));
            HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
            res.status(201);
            sportDao.update(sportId, updateContent);
            return gson.toJson(sportDao.findById(sportId));
        });

        get("/teams", "application/json", (req, res) -> {
            return gson.toJson(teamDao.getAll());
        });

        post("/teams/new", "application/json", (req, res) -> {
            Team team = gson.fromJson(req.body(), Team.class);
            teamDao.add(team);
            res.status(201);
            return gson.toJson(team);
        });

        get("/team/:teamId", "application/json", (req, res) -> {
            int teamId = Integer.parseInt(req.params("teamId"));
            return gson.toJson(teamDao.findById(teamId));
        });

        get("/team/:teamId/delete", "application/json", (req, res) -> {
            int teamId = Integer.parseInt(req.params("teamId"));
            teamDao.deleteById(teamId);
            return "{\"message\":\"Team Deleted\"}";
        });

        post("/team/:teamId/update", "application/json", (req, res) -> {
            int teamId = Integer.parseInt(req.params("teamId"));
            HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
            res.status(201);
            teamDao.update(teamId, updateContent);
            return gson.toJson(teamDao.findById(teamId));
        });
    }
}
