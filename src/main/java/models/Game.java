package models;


import java.util.Date;

public class Game {
    private Date gameDay;
    private String field;
    private int leagueId;
    private int headRefId;
    private int otherRefId;
    private int winnerScore;
    private int loserScore;
    private  int winnerId;
    private int id;

    public Game(Date gameDay, String field, int leagueId, int headRefId, int otherRefId) {
        this.gameDay = gameDay;
        this.field = field;
        this.leagueId = leagueId;
        this.headRefId = headRefId;
        this.otherRefId = otherRefId;
    }

    public Date getGameDay() {
        return gameDay;
    }

    public String getField() {
        return field;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public int getHeadRefId() {
        return headRefId;
    }

    public int getOtherRefId() {
        return otherRefId;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getLoserScore() {
        return loserScore;
    }

    public void setLoserScore(int loserScore) {
        this.loserScore = loserScore;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
