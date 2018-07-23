package dao;

import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {
    private Sql2oTeamDao teamDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void getAll_returnsEmptyListIfNoMembers() {
        assertEquals(0, teamDao.getAll().size());
    }

    @Test
    public void add_SetsId() {
        Team testTeam = setupTeam();
        assertEquals(1, testTeam.getId());
    }

    @Test
    public void getAll_returnsAllTeams() {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        assertEquals(2, teamDao.getAll().size());
    }

    @Test
    public void findById() {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        assertEquals(testTeam2.getName(), teamDao.findById(2).getName());
    }

    @Test
    public void findByLeague_returnsTeamsByLeague() throws Exception {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        Team testTeam3 = setupTeam();
        assertEquals(2, teamDao.findByLeague(1).size());
    }

    @Test
    public void update() {
        Team testTeam = setupTeam();
        HashMap<String, Object> updateContent = new HashMap<>();
        updateContent.put("name", "Totally Into This Sport");
        teamDao.update(1, updateContent);
        assertNotEquals(testTeam.getName(), teamDao.findById(1).getName());
        assertEquals("Totally Into This Sport", teamDao.findById(1).getName());
    }

    @Test
    public void deleteById() {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        teamDao.deleteById(1);
        assertEquals(1, teamDao.getAll().size());
        assertEquals("Not-So-Super Heroes", teamDao.findById(2).getName());
    }

    @Test
    public void clearAllTeams() {
        Team testTeam = setupTeam();
        Team testTeam2 = setupTeam2();
        teamDao.clearAllTeams();
        assertEquals(0, teamDao.getAll().size());
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