package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportTest {

    @Test
    public void newSportInstantiatesCorrectly() {
        Sport testSport = setupSport();
        assertTrue(testSport instanceof Sport);
    }

    @Test
    public void newTeamInstantiatesWithName() {
        Sport testSport = setupSport();
        assertEquals("Kickball", testSport.getName());
    }

    @Test
    public void newTeamInstantiatesWithPrice() {
        Sport testSport = setupSport();
        assertEquals(80, testSport.getPrice());
    }

    @Test
    public void newTeamInstantiatesWithMaxPlayers() {
        Sport testSport = setupSport();
        assertEquals(18, testSport.getMaxPlayers());
    }

    @Test
    public void newTeamInstantiatesWithMinPlayers() {
        Sport testSport = setupSport();
        assertEquals(8, testSport.getMinPlayers());
    }

    @Test
    public void newTeamInstantiatesWithDuration() {
        Sport testSport = setupSport();
        assertEquals(55, testSport.getDuration());
    }

    @Test
    public void newTeamInstantiatesWithRules() {
        Sport testSport = setupSport();
        assertEquals("ruleslink", testSport.getRules());
    }

    public Sport setupSport() {
        Sport sampleSport = new Sport("Kickball", 80, 18, 8, 55, "ruleslink");
        return sampleSport;
    }
}