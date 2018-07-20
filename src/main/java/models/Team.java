package models;

import java.util.Objects;

public class Team {
    private String name;
    private String color;
    private String regCode;
    private int captainId;
    private int leagueId;
    private int wins;
    private int losses;
    private int draws;
    private int pointsFor;
    private int pointsAgainst;
    private int id;


    public Team(String name, String color, String regCode, int captainId, int leagueId) {
        this.name = name;
        this.color = color;
        this.regCode = regCode;
        this.captainId = captainId;
        this.leagueId = leagueId;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.pointsFor = 0;
        this.pointsAgainst = 0;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getRegCode() {
        return regCode;
    }

    public int getCaptainId() {
        return captainId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(int pointsFor) {
        this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return captainId == team.captainId &&
                leagueId == team.leagueId &&
                wins == team.wins &&
                losses == team.losses &&
                draws == team.draws &&
                pointsFor == team.pointsFor &&
                pointsAgainst == team.pointsAgainst &&
                Objects.equals(name, team.name) &&
                Objects.equals(color, team.color) &&
                Objects.equals(regCode, team.regCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, color, regCode, captainId, leagueId, wins, losses, draws, pointsFor, pointsAgainst);
    }
}
