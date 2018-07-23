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
import java.util.List;

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
            List<League> allLeagues = leagueDao.getAll();
            if(allLeagues.size() == 0){
                res.status(404);
                return "{\"message\":\"Sorry there are no leagues currently.\"}";
            }else{
                return gson.toJson(allLeagues);
            }

        });

        post("/leagues/new", "application/json", (req, res) -> {
            try {
                League league = gson.fromJson(req.body(), League.class);
                leagueDao.add(league);
                res.status(201);
                return gson.toJson(league);
            } catch(Error error) {
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/leagues/:leagueId", "application/json", (req, res) -> {
            try {
                int leagueId = Integer.parseInt(req.params("leagueId"));
                League currentLeague = leagueDao.findById(leagueId);
                if(currentLeague != null){
                    return gson.toJson(currentLeague);
                } else {
                    res.status(404);
                    return "{\"message\":\"League not found\"}";
                }
            } catch ( Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }
        });

        get("/leagues/:leagueId/delete", "application/json", (req, res) -> {
            try{
                int leagueId = Integer.parseInt(req.params("leagueId"));
                leagueDao.deleteById(leagueId);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        post("/leagues/:leagueId/update", "application/json", (req, res) -> {
            try{
                int leagueId = Integer.parseInt(req.params("leagueId"));
                League currentLeague = leagueDao.findById(leagueId);
                if (currentLeague != null){
                    HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
                    res.status(201);
                    leagueDao.update(leagueId, updateContent);
                    return gson.toJson(leagueDao.findById(leagueId));
                } else{
                    res.status(404);
                    return "{\"message\":\"League not found\"}";
                }

            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/players", "application/json", (req, res) -> {
            List<Player> allPlayers = playerDao.getAll();
            if(allPlayers.size() == 0){
                res.status(404);
                return "{\"message\":\"Sorry there are no players currently.\"}";
            }else{
                return gson.toJson(allPlayers);
            }

        });

        post("/players/new", "application/json", (req, res) -> {
            try {
                Player player = gson.fromJson(req.body(), Player.class);
                playerDao.add(player);
                res.status(201);
                return gson.toJson(player);
            } catch(Error error) {
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/players/:playerId", "application/json", (req, res) -> {
            try {
                int playerId = Integer.parseInt(req.params("playerId"));
                Player currentPlayer = playerDao.findById(playerId);
                if(currentPlayer != null){
                    return gson.toJson(currentPlayer);
                } else {
                    res.status(404);
                    return "{\"message\":\"Player not found\"}";
                }
            } catch ( Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }
        });

        get("/players/:playerId/delete", "application/json", (req, res) -> {
            try{
                int playerId = Integer.parseInt(req.params("playerId"));
                playerDao.deleteById(playerId);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        post("/players/:playerId/update", "application/json", (req, res) -> {
            try{
                int playerId = Integer.parseInt(req.params("playerId"));
                Player currentPlayer = playerDao.findById(playerId);
                if (currentPlayer != null){
                    HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
                    res.status(201);
                    playerDao.update(playerId, updateContent);
                    return gson.toJson(playerDao.findById(playerId));
                } else{
                    res.status(404);
                    return "{\"message\":\"Player not found\"}";
                }

            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/sports", "application/json", (req, res) -> {
            List<Sport> allSports = sportDao.getAll();
            if(allSports.size() == 0){
                res.status(404);
                return "{\"message\":\"Sorry there are no sports currently.\"}";
            }else{
                return gson.toJson(allSports);
            }

        });

        post("/sports/new", "application/json", (req, res) -> {
            try {
                Sport sport = gson.fromJson(req.body(), Sport.class);
                sportDao.add(sport);
                res.status(201);
                return gson.toJson(sport);
            } catch(Error error) {
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/sports/:sportId", "application/json", (req, res) -> {
            try {
                int sportId = Integer.parseInt(req.params("sportId"));
                Sport currentSport = sportDao.findById(sportId);
                if(currentSport != null){
                    return gson.toJson(currentSport);
                } else {
                    res.status(404);
                    return "{\"message\":\"Sport not found\"}";
                }
            } catch ( Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }
        });

        get("/sports/:sportId/leagues", "application/json", (req, res) -> {
            try {
                int sportId = Integer.parseInt(req.params("sportId"));
                Sport currentSport = sportDao.findById(sportId);
                List<League> leaguesBySport = leagueDao.findBySport(sportId);
                if(leaguesBySport.size() > 0){
                    return gson.toJson(leaguesBySport);
                } else {
                    res.status(404);
                    return "{\"message\":\"No leagues match this sportgit\"}";
                }
            } catch ( Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }
        });

        get("/sports/:sportId/delete", "application/json", (req, res) -> {
            try{
                int sportId = Integer.parseInt(req.params("sportId"));
                sportDao.deleteById(sportId);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        post("/sports/:sportId/update", "application/json", (req, res) -> {
            try{
                int sportId = Integer.parseInt(req.params("sportId"));
                Sport currentSport = sportDao.findById(sportId);
                if (currentSport != null){
                    HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
                    res.status(201);
                    sportDao.update(sportId, updateContent);
                    return gson.toJson(sportDao.findById(sportId));
                } else{
                    res.status(404);
                    return "{\"message\":\"Sport not found\"}";
                }

            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/teams", "application/json", (req, res) -> {
            List<Team> allTeams = teamDao.getAll();
            if(allTeams.size() == 0){
                res.status(404);
                return "{\"message\":\"Sorry there are no teams currently.\"}";
            }else{
                return gson.toJson(allTeams);
            }

        });

        post("/teams/new", "application/json", (req, res) -> {
            try {
                Team team = gson.fromJson(req.body(), Team.class);
                teamDao.add(team);
                res.status(201);
                return gson.toJson(team);
            } catch(Error error) {
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        get("/teams/:teamId", "application/json", (req, res) -> {
            try {
                int teamId = Integer.parseInt(req.params("teamId"));
                Team currentTeam = teamDao.findById(teamId);
                if(currentTeam != null){
                    return gson.toJson(currentTeam);
                } else {
                    res.status(404);
                    return "{\"message\":\"Team not found\"}";
                }
            } catch ( Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }
        });

        get("/teams/:teamId/delete", "application/json", (req, res) -> {
            try{
                int teamId = Integer.parseInt(req.params("teamId"));
                teamDao.deleteById(teamId);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        post("/teams/:teamId/update", "application/json", (req, res) -> {
            try{
                int teamId = Integer.parseInt(req.params("teamId"));
                Team currentTeam = teamDao.findById(teamId);
                if (currentTeam != null){
                    HashMap<String, Object> updateContent = gson.fromJson(req.body(), HashMap.class);
                    res.status(201);
                    teamDao.update(teamId, updateContent);
                    return gson.toJson(teamDao.findById(teamId));
                } else{
                    res.status(404);
                    return "{\"message\":\"Team not found\"}";
                }

            } catch (Error error){
                res.status(400);
                return "{\"message\":\"Sorry your request could not be processed\"}";
            }

        });

        after((request, response) -> {
            response.type("application/json");
        });
    }
}
