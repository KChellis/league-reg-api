package models;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void newGameInstantiatesCorrectly() throws Exception {
        Game testGame = setupGame();
        assertTrue(testGame instanceof Game);
    }

    @Test
    public void newGameInstantiatesWithGameDay() throws Exception {
        Game testGame = setupGame();
        assertEquals(new Date(10/20/2018), testGame.getGameDay());
    }

    @Test
    public void newGameInstantiatesWithField() throws Exception {
        Game testGame = setupGame();
        assertEquals("Overlook 2", testGame.getField());
    }

    @Test
    public void newGameInstantiatesWithLeagueId() throws Exception {
        Game testGame = setupGame();
        assertEquals(1, testGame.getLeagueId());
    }

    @Test
    public void newGameInstantiatesWithHeadRefId() throws Exception {
        Game testGame = setupGame();
        assertEquals(1, testGame.getHeadRefId());
    }

    @Test
    public void newGameInstantiatesWithOtherRefId() throws Exception {
        Game testGame = setupGame();
        assertEquals(2, testGame.getOtherRefId());
    }

    @Test
    public void setWinnerScore() throws Exception {
        Game testGame = setupGame();
        testGame.setWinnerScore(10);
        assertEquals(10, testGame.getWinnerScore());
    }

    @Test
    public void setLoserScore() throws Exception {
        Game testGame = setupGame();
        testGame.setLoserScore(5);
        assertEquals(5, testGame.getLoserScore());
    }

    @Test
    public void setWinnerId() throws Exception {
        Game testGame = setupGame();
        testGame.setWinnerId(2);
        assertEquals(2, testGame.getWinnerId());
    }

    @Test
    public void setId() throws Exception {
        Game testGame = setupGame();
        testGame.setId(1);
        assertEquals(1, testGame.getId());
    }

    public Game setupGame(){
        Game testGame = new Game(new Date(10/20/2018), "Overlook 1", 1, 1, 2);
        return testGame;
    }

    public Game setupGame2(){
        Game testGame = new Game(new Date(10/27/2018), "Overlook 2", 1, 3, 4);
        return testGame;
    }

}