package dao;

import models.League;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Sql2oLeagueDaoTest {
    private Sql2oLeagueDao leagueDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        leagueDao = new Sql2oLeagueDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void getAll_returnsEmptyListIfNoMembers() {
        assertEquals(0, leagueDao.getAll().size());
    }

    @Test
    public void add_SetsId() {
        League testLeague = setupLeague();
        assertEquals(1, testLeague.getId());
    }

    @Test
    public void getAll_returnsAllLeagues() {
        League testLeague = setupLeague();
        League testLeague2 = setupLeague2();
        assertEquals(2, leagueDao.getAll().size());
    }

    @Test
    public void findById_returnsCorrectLeague() {
        League testLeague = setupLeague();
        League testLeague2 = setupLeague2();
        assertEquals(testLeague2.getName(), leagueDao.findById(2).getName());
    }

    @Test
    public void findBySport_returnsLeaguesBySport() throws Exception {
        League testLeague = setupLeague();
        League testLeague2 = setupLeague2();
        League testLeague3 = setupLeague();
        assertEquals(2, leagueDao.findBySport(1).size());
    }

    @Test
    public void update() {
        League testLeague = setupLeague();
        HashMap<String, Object> updateContent = new HashMap<>();
        updateContent.put("name", "Hosford Kickball");
        leagueDao.update(1, updateContent);
        assertNotEquals(testLeague.getName(), leagueDao.findById(1).getName());
        assertEquals("Hosford Kickball", leagueDao.findById(1).getName());
    }

    @Test
    public void deleteById() {
        League testLeague = setupLeague();
        League testLeague2 = setupLeague2();
        leagueDao.deleteById(1);
        assertEquals(1, leagueDao.getAll().size());
        assertEquals("Fast Pitch Kickball", leagueDao.findById(2).getName());
    }

    @Test
    public void clearAllLeagues() {
        League testLeague = setupLeague();
        League testLeague2 = setupLeague2();
        leagueDao.clearAllLeagues();
        assertEquals(0, leagueDao.getAll().size());
    }

    public League setupLeague(){
        League sampleLeague = new League("Slow Pitch Kickball", "Stuff about a league", "Sunday", 1,"Overlook Park", new Date(10/12/2018), "10:00 AM", "5:00 PM", new Date(11/01/2018));
        leagueDao.add(sampleLeague);
        return sampleLeague;
    }

    public League setupLeague2(){
        League sampleLeague = new League("Fast Pitch Kickball", "Stuff about a second league", "Monday", 2,"Glenhaven Park", new Date(10/13/2018), "11:00 AM", "4:00 PM", new Date(11/02/2018));
        leagueDao.add(sampleLeague);
        return sampleLeague;
    }
}