package dao;

import models.Sport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Sql2oSportDaoTest {
    private Sql2oSportDao sportDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        sportDao = new Sql2oSportDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void getAll_returnsEmptyListIfNoMembers() {
        assertEquals(0, sportDao.getAll().size());
    }

    @Test
    public void add_SetsId() {
        Sport testSport = setupSport();
        assertEquals(1, testSport.getId());
    }

    @Test
    public void getAll_returnsAllSports() {
        Sport testSport = setupSport();
        Sport testSport2 = setupSport2();
        assertEquals(2, sportDao.getAll().size());
    }

    @Test
    public void findById() {
        Sport testSport = setupSport();
        Sport testSport2 = setupSport2();
        assertEquals(testSport2.getName(), sportDao.findById(2).getName());
    }

    @Test
    public void update() {
        Sport testSport = setupSport();
        HashMap<String, Object> updateContent = new HashMap<>();
        updateContent.put("name", "Ping Pong");
        sportDao.update(1, updateContent);
        assertNotEquals(testSport.getName(), sportDao.findById(1).getName());
        assertEquals("Ping Pong", sportDao.findById(1).getName());
    }

    @Test
    public void deleteById() {
        Sport testSport = setupSport();
        Sport testSport2 = setupSport2();
        sportDao.deleteById(1);
        assertEquals(1, sportDao.getAll().size());
        assertEquals("Dodgeball", sportDao.findById(2).getName());
    }

    @Test
    public void clearAllSports() {
        Sport testSport = setupSport();
        Sport testSport2 = setupSport2();
        sportDao.clearAllSports();
        assertEquals(0, sportDao.getAll().size());
    }

    public Sport setupSport(){
        Sport sampleSport = new Sport("Kickball", 80, 18, 8, 55, "ruleslink");
        sportDao.add(sampleSport);
        return sampleSport;
    }

    public Sport setupSport2(){
        Sport sampleSport = new Sport("Dodgeball", 85, 13, 5, 35, "ruleslink");
        sportDao.add(sampleSport);
        return sampleSport;
    }
}