package dao;

import models.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;


public class Sql2oGameDaoTest {
    private Sql2oGameDao gameDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        gameDao = new Sql2oGameDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void getAll_returnsEmptyListIfNoMembers() {
        assertEquals(0, gameDao.getAll().size());
    }

    @Test
    public void add_SetsId() {
        Game testGame = setupGame();
        assertEquals(1, testGame.getId());
    }

    @Test
    public void getAll_returnsAllGames() {
        Game testGame = setupGame();
        Game testGame2 = setupGame2();
        assertEquals(2, gameDao.getAll().size());
    }

    @Test
    public void findById_returnsCorrectGame() {
        Game testGame = setupGame();
        Game testGame2 = setupGame2();
        assertEquals(testGame2.getField(), gameDao.findById(2).getField());
    }

    @Test
    public void findByLeague_returnsGamesByLeague() throws Exception {
        Game testGame = setupGame();
        Game testGame2 = setupGame2();
        Game testGame3 = setupGame();
        assertEquals(2, gameDao.findByLeague(1).size());
    }
    

    @Test
    public void update() {
        Game testGame = setupGame();
        HashMap<String, Object> updateContent = new HashMap<>();
        updateContent.put("field", "Glenhaven 1");
        gameDao.update(1, updateContent);
        assertNotEquals(testGame.getField(), gameDao.findById(1).getField());
        assertEquals("Glenhaven 1", gameDao.findById(1).getField());
    }

    @Test
    public void deleteById() {
        Game testGame = setupGame();
        Game testGame2 = setupGame2();
        gameDao.deleteById(1);
        assertEquals(1, gameDao.getAll().size());
        assertEquals("Overlook 2", gameDao.findById(2).getField());
    }

    @Test
    public void clearAllGames() {
        Game testGame = setupGame();
        Game testGame2 = setupGame2();
        gameDao.clearAllGames();
        assertEquals(0, gameDao.getAll().size());
    }

    public Game setupGame(){
        Game testGame = new Game(new Date(10/20/2018), "Overlook 1", 1, 1, 2);
        return testGame;
    }

    public Game setupGame2(){
        Game testGame = new Game(new Date(10/27/2018), "Overlook 2", 2, 3, 4);
        return testGame;
    }
}