package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void newPlayerInstantiatesCorrectly() {
        Player testPlayer = setupPlayer();
        assertTrue(testPlayer instanceof Player);
    }

    @Test
    public void newPlayerInstantiatesWithFirstName() {
        Player testPlayer = setupPlayer();
        assertEquals("Kristen", testPlayer.getFirstName());
    }

    @Test
    public void newPlayerInstantiatesWithLastName() {
        Player testPlayer = setupPlayer();
        assertEquals("Chellis", testPlayer.getLastName());
    }

    @Test
    public void newPlayerInstantiatesWithEmail() {
        Player testPlayer = setupPlayer();
        assertEquals("peanutster@gmail.com", testPlayer.getEmail());
    }

    @Test
    public void newPlayerInstantiatesWithShirtSize() {
        Player testPlayer = setupPlayer();
        assertEquals("Small", testPlayer.getShirtSize());
    }

    @Test
    public void newPlayerInstantiatesWithGender() {
        Player testPlayer = setupPlayer();
        assertEquals("female", testPlayer.getGender());
    }

    public Player setupPlayer(){
        Player samplePlayer = new Player("Kristen", "Chellis", "peanutster@gmail.com", "Small", "female");
        return samplePlayer;
    }
}