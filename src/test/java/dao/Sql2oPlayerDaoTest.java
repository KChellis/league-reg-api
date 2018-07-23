package dao;

import models.Player;
import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Sql2oPlayerDaoTest {
    private Sql2oPlayerDao playerDao;
    private Sql2oTeamDao teamDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        playerDao = new Sql2oPlayerDao(sql2o);
        teamDao = new Sql2oTeamDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void getAll_returnsEmptyListIfNoMembers() {
        assertEquals(0, playerDao.getAll().size());
    }

    @Test
    public void add_SetsId() {
        Player testPlayer = setupPlayer();
        assertEquals(1, testPlayer.getId());
    }

    @Test
    public void addPlayerToTeam() throws Exception {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        Player testPlayer = setupPlayer();
        Player testPlayer2 = setupPlayer2();

        playerDao.addPlayerToTeam(testPlayer.getId(), testTeam.getId());
        playerDao.addPlayerToTeam(testPlayer2.getId(), testTeam.getId());

        assertEquals(2, playerDao.findByTeam(testTeam.getId()).size());
        assertEquals(0, playerDao.findByTeam(testTeam2.getId()).size());
    }

    @Test
    public void getAll_returnsAllPlayers() {
        Player testPlayer = setupPlayer();
        Player testPlayer2 = setupPlayer2();
        assertEquals(2, playerDao.getAll().size());
    }

    @Test
    public void findById() {
        Player testPlayer = setupPlayer();
        Player testPlayer2 = setupPlayer2();
        assertEquals(testPlayer2.getFirstName(), playerDao.findById(2).getFirstName());
    }

    @Test
    public void update() {
        Player testPlayer = setupPlayer();
        HashMap<String, Object> updateContent = new HashMap<>();
        updateContent.put("firstName", "Sarah");
        playerDao.update(1, updateContent);
        assertNotEquals(testPlayer.getFirstName(), playerDao.findById(1).getFirstName());
        assertEquals("Sarah", playerDao.findById(1).getFirstName());
    }

    @Test
    public void deleteById() {
        Player testPlayer = setupPlayer();
        Player testPlayer2 = setupPlayer2();
        playerDao.deleteById(1);
        assertEquals(1, playerDao.getAll().size());
        assertEquals("David", playerDao.findById(2).getFirstName());
    }

    @Test
    public void clearAllPlayers() {
        Player testPlayer = setupPlayer();
        Player testPlayer2 = setupPlayer2();
        playerDao.clearAllPlayers();
        assertEquals(0, playerDao.getAll().size());
    }

    public Player setupPlayer(){
        Player samplePlayer = new Player("Kristen", "Chellis", "peanutster@gmail.com", "Small", "female");
        playerDao.add(samplePlayer);
        return samplePlayer;
    }

    public Player setupPlayer2(){
        Player samplePlayer = new Player("David", "Riley", "someemail@gmail.com", "Large", "male");
        playerDao.add(samplePlayer);
        return samplePlayer;
    }

    public Team setupTeam(){
        Team sampleTeam = new Team("Ingalls", "Yellow", "sampleRegCode", 3, 1);
        teamDao.add(sampleTeam);
        return sampleTeam;
    }

    public Team setupTeam2(){
        Team sampleTeam = new Team("Not-So-Super Heroes", "Gray", "sampleRegCode", 5, 2);
        teamDao.add(sampleTeam);
        return sampleTeam;
    }
}