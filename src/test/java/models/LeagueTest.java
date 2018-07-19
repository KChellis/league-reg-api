package models;

import org.junit.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.Assert.*;

public class LeagueTest {

    @Test
    public void newLeagueInstantiatesCorrectly() {
        League testLeague = setupLeague();
        assertTrue(testLeague instanceof League);
    }

    @Test
    public void newLeagueInstantiatesWithName() {
        League testLeague = setupLeague();
        assertEquals("Slow Pitch Kickball", testLeague.getName());
    }

    @Test
    public void newLeagueInstantiatesWithDescription() {
        League testLeague = setupLeague();
        assertEquals("Stuff about a league", testLeague.getDescription());
    }

    @Test
    public void newLeagueInstantiatesWithWeekday() {
        League testLeague = setupLeague();
        assertEquals("Sunday", testLeague.getWeekday());
    }

    @Test
    public void newLeagueInstantiatesWithSportId() {
        League testLeague = setupLeague();
        assertEquals(1, testLeague.getSportId());
    }

    @Test
    public void newLeagueInstantiatesWithField() {
        League testLeague = setupLeague();
        assertEquals("Overlook Park", testLeague.getField());
    }

    @Test
    public void newLeagueInstantiatesWithStartDate() {
        League testLeague = setupLeague();
        assertEquals(new Date(10/12/2018), testLeague.getStartDate());
    }

    @Test
    public void newLeagueInstantiatesWithEarlyTime() {
        League testLeague = setupLeague();
        assertEquals("10:00 AM", testLeague.getEarlyTime());
    }

    @Test
    public void newLeagueInstantiatesWithLateTime() {
        League testLeague = setupLeague();
        assertEquals("5:00 PM", testLeague.getLateTime());
    }

    @Test
    public void newLeagueInstantiatesWithTourneyDay() {
        League testLeague = setupLeague();
        assertEquals(new Date(11/01/2018), testLeague.getTourneyDay());
    }

    @Test
    public void setIdSetsId() {
        League testLeague = setupLeague();
        testLeague.setId(1);
        assertEquals(1, testLeague.getId());
    }

    public League setupLeague(){
        League sampleLeague = new League("Slow Pitch Kickball", "Stuff about a league", "Sunday", 1,"Overlook Park", new Date(10/12/2018), "10:00 AM", "5:00 PM", new Date(11/01/2018));
        return sampleLeague;
    }
}