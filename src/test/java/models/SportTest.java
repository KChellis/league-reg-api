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
    public void newSportInstantiatesWithName() {
        Sport testSport = setupSport();
        assertEquals("Kickball", testSport.getName());
    }

    @Test
    public void newSportInstantiatesWithPrice() {
        Sport testSport = setupSport();
        assertEquals(80, testSport.getPrice());
    }

    @Test
    public void newSportInstantiatesWithMaxPlayers() {
        Sport testSport = setupSport();
        assertEquals(18, testSport.getMaxPlayers());
    }

    @Test
    public void newSportInstantiatesWithMinPlayers() {
        Sport testSport = setupSport();
        assertEquals(8, testSport.getMinPlayers());
    }

    @Test
    public void newSportInstantiatesWithDuration() {
        Sport testSport = setupSport();
        assertEquals(55, testSport.getDuration());
    }

    @Test
    public void newSportInstantiatesWithRules() {
        Sport testSport = setupSport();
        assertEquals("ruleslink", testSport.getRules());
    }

    @Test
    public void setIdSetsId() {
        Sport testSport = setupSport();
        testSport.setId(1);
        assertEquals(1, testSport.getId());
    }

    public Sport setupSport() {
        Sport sampleSport = new Sport("Kickball", 80, 18, 8, 55, "ruleslink");
        return sampleSport;
    }
}