package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void newTeamInstantiatesCorrectly() {
        Team testTeam = setupTeam();
        assertTrue(testTeam instanceof Team);
    }

    @Test
    public void newTeamInstantiatesWithName() {
        Team testTeam = setupTeam();
        assertEquals("Ingalls", testTeam.getName());
    }

    @Test
    public void newTeamInstantiatesWithColor() {
        Team testTeam = setupTeam();
        assertEquals("Yellow", testTeam.getColor());
    }

    @Test
    public void newTeamInstantiatesWithRegCode() {
        Team testTeam = setupTeam();
        assertEquals("sampleRegCode", testTeam.getRegCode());
    }

    @Test
    public void newTeamInstantiatesWithCaptainId() {
        Team testTeam = setupTeam();
        assertEquals(3, testTeam.getCaptainId());
    }

    @Test
    public void newTeamInstantiatesWithLeagueId() {
        Team testTeam = setupTeam();
        assertEquals(1, testTeam.getLeagueId());
    }

    @Test
    public void newTeamInstantiatesWithWins0() {
        Team testTeam = setupTeam();
        assertEquals(0, testTeam.getWins());
    }

    @Test
    public void setWins() {
        Team testTeam = setupTeam();
        testTeam.setWins(3);
        assertEquals(3, testTeam.getWins());
    }

    @Test
    public void newTeamInstantiatesWithLosses0() {
        Team testTeam = setupTeam();
        assertEquals(0, testTeam.getLosses());
    }

    @Test
    public void setLosses() {
        Team testTeam = setupTeam();
        testTeam.setLosses(4);
        assertEquals(4, testTeam.getLosses());
    }

    @Test
    public void newTeamInstantiatesWithDraws0() {
        Team testTeam = setupTeam();
        assertEquals(0, testTeam.getDraws());
    }

    @Test
    public void setDraws() {
        Team testTeam = setupTeam();
        testTeam.setDraws(2);
        assertEquals(2, testTeam.getDraws());
    }

    @Test
    public void newTeamInstantiatesWithPointsFor0() {
        Team testTeam = setupTeam();
        assertEquals(0, testTeam.getPointsFor());
    }

    @Test
    public void setPointsFor() {
        Team testTeam = setupTeam();
        testTeam.setPointsFor(16);
        assertEquals(16, testTeam.getPointsFor());
    }

    @Test
    public void newTeamInstantiatesWithPointsAgainst0() {
        Team testTeam = setupTeam();
        assertEquals(0, testTeam.getPointsAgainst());
    }

    @Test
    public void setPointsAgainst() {
        Team testTeam = setupTeam();
        testTeam.setPointsAgainst(7);
        assertEquals(7, testTeam.getPointsAgainst());
    }

    @Test
    public void setIdSetsId() {
        Team testTeam = setupTeam();
        testTeam.setPointsAgainst(1);
        assertEquals(1, testTeam.getId());
    }

    public Team setupTeam(){
        Team sampleTeam = new Team("Ingalls", "Yellow", "sampleRegCode", 3, 1);
        return sampleTeam;
    }
}